import webbrowser
import ftplib
import gzip
import csv
import sqlite3
from datetime import datetime
from time import sleep
from string import Template
import subprocess
import requests
import json
import re
import sys
import os
import errno
import shutil
#import logging
from Bio import Entrez
Entrez.email = "A.N.Other@example.com"

################################################################################
################################################################################


# Connecting to R to utilize GEOquery package to download specified data set
def get_geo_series_matrix(accession):
    if re.search('^GSE\d{4,}', accession):
        print("GSE Attribute Accepted")
    elif re.search('^gse\d{4,}', accession):
       sys.exit("Please ensure 'GEO' is in capitals")
    else:
        #logging.error("Exception occurred", exc_info=True)
        sys.exit("Please enter a valid GEO GSE Accession number")
    # Creating sample.db database with sample_attributes table using SQLite3
    # Temporary hard coded database to be replaced in future with larger DB when DSL expanded to other analyses
    # Stored within /tmp directory as not a permanent data repository
    print("Creating Database...")
    conn = sqlite3.connect("/tmp/sample.db")
    cursor = conn.cursor()
    cursor.execute("""CREATE TABLE IF NOT EXISTS sample_attributes
                   (repo_name STRING, series_acc STRING, sample_acc STRING, attr_name STRING, attr_val STRING)
                    """)
    print("...success. Stored in /tmp directory")
    print("Connecting to Entrez Database...")
    search_handle = Entrez.esearch(db="gds", term=accession+"[All Fields] AND \"gse\"[Filter]", usehistory="y")
    search_results = Entrez.read(search_handle)
    search_handle.close()
    webenv = search_results["WebEnv"]
    query_key = search_results["QueryKey"]
    handle = Entrez.efetch(db="gds", retstart=0, retmax=1, webenv=webenv, query_key=query_key)
    result = handle.read()

    # Using the Bio.entrez package to handle the data downloaded within the R GEOquery package
    start_FTP_field = result.find("FTP download:")
    start_ftp_addr = result.find("ftp://", start_FTP_field)
    end_ftp_addr = result.find("\n", start_ftp_addr)
    ftp_addr = result[start_ftp_addr:end_ftp_addr]+"matrix/"
    dir_name_start = ftp_addr.find("/geo/")
    dir_name = ftp_addr[dir_name_start:]
    zip_file_name = accession + "_series_matrix.txt.gz"
    file_name = accession + "_series_matrix.txt"

    sess = ftplib.FTP("ftp.ncbi.nlm.nih.gov", timeout=10)
    #Suppressing log level for FTP connection to Entrez
    #sess.set_debuglevel(1)
    sess.login()
    sess.cwd(dir_name)
    try:
        print("Searching for "+accession+"...")
        sess.retrbinary("RETR " + zip_file_name, open("/tmp/" + zip_file_name, "wb").write)
    except ftplib.error_perm:
        sys.exit("Cannot locate Accession "+accession+"\nPlease check your Accession number is correct/exists and try again")
    print("Successfully found "+accession)
    sess.quit()
    print("[" + dir_name + zip_file_name + "] transferred OK to [" + "/tmp/" + zip_file_name + "]")

    # Opens downloaded .zip file to extract data for storage within sample.db
    zippedFileDescriptor = gzip.open("/tmp/" + zip_file_name, "rb")
    unZippedFileDescriptor = open("/tmp/" + file_name, "wb")
    decodedContent = zippedFileDescriptor.read()
    unZippedFileDescriptor.write(decodedContent)

    zippedFileDescriptor.close()
    unZippedFileDescriptor.close()

    with open ("/tmp/" + file_name, 'r') as infile:
        lines = infile.readlines()

    with open ("/tmp/" + file_name, 'w') as infile:
        for line in lines:
            line = line.replace("'", " ")
            infile.write(line)

    with open("/tmp/" + file_name, newline='') as f:
        attr_name_list = []
        attr_val_list = []
        sample_accession_list = []
        reader = csv.reader(f, delimiter='\t')
        in_sample_info = False
        for row in reader:
            if not row:
                continue
            if (not in_sample_info) and (row[0] == "!Sample_title"):
                in_sample_info = True
            elif in_sample_info and (row[0] == "!series_matrix_table_begin"):
                in_sample_info = False
                break
            elif in_sample_info:
                row_title, * row_content = row
                attr_name_start = len("!Sample_")
                attr_name = row_title[attr_name_start:]
                if attr_name == "geo_accession":
                    sample_accession_list = row_content
                else:
                    attr_name_list.append(attr_name)
                    attr_val_list.append(row_content)

    # Open sample.db database to enter data from GEO for analysis with Limma
    conn = sqlite3.connect('/tmp/sample.db')
    c = conn.cursor()
    print("Handling "+accession+" for group creation...")
    
    row_idx = 0                        
    for attr_name in attr_name_list:

        col_idx = 0
        for sample_acc in sample_accession_list:
            attr_val = attr_val_list[row_idx][col_idx]
            c.execute("INSERT INTO sample_attributes \
                       VALUES(\'{}\', \'{}\', \'{}\', \'{}\', \'{}\')"
                      .format("GEO", accession, sample_acc, attr_name, attr_val))
            col_idx += 1
        
        row_idx += 1

    conn.commit()
    conn.close()

    return sample_accession_list


# Setting the group critera for the data to allow for differential gene expression analysis within R Limma
def apply_group_criterion(repo, series, name, operator, value):
    conn = sqlite3.connect('/tmp/sample.db')
    c = conn.cursor()
    result_set = set()
    if operator == '=':
        c.execute("SELECT sample_acc FROM sample_attributes \
                    WHERE (repo_name = \'%s\' \
                    AND series_acc = \'%s\' \
                    AND attr_name = \'%s\' \
                    AND attr_val = \'%s\')"
                  % (repo, series, name, value))
        sql_result = c.fetchall()
        for (sample_accession,) in sql_result:
            result_set.add(sample_accession)
            
    return result_set


def evaluate_group_criteria(repo, series, stack):
    top, *rest = stack
    if (top == 'and') or (top == 'or'):
        (left_set, right_criterion) = evaluate_group_criteria(repo, series, rest)
        (right_set, remainder) = evaluate_group_criteria(repo, series, right_criterion)
        if top == 'and':
            result_set = left_set & right_set
        elif top == 'or':
            result_set = left_set | right_set
    else:
        name = stack[0]
        operator = stack[1]
        value = stack[2]
        remainder = stack[3:]
        result_set = apply_group_criterion(repo, series, name, operator, value)
    return result_set, remainder


def apply_gene_list_criterion(row, name, operator, value):
    id_to_column = {'FDR': 2, 'probe_id': 1, 'symbol': 7, 'logFC': 6, }
    name_index = id_to_column[name]
    result = True
    if operator == '<':
        if abs(float(row[name_index])) >= abs(float(value)):
            result = False
    elif operator == '<=':
        if abs(float(row[name_index])) > abs(float(value)):
            result = False
    elif operator == '>=':
        if abs(float(row[name_index])) < abs(float(value)):
            result = False
    elif operator == '>':
        if abs(float(row[name_index])) <= abs(float(value)):
            result = False

    return result


def evaluate_gene_list_criteria(row, stack):
    top, *rest = stack
    if (top == 'and') or (top == 'or'):
        (left_set, right_criterion) = evaluate_gene_list_criteria(row, rest)
        (right_set, remainder) = evaluate_gene_list_criteria(row, right_criterion)
        if top == 'and':
            result = left_set & right_set
        elif top == 'or':
            result = left_set | right_set
    else:
        name = stack[0]
        operator = stack[1]
        value = stack[2]
        remainder = stack[3:]
        result = apply_gene_list_criterion(row, name, operator, value)
    return result, remainder


def sample_ids_to_str(sample_list):
    sample_list_str = "\"" + sample_list[0] + "\""
    for sample_str in sample_list[1:]:
        sample_list_str += ", \"" + sample_str + "\""
    return sample_list_str


# Connecting to the R Limma script to carry out differential gene expression analysis
def calc_differentials(series, name, samples): #filter_expr
    #print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])
    with open("limmaTemplate.rTmpl", "r") as f:
        template = Template(f.read())
        sample_names = [sample_ids_to_str(s) for s in samples]
        script_str = template.substitute(SERIES_ACCESSION=series,
                                         PLATFORM="\"GPL570\"",
                                         GROUP_ZERO=sample_names[0],
                                         GROUP_CONTRAST=sample_names[1],
                                         DENAME=name)
        # FDRVAL=filter_expr
    with open("limmaScript.R", "w") as f:
        f.write(script_str)
    print("Running R to find differential expressions...")
    output = subprocess.call(["/usr/bin/Rscript", "limmaScript.R"])
    print("...Done")
    #print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])


# A list of Up Regulated and another list of Down Regulated genes are created for input into QUADrAtiC
def create_gene_lists(differential_expression, filter_expr):
    print("Creating gene lists from differential expression data...")
    id_to_column = { 'FDR': 2, 'probe_id': 1, 'LogFC': 6, 'symbol': 7,}
    with open("/tmp/" + differential_expression + ".csv", newline='') as f:
        up_list_probes = []
        down_list_probes = []
        up_list_symbols = []
        down_list_symbols = []
        is_header = True
        reader = csv.reader(f, delimiter=',')
        for row in reader:
            row_ok = True
            if is_header:
                is_header = False
                headings = row
                continue
            if not row:
                continue
            row_ok, ignore = evaluate_gene_list_criteria(row, filter_expr)
            if row_ok:
                if float(row[id_to_column['LogFC']]) > 0:
                    up_list_probes.append(row[id_to_column['probe_id']])
                else:
                    down_list_probes.append(row[id_to_column['probe_id']])
    return up_list_probes, down_list_probes
    print("...Gene lists created")

def compileResults():
    print("Compiling Differential Expression Results...")
    userhome = os.path.expanduser('~')
    desktop = userhome + '/Desktop/'
    name = "RecVsNonRecGlioma"
    results = (desktop + 'microBioLect - ' + name)
    results2 = (results+"2")
    if os.path.isdir(results):
        print("This analysis has been performed before")
        print("Would you like to overwrite your previous results?")
        ow = input("y or n: ")
        if ow == "y":
            shutil.rmtree(results)
            os.makedirs(results)
        elif ow == "n":
            os.makedirs(results2)
            results = results2
        else:
            print("Invalid input, please enter y or n")
            compileResults()
    else:
        os.makedirs(results)
    decsv = ("/tmp/" + name + "_de.csv")
    allcsv = ("/tmp/" + name + ".csv")
    volcanopng = ("/tmp/" + name + "_volcano.png")
    heatpng = ("/tmp/" + name + "_heatmap.png")
    try:
        shutil.move(decsv, results)
        shutil.move(allcsv, results)
        shutil.move(volcanopng, results)
        shutil.move(heatpng, results)
    except FileNotFoundError:
        print("One of the results files is missing")

    return [desktop, name, results]


# Connecting to QUADrATiC to carry out Connectivity Map Analysis
# Must ensure QUADRaTiC server is running on local system for successful connection
def create_connection_lists(connection_list, gene_list):
    print("Creating Connection List via QUADrATiC...")
    print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])
    up_probes = gene_list.get_up_probes()
    down_probes = gene_list.get_down_probes()
    create_sig_request_body = {'id': connection_list.get_gene_list(), 'probes': {}}
    for probe in up_probes:
        create_sig_request_body['probes'][probe] = 1
    for probe in down_probes:
        create_sig_request_body['probes'][probe] = -1
    try:
        requests.post('http://localhost:8090/api/sigs', data=json.dumps(create_sig_request_body))
    except requests.exceptions.ConnectionError:
        sys.exit("Please ensure you have an instance of QUADrATiC running. You can still find the results from your DGE Analysis")
    create_job_request_body = {'id': connection_list.get_gene_list(), 'sigId': connection_list.get_gene_list(),
                               'datasetId': 'Drug_Name+Cell_Line', 'nRands': 2000, 'notes': 'Automated from microBioLect v1.1'}
    requests.post('http://localhost:8090/api/jobs', data=json.dumps(create_job_request_body))
    still_processing = True
    while still_processing:
        sleep(30)
        run_state = requests.get('http://localhost:8090/api/jobs/' + connection_list.get_gene_list()).json()['state']
        if run_state != "IN_PROGRESS":
            still_processing = False
    result_list = requests.get('http://localhost:8090/api/results/' + connection_list.get_gene_list()).json()['resultList']
    p_threshold = 1.0 / float(len(result_list))
    significant = []
    for result in result_list:
        if (result['pVal'] < p_threshold) and (result['rawCs'] < 0) and (connection_list.get_direction() == 'negative'):
            significant.append(result)
        elif (result['pVal'] < p_threshold) and (result['rawCs'] > 0) and (connection_list.get_direction() == 'positive'):
            significant.append(result)
        elif (result['pVal'] < p_threshold) and (connection_list.get_direction() == 'all'):
            significant.append(result)
    connection_list.set_results(significant)
    print("...Navigate to 'Visualize Results' to view output")
    url = 'http://localhost:8090/'
    webbrowser.open_new(url)
    print("QUADrATiC Analysis Complete")
    print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])


    print("Results can be found on Desktop in anlaysis specific microBioLect folder")
    print("MicroarrayDSL Analysis Complete!")
    print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])


        
################################################################################
################################################################################
