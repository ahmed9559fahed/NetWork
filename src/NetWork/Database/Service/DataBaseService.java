package NetWork.Database.Service;

import NetWork.Database.Interface.IDataBaseService;
import NetWork.Database.Models.Host;
import NetWork.Database.Models.NetworkAddress;
import NetWork.Database.Models.SubnetAddress;

import java.util.ArrayList;

public class DataBaseService implements IDataBaseService {

    private static String ConnectionString="";
    @Override
    public boolean Connect() {
        return false;
    }

    @Override
    public ArrayList<NetworkAddress> Get_NETWORK_ADDRESSES() {
        return null;
    }

    @Override
    public ArrayList<SubnetAddress> Get_SubnetAddresses(String netWorkId) {
        return null;
    }

    @Override
    public ArrayList<Host> Get_Hosts(String subNetId) {
        return null;
    }

    @Override
    public boolean CreateNetWork(NetworkAddress network) {
        return false;
    }

    @Override
    public boolean CreateSubNets(ArrayList<SubnetAddress> subnetAddresses) {
        return false;
    }

    @Override
    public boolean CreateHosts(ArrayList<Host> hosts) {
        return false;
    }
}
