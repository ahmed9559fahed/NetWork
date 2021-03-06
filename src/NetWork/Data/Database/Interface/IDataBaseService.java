package NetWork.Data.Database.Interface;

import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;

import java.util.ArrayList;

public interface IDataBaseService {

    boolean Connect();
    boolean Disconnect();

    ArrayList<NetworkAddress> GetNetworkAddresses();
    ArrayList<SubnetAddress> GetSubnetAddresses(int netWorkId);
    ArrayList<Host> GetHosts(int subNetId);
    SubnetAddress GetSubnetAddressById(int subnetId);
    NetworkAddress GetNetworkAddressById(int networktId);
    boolean DeleteHostBySubnetID(int sibnetId);
    boolean DeleteAllSubnetByNetworkID(int networkId);
    int AddNetwork(NetworkAddress network);
    int AddSubnet(SubnetAddress subnetAddress);
    int AddHost(Host host);

    boolean DeleteNetworkById(int networkId);
    boolean DeleteSubnetById(int subnetAddressId);
    boolean DeleteHostById(int hostId);
    Device GetDeviceById(int deviceId);



}
