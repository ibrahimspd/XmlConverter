package entites;

import java.util.ArrayList;
import java.util.List;

public class Person
{
    private final String firstName;
    private final String lastName;
    private final List<Phone> phones;

    private final List<Adress> addresses;
    private final List<Family> families;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = new ArrayList<>();
        this.addresses = new ArrayList<>();
        this.families = new ArrayList<>();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public List<Adress> getAddresses()
    {
        return addresses;
    }

    public List<Family> getFamilies()
    {
        return families;
    }
    public void addPhone(String mobile, String landline)
    {
        phones.add(new Phone(mobile, landline));
    }
    public void addAddress(Adress address)
    {
        addresses.add(address);
    }
    public void addFamily(Family family)
    {
        families.add(family);
    }

}
