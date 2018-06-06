package NetWork.Database.Interface;

import NetWork.Database.Models.Device;
import NetWork.Database.Models.Host;
import NetWork.Database.Models.NetworkAddress;
import NetWork.Database.Models.SubnetAddress;

import java.util.ArrayList;

public interface IDataBaseService {

    boolean Connect();
    boolean DisConnect();
    ArrayList<NetworkAddress> Get_NETWORK_ADDRESSES();
    ArrayList<SubnetAddress> Get_SubnetAddresses(int netWorkId);
    ArrayList<Host> Get_Hosts(int subNetId);
    int AddNetWork(NetworkAddress network);
    int AddSubNet(SubnetAddress subnetAddress);
    int AddHost(Host host);
    boolean DeleteNetWorkById(int networkId);
    boolean DeleteSubNetById(int subnetAddressId);
    boolean DeleteHostById(int hostId);
    Device GetDeviceById(int deviceId);



}
