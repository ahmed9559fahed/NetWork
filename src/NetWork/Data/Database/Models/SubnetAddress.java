package NetWork.Data.Database.Models;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Interface.IDatabaseModel;

public class SubnetAddress implements IDatabaseModel {
    public SubnetAddress(int networkId,String subNetAddress,int hosts,int prefix)
    {
        NetworkId = networkId;
        SubnetAddress = subNetAddress;
        Hosts = hosts;
        Prefix=prefix;
    }

    public SubnetAddress() { }

    private int Id;
    private String SubnetAddress;
    private int Hosts;
    private int NetworkId;
    private int Prefix;
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


    public int getHosts() {
        return this.Hosts;
    }

    public void setHosts(int hosts) {
        this.Hosts = hosts;
    }

    public void setPrefix(int prefix) {Prefix = prefix;}

    public int getPrefix() {return Prefix;}
}
