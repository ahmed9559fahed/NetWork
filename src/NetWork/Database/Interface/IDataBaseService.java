package NetWork.Database.Interface;

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
    boolean CreateNetWork(NetworkAddress network);
    boolean CreateSubNets(ArrayList<SubnetAddress> subnetAddresses);
    boolean CreateHosts(ArrayList<Host> hosts);


}