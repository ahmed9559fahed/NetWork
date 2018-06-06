package NetWork.Data.Database.Models;
public class NetworkAddress
{
    public NetworkAddress(String iPAddress ,int prefix)
    {
        IPAddress=iPAddress;
        Prefix=prefix;
    }
    public NetworkAddress()
    {

    }

    private int Id;
    private String IPAddress;
    private int Prefix;
    private String BitFormat;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setBitFormat(String bitFormat) {
        BitFormat = bitFormat;
    }

    public String getBitFormat() {
        return BitFormat;
    }

    public String getIPAddress()
    {
        return this.IPAddress;
    }
    public void setIPAddress(String ip)
    {
        this.IPAddress=ip;
    }
    public int getPrefix()
    {
        return this.Prefix;
    }
    public void setPrefix(int prefix)
    {
        this.Prefix=prefix;
    }
    public int GetId()
    {
        return this.Id;
    }
}
