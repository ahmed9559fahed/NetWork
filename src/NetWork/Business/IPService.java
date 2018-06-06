package NetWork.Business;

import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class IPService implements IPServiceInterface {

    protected DatabaseService databaseService;

    public IPService() {
        databaseService = DatabaseService.getService();
    }

    @Override
    public boolean AddNetwork(NetworkAddress networkAddress)
    {
        if(databaseService.AddNetwork(networkAddress)!=-1)
            return true;
        return false;
    }

    @Override
    public boolean AddSubnet(SubnetAddress subnet) {
        if(databaseService.AddSubnet(subnet)!=-1)
            return true;
        return false;
    }

    @Override
    public boolean AddHost(Host host) {
        if(databaseService.AddHost(host)!=-1)
            return true;
        return false;
    }

    @Override
    public ArrayList<NetworkAddress> GetNetworks() {
        return databaseService.GetNetworkAddresses();
    }

    @Override
    public ArrayList<SubnetAddress> GetSubnetsByNetworkId(int networkId) {
        return databaseService.GetSubnetAddresses(networkId);
    }

    @Override
    public ArrayList<Host> GetHostsBySubnetId(int subnetId) {
        return databaseService.GetHosts(subnetId);
    }

    @Override
    public boolean DeleteNetworkById(int networkId) {
        return databaseService.DeleteNetworkById(networkId);
    }

    @Override
    public boolean DeleteSubnetById(int subnetId) {
        return databaseService.DeleteSubnetById(subnetId);
    }

    @Override
    public boolean DeleteHostById(int hostId) {
        return databaseService.DeleteHostById(hostId);
    }
}
