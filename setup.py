import setuptools
import os

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="microBioLect",
    version="0.0.1",
    author="Jessica Blair",
    author_email="jblair22@qub.ac.uk",
    description="A natural language syntax domain specific language tool for simple and automated analysis "
                "of microarray data",
    url="https://github.com/JessBlairQUB/BioLect",
    packages=setuptools.find_packages(),
    classifiers=["Programming Language :: Python :: 3",
                 "License :: ",
                 "Operating System :: Linux",
                 ],

)
