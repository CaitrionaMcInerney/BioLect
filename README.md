# BioLect (Biological Dialect) #

## microBioLect for Microarray Differential Gene Expression Analysis ##

### * Early Version Terminal Tool * ###

**About**
microBioLect is a domain specific language (DSL) designed to be as close to natural spoken syntax as possible.
This allows for ease of mircoarray analysis for those unfamiliar with programming while improving repeatability of analyses.

### Requirements ###

**Operating Systems**
1. Linux Ubuntu 14.04 and upwards
2. Mac OS Mojave 10.14 and upwards

**Language Requirements**
1. Python 3.4
2. R

**Other Requirements**
An instance of [QUADrATiC](https://bmcbioinformatics.biomedcentral.com/articles/10.1186/s12859-016-1062-1 "QUADrATiC") installed and running.

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
3. You can create differential groups which group several characteristics. Please see the testGlioma.txt file for an example.
3. Once you have completed your script, press enter twice and the analysis will begin.

### Restrictions ###
Due to restrictions with QUADrATiC, microBioLect is designed to work with datasets obtained from the Affymetrix Human Genome U133 Plus 2.0 Array only.
