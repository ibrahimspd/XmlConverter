package entites;

public class Adress
{
    private String street;
    private String city;
    private String zipCode;

    public Adress(String street, String city, String zipCode)
    {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
}
