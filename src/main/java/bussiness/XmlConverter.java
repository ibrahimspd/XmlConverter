package bussiness;

import entites.Adress;
import entites.Family;
import entites.Person;
import entites.Phone;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlConverter
{
    private final String content;
    private List<Person> people;

    public XmlConverter(String content)
    {
        this.content = content;
    }

    public void convert()
    {
        List<Person> people = new ArrayList<>();
        String[] lines = content.split("\\r?\\n");
        boolean family = false;
        Person person = null;
        for (String line : lines)
        {
            String[] parts = line.split("\\|");
            Person last = null;
            if (person != null)
            {
                last = people.get(people.size() - 1);
            }

            switch (parts[0])
            {
                case "P":
                    person = new Person(parts[1], parts[2]);
                    people.add(person);
                    family = false;
                    break;
                case "T":
                    if (person == null)
                    {
                        throw new RuntimeException("No person");
                    }
                    if (family)
                    {
                        last.getFamilies().get(last.getFamilies().size() - 1).setPhone(new Phone(parts[1], parts[2]));
                    } else
                    {
                        people.get(people.size() - 1).addPhone(parts[1], parts[2]);
                    }
                    break;
                case "A":
                    if (person == null)
                    {
                        throw new RuntimeException("No person");
                    }
                    Adress adress;
                    if (parts.length == 4)
                    {
                        adress = new Adress(parts[1], parts[2], parts[3]);
                    } else if (parts.length == 3)
                    {
                        adress = new Adress(parts[1], parts[2], "");
                    } else if (parts.length == 2)
                    {
                        adress = new Adress(parts[1], "", "");
                    } else
                    {
                        adress = new Adress("", "", "");
                    }
                    if (family)
                    {
                        last.getFamilies().get(last.getFamilies().size() - 1).setAdress(adress);
                    } else
                    {
                        people.get(people.size() - 1).addAddress(adress);
                    }
                    break;
                case "F":
                    family = true;
                    if (person == null)
                    {
                        break;
                    }
                    if (parts.length == 3)
                    {
                        people.get(people.size() - 1).addFamily(new Family(parts[1], parts[2]));
                        break;
                    } else if (parts.length == 2)
                    {
                        people.get(people.size() - 1).addFamily(new Family(parts[1], ""));
                        break;
                    } else
                    {
                        people.get(people.size() - 1).addFamily(new Family("", ""));
                        break;
                    }
            }
        }
        this.people = people;

    }

    public void xmlWriter(String path)
    {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("people");

        for (Person person : this.people)
        {
            Element personElement = root.addElement("person");
            personElement.addElement("firstname").addText(person.getFirstName());
            personElement.addElement("lastname").addText(person.getLastName());
            Element phoneElement = personElement.addElement("phone");
            for (Phone phone : person.getPhones())
            {
                Element mobileElement = phoneElement.addElement("mobile");
                mobileElement.addText(phone.getMobile());
                Element landlineElement = phoneElement.addElement("landline");
                landlineElement.addText(phone.getLandLine());
            }
            Element addressElement = personElement.addElement("address");
            for (Adress address : person.getAddresses())
            {
                Element streetElement = addressElement.addElement("street");
                streetElement.addText(address.getStreet());
                Element cityElement = addressElement.addElement("city");
                cityElement.addText(address.getCity());
                Element postcodeElement = addressElement.addElement("postcode");
                postcodeElement.addText(address.getZipCode());
            }

            for (Family family : person.getFamilies())
            {
                Element familyElement = personElement.addElement("family");
                Element nameElement = familyElement.addElement("name");
                nameElement.addText(family.getName());
                Element bornElement = familyElement.addElement("born");
                bornElement.addText(family.getBorn());
                Adress address = family.getAdress();
                if (address != null)
                {
                    Element familyAddressElement = familyElement.addElement("address");
                    Element streetElement = familyAddressElement.addElement("street");
                    streetElement.addText(address.getStreet());
                    Element cityElement = familyAddressElement.addElement("city");
                    cityElement.addText(address.getCity());
                    Element postcodeElement = familyAddressElement.addElement("postcode");
                    postcodeElement.addText(address.getZipCode());
                }
                Phone phone = family.getPhone();
                if (phone != null)
                {
                    Element familyPhoneElement = familyElement.addElement("phone");
                    Element mobileElement = familyPhoneElement.addElement("mobile");
                    mobileElement.addText(phone.getMobile());
                    Element landlineElement = familyPhoneElement.addElement("landline");
                    landlineElement.addText(phone.getLandLine());
                }
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path)))
        {
            document.write(bufferedWriter);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
