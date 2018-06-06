package NetWork.Data.Database.Models;
public class SubnetAddress {

    public SubnetAddress(int networkId,String subNetAddress,String networkClass,int hosts)
    {

        NetworkId = networkId;
        SubnetAddress = subNetAddress;
        NetworkClass = networkClass;
        Hosts = hosts;
    }

    public SubnetAddress() { }

    private int Id;
    private String SubnetAddress;
    private String NetworkClass;
    private int Hosts;
    private int NetworkId;
    private String BitFormat;

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setBitFormat(String bitFormat) {
        this.BitFormat = bitFormat;
    }

    public String getBitFormat() {
        return this.BitFormat;
    }

    public void setNetworkId(int networkId) {
        this.NetworkId = networkId;
    }

    public int getNetworkId() {
        return this.NetworkId;
    }

    public String getSubnetAddress()
    {
        return this.SubnetAddress;
    }

    public void setSubnetAddress(String ip)
    {
        this.SubnetAddress = ip;
    }

    public String getNetworkClass()
    {
        return this.NetworkClass;
    }

    public void setNetworkClass(String networkClass)
    {
        this.NetworkClass = networkClass;
    }

    public int getHosts() {
        return this.Hosts;
    }

    public void setHosts(int hosts) {
        this.Hosts = hosts;
    }

}
