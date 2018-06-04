package NetWork.Database.Models;
import java.util.UUID;
public class NetworkAddress
{
    public NetworkAddress(String iPAddress ,int prefix)
    {
        Id=UUID.randomUUID()+"";
        IPAddress=iPAddress;
        Prefix=prefix;
    }

    private String Id;
    private String IPAddress;
    private int Prefix;

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
    public String GetId()
    {
        return this.Id;
    }
    public void SetId(String id)
    {
        this.Id=id;
    }
}
