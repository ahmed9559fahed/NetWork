package NetWork.Database.Service;
import NetWork.Database.Interface.IDataBaseService;
import NetWork.Database.Models.Host;
import NetWork.Database.Models.NetworkAddress;
import NetWork.Database.Models.SubnetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.util.ArrayList;

public class DataBaseService implements IDataBaseService {


    private Connection connection;
    @Override
    public boolean Connect()
    {
        try
        {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName); // here is the ClassNotFoundException
            String serverName = "localhost";
            String mydatabase = "ipcalculater";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            return true;
        }
        catch (Exception ex)
        {
        System.out.println(ex.getMessage());
        return false;
        }

    }

    @Override
    public boolean DisConnect() {
       try
       {
           connection.close();
           return true;
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());return false ;
       }
    }



    @Override
    public ArrayList<NetworkAddress> Get_NETWORK_ADDRESSES() {

        try {
            Connect();
            ArrayList<NetworkAddress> networks = new ArrayList<NetworkAddress>();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM network");

            while (result.next())
            {
                NetworkAddress network = new NetworkAddress();
                network.SetIPAddress(result.getString(2));
                network.SetPrefix(result.getInt(3));
                networks.add(network);
            }
            result.close();
            stmt.close();
            DisConnect();
            return networks;

        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return null;
        }
    }



    @Override
    public ArrayList<SubnetAddress> Get_SubnetAddresses(int netWorkId) {
        return null;
    }

    @Override
    public ArrayList<Host> Get_Hosts(int subNetId) {
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
