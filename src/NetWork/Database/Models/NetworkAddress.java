package NetWork.Database.Models;
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

    public void setBitFormat(String bitFormat) {
        BitFormat = bitFormat;
    }

    public String getBitFormat() {
        return BitFormat;
    }

    public String GetIPAddress()
    {
        return this.IPAddress;
    }
    public void SetIPAddress(String ip)
    {
        this.IPAddress=ip;
    }
    public int GetPrefix()
    {
        return this.Prefix;
    }
    public void SetPrefix(int prefix)
    {
        this.Prefix=prefix;
    }
    public int GetId()
    {
        return this.Id;
    }
}
