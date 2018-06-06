package NetWork.Business;

import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DataBaseService;

import java.util.ArrayList;

public class IPService implements IPServiceInterface {

    @Override
    public boolean AddNetwork(NetworkAddress networkAddress)
    {
        DataBaseService service=new DataBaseService();
        if(service.AddNetWork(networkAddress)!=-1)
            return true;
        return false;
    }

    @Override
    public boolean AddSubnet(SubnetAddress subnet) {
        DataBaseService service=new DataBaseService();
        if(service.AddSubNet(subnet)!=-1)
            return true;
        return false;
    }

    @Override
    public boolean AddHost(Host host) {
        DataBaseService service=new DataBaseService();
        if(service.AddHost(host)!=-1)
            return true;
        return false;
    }

    @Override
    public ArrayList<NetworkAddress> GetNetworks() {
        DataBaseService service=new DataBaseService();
        return service.Get_NETWORK_ADDRESSES();
    }

    @Override
    public ArrayList<SubnetAddress> GetSubnetsByNetworkId(int networkId) {
        DataBaseService service=new DataBaseService();
        return service.Get_SubnetAddresses(networkId);
    }

    @Override
    public ArrayList<Host> GetHostsBySubnetId(int subnetId) {
        DataBaseService service=new DataBaseService();
        return service.Get_Hosts(subnetId);
    }

    @Override
    public boolean DeleteNetworkById(int networkId) {
        DataBaseService service=new DataBaseService();
        return service.DeleteNetWorkById(networkId);
    }

    @Override
    public boolean DeleteSubnetById(int subnetId) {
        DataBaseService service=new DataBaseService();
        return service.DeleteSubNetById(subnetId);
    }

    @Override
    public boolean DeleteHostById(int hostId) {
        DataBaseService service=new DataBaseService();
        return service.DeleteHostById(hostId);
    }
}
