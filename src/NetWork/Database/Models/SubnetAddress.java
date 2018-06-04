package NetWork.Database.Models;
import java.util.UUID;
public class SubnetAddress {

    public SubnetAddress(String networkId,String subNetAddress,String networkClass,int hosts)
    {
        Id=UUID.randomUUID()+"";
        NetworkId1 = networkId;
        SubNetAddress=subNetAddress;
        NetworkClass =networkClass;
        Hosts=hosts;
    }
    private String Id;
    private String SubNetAddress;
    private String NetworkClass;
    private int Hosts;
    private String NetworkId1;


    public String getNetworkId1() {
        return NetworkId1;
    }

    public String GetSubNetAddress()
    {
        return this.SubNetAddress;
    }

    public void SetSubNetAddress(String ip)
    {
        this.SubNetAddress=ip;
    }

    public String GetNetworkClasse()
    {
        return this.NetworkClass;
    }

    public void SetNetworkClasse(String networkClasse)
    {
        this.NetworkClass =networkClasse;
    }

    public int getHosts() {
        return Hosts;
    }

    public void setHosts(int hosts) {
        Hosts = hosts;
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
