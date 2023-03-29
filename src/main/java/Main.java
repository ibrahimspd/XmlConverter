import bussiness.XmlConverter;

import java.io.File;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Usage: java <jar> <file> <output.xml>");
            exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists())
        {
            System.out.println("File does not exist");
            exit(1);
        }
        if (!file.isFile())
        {
            System.out.println("Path is not a file");
            exit(1);
        }
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                sb.append(scanner.nextLine()).append(System.lineSeparator());

            }
            XmlConverter converter = new XmlConverter(sb.toString());
            converter.convert();
            converter.xmlWriter(args[1]);
        } catch (Exception e)
        {
            System.out.println("Error reading file");
            exit(1);
        }
    }
}
