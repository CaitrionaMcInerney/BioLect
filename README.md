# BioLect (Biological Dialect) #

## microBioLect for Microarray Differential Gene Expression Analysis ##

### * Early Version Terminal Tool (Docker Version coming soon!) * ###

**About**
microBioLect is a domain specific language (DSL) designed to be as close to natural spoken syntax as possible.
This allows for ease of mircoarray analysis for those unfamiliar with programming while improving repeatability of anlyses.

### Requirements ###

**Operating Systems**
Linux Ubuntu 14.04 and upwards
Mac OS Mojave 10.14 and upwards

**Language Requirements**
Python 3.4
R

**Other Requirements**
An instance of [Named Link](https://bmcbioinformatics.biomedcentral.com/articles/10.1186/s12859-016-1062-1 "QUADrATiC") installed and running.

### Quick Start Guide ###

**Installation**
1. From the 'dist'folder, download the microBioLect-0.0.1.tar.gz file
2. Download the microBioLect.sh file
3. Place both of these files within the same directory
4. From the terminal, navigate using the cd command to the directory containing microBioLect
5. initialise microBioLect with the following command './microBioLect.sh'

**Writing a microBioLect Script**
1. Within the terminal, write your microBioLect Script. You will need to know the following:
    a. The GEO accession number of the dataset you wish to download and analyse
    b. The characteristics from the dataset you wish to compare. These can be found within the series matrix.txt file which can be viewed on the GEO website.
2. For each new line of the script, press enter
3. Once you have completed your script, press enter twice and the analysis will begin.

### Restrictions ###
