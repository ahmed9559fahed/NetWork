package NetWork.Data.Database.Models;
public class SubnetAddress {

    public SubnetAddress(int networkId,String subNetAddress,String networkClass,int hosts)
    {

        NetworkId1 = networkId;
        SubNetAddress=subNetAddress;
        NetworkClass =networkClass;
        Hosts=hosts;
    }
    public SubnetAddress()
    {

    }
    private int Id;
    private String SubNetAddress;
    private String NetworkClass;
    private int Hosts;
    private int NetworkId1;
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

    public void setNetworkId1(int networkId1) {
        NetworkId1 = networkId1;
    }

    public void setSubNetAddress(String subNetAddress) {
        SubNetAddress = subNetAddress;
    }

    public int getNetworkId1() {
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

    public int GetId()
    {
        return this.Id;
    }

}
