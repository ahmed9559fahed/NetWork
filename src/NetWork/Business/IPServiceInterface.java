package NetWork.Business;

import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DataBaseService;

import java.util.ArrayList;

public interface IPServiceInterface {
    boolean AddNetwork(NetworkAddress networkAddress);
    boolean AddSubnet(SubnetAddress subnet);
    boolean AddHost(Host host);
    ArrayList<NetworkAddress> GetNetworks();
    ArrayList<SubnetAddress> GetSubnetsByNetworkId(int networkId);
    ArrayList<Host> GetHostsBySubnetId(int subnetId);
    boolean DeleteNetworkById(int networkId);
    boolean DeleteSubnetById(int subnetId);
    boolean DeleteHostById(int hostId);

}
