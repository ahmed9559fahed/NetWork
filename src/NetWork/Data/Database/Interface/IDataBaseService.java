package NetWork.Data.Database.Interface;

import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;

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
