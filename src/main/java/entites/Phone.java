package entites;

public class Phone
{
    private final String mobile;
    private final String landLine;

    public Phone(String mobile, String landLine)
    {
        this.mobile = mobile;
        this.landLine = landLine;
    }

    public String getMobile()
    {
        return mobile;
    }

    public String getLandLine()
    {
        return landLine;
    }
}
