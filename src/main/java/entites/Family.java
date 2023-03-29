package entites;

public class Family
{
    private final String name;
    private final String born;
    private Adress adress;
    private Phone phone;

    public Family(String name, String born)
    {
        this.name = name;
        this.born = born;
    }

    public String getName()
    {
        return name;
    }

    public String getBorn()
    {
        return born;
    }

    public Phone getPhone()
    {
        return phone;
    }

    public void setPhone(Phone phone)
    {
        this.phone = phone;
    }

    public Adress getAdress()
    {
        return adress;
    }

    public void setAdress(Adress adress)
    {
        this.adress = adress;
    }
}
