import Bio
import antlr4
import json
import socket
from datetime import datetime
import logging
from Bio import Entrez
from DSLModel import *
from ccrcbDSLLexer import ccrcbDSLLexer
from ccrcbDSLParser import ccrcbDSLParser
from ccrcbDSLVisitor import ccrcbDSLVisitor
from antlr4.error.ErrorListener import ErrorListener
from builtins import input


Bio.Entrez.email = "A.N.Other@example.com"


class MyEncoder(json.JSONEncoder):
    def default(self, obj):
        if not isinstance(obj, Analysis):
            return super(MyEncoder, self).default(obj)

        return obj.__dict__


class ccrcbDSLVisitorImpl(ccrcbDSLVisitor):

    def __init__(self):
        self._analysis = Analysis('Test')
        self._object_model_context = None

    def prettyprint(self):
        print(json.dumps(self._analysis, default=lambda o: o.__dict__))

    def update(self):
        self._analysis.resolve()

    def _format_string_or_id(self, s):
        if s[0] == '\"':
            return s[1:-1]
        else:
            return s

    # Visit a parse tree produced by ccrcbDSLParser#use_spec.
    def visitData_spec(self, ctx):
        try:
            dataset_name = ctx.dataset_id.text
        except AttributeError:
            sys.exit("Please include your GEO accession number")
        d = Dataset(dataset_name)
        print("Data set successfully named")
        self._analysis.add_dataset(d)
        self._object_model_context = d
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#repository_spec.
    def visitRepository_spec(self, ctx):
        self._object_model_context.set_repository(ctx.repository_id.text)
        self._object_model_context.set_identifier(ctx.dataset_id.text)
        if ctx.repository_id.text == 'GEO':
            self._object_model_context.set_data(dslUtils.get_geo_series_matrix(ctx.dataset_id.text))
        elif ctx.repository_id.text == "SRA":
            self._object_model_context.set_data(dslUtils.get_sra_metadata(ctx.dataset_id.text))
        self._object_model_context = None
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#local_spec.
    def visitLocal_spec(self, ctx):
        self._object_model_context.set_repository('local')
        self._object_model_context.set_identifier(ctx.directory.text[1:-1])
        self._object_model_context = None
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#filter_spec.
    def visitFilter_spec(self, ctx):
        source_datatype = ctx.datatype_spec().getText()
        if ctx.entity().getText() == 'group':
            g = ExpressionGroup(ctx.entity_id.text, ctx.dataset_id.text)
            self._analysis.add_group(g)
        elif ctx.entity().getText() == 'gene list':
            g = GeneList(ctx.entity_id.text, ctx.dataset_id.text)
            self._analysis.add_gene_list(g)
        self._object_model_context = g
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#logical_criteria.
    def visitLogical_criteria(self, ctx):
        if ctx.operator:
            self._object_model_context.add_filter_term(ctx.operator.text)
        elif ctx.comparator:
            self._object_model_context.add_filter_term(self._format_string_or_id(ctx.name.text))
            self._object_model_context.add_filter_term(ctx.comparator.text)
            self._object_model_context.add_filter_term(self._format_string_or_id(ctx.value.text))

        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#diff_expr_spec.
    def visitDiff_expr_spec(self, ctx):
        de = DifferentialExpressionList(ctx.dexpr_id.text)
        self._analysis.add_diff_expr_list(de)
        self._object_model_context = de
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#contrast.
    def visitContrast(self, ctx):
        self._object_model_context.add_group(ctx.group0.text)
        self._object_model_context.add_group(ctx.group1.text)
        return self.visitChildren(ctx)

    # Visit a parse tree produced by ccrcbDSLParser#cmap_spec.
    def visitCmap_spec(self, ctx):
        name = ctx.gene_list.text + '_' + ctx.conn_type_spec().getText()
        c = ConnectionList(name, ctx.gene_list.text, ctx.conn_type_spec().getText())
        self._analysis.add_connection_list(c)
        return self.visitChildren(ctx)

    def run(self):
        self._analysis.run()

# First pass error catching of input file
# Provides line where error found and what it was expecting instead
class InputErrorListener (ErrorListener):

    def __init__(self):
        super(InputErrorListener, self).__init__()

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        print("In line "+str(line)+" of input: Syntax error, " + str(msg))
        #print("Error: "+str(e))
        sys.exit("Please check your input for missing and/or misspelt terms, or missing symbols")
        #print("halting translation")
        #sys.exit("Please check your input for any missing values")
        #print("Creating Error Report")

    def reportAmbiguity(self, recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs):
        print("Ambiguity error, " + str(configs))

    def reportAttemptingFullContext(self, recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs):
        print("Attempting full context error, " + str(configs))

    def reportContextSensitivity(self, recognizer, dfa, startIndex, stopIndex, prediction, configs):
        print("Context error, " + str(configs))


################################################################################
################################################################################


################################################################################
################################################################################


def get_analysisScript():
    scriptname = input("Please name your microBioLect analysis and press enter: \n")
    print('Please enter your microBioLect script: \n')
    line_holder = []
    while True:
        line = input("\n")
        if line:
            line_holder.append(line)
        else:
            break
        with open ('%s.txt' % scriptname, 'w') as f:
            for line in line_holder:
                f.write("%s\n" % line)
    return scriptname


#Logging file creation.
#logging.basicConfig(filename="test.log", level=logging.DEBUG)

# Main method taking input stream from text file, builds tree of parsed input
# Text file containing Antlr4 Grammar input commands for gene expression analysis using QUADrATiC


def main():
    print(datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])
    print("Welcome to microBioLect")
    scriptname = get_analysisScript()
    try:
        input = antlr4.FileStream("%s.txt" %scriptname)
        #input = antlr4.FileStream("GSE36000.txt")
    except FileNotFoundError:
        logging.error("Exception occurred", exc_info=True)
        sys.exit("Please ensure your input file is correct")
    print("Reading Grammar input from txt file...")
    lexer = ccrcbDSLLexer(input)
    stream = antlr4.CommonTokenStream(lexer)
    parser = ccrcbDSLParser(stream)
    parser._listeners = [InputErrorListener()]
    visitor_impl = ccrcbDSLVisitorImpl()
    lexer.removeErrorListeners()
    lexer._listeners = [InputErrorListener()]

    #Checking for internet connection
    try:
        print("Checking internet connection")
        socket.create_connection(("www.google.com", 80))
    except OSError:
        print("No internet connection found")
        sys.exit("Please ensure you have a functioning internet connection to proceed")

    tree = parser.recipe()
    # Now visit all nodes in the parse tree, using the Visitor Pattern
    # Building up the object model representation of the analysis from the DSL
    visitor_impl.visit(tree)
    visitor_impl.update()
    #Suppressing printing groups to console
    #visitor_impl.prettyprint()
    # Given the object model, run the analysis
    visitor_impl.run()
    #print("QUADrATiC Analysis Complete")


if __name__ == '__main__':
    main()


# Potential here for replacing txt. input with scanner with check points confirming input
# What about String Matching/Checking?

