# XML Converter

This program converts data from a file in a specified format to an XML file. The input file can be in a specific format, and the output file will be in XML format.

## How to Run
To use this program, you must have Maven and Java installed on your system. Once you have installed these, follow these steps:

Clone or download the repository to your local machine.
Open a terminal or command prompt and navigate to the root directory of the project.
Run the command mvn clean install to build the project.
Navigate to the target directory.
Run the command java -jar xml-converter-1.0-SNAPSHOT.jar input-file output-file to convert your input file to an XML file. Replace input-file with the path to your input file, and output-file with the path where you want to save your output file.
For example, if your input file is located at /path/to/input.txt and you want to save your output file as output.xml, you would run the command:

```lua
java -jar xml-converter-1.0-SNAPSHOT.jar /path/to/input.txt output.xml
```
## Input File Format
### The input file should be a text file with each line representing a piece of information for a person or family. The format of each line is as follows:

#### P|firstname|lastname - specifies the first and last name of a person.
#### T|mobile|landline - specifies the mobile and landline phone numbers of a person.
#### A|street|city|zipcode - specifies the street, city, and zip code of a person or family.
#### F|name|year - specifies the name and birth year of a family.
#### Each line starts with a character indicating what type of information is being provided (P, T, A, or F). The lines for a person must start with P, and may be followed by any combination of T, A, and F lines. The lines for a family must start with F, and may be followed by T and A lines.

## Output File Format
The output file will be an XML file with the following format:

````xml

<people>
    <person>
        <firstname>...</firstname>
        <lastname>...</lastname>
        <phone>
            <mobile>...</mobile>
            <landline>...</landline>
        </phone>
        <address>
            <street>...</street>
            <city>...</city>
            <zipcode>...</zipcode>
        </address>
        <family>
            <name>...</name>
            <year>...</year>
            <address>...</address>
        </family>
        ...
    </person>
    ...
</people>
````