package NetWork.Data.Database.Service;
import NetWork.Data.Database.Interface.IDataBaseService;
import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
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
                network.setId(result.getInt(1));
                network.SetIPAddress(result.getString(2));
                network.SetPrefix(result.getInt(3));
                network.setBitFormat(result.getString(4));
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
    public ArrayList<SubnetAddress> Get_SubnetAddresses(int netWorkId)
    {
        try {
            Connect();
            ArrayList<SubnetAddress> subnets = new ArrayList<SubnetAddress>();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM subnet where NetworkID ="+netWorkId);

            while (result.next())
            {
                SubnetAddress subnet = new SubnetAddress();
                subnet.setId(result.getInt(1));
                subnet.SetNetworkClasse(result.getString(4));
                subnet.setSubNetAddress(result.getString(2));
                subnet.setNetworkId1(netWorkId);
                subnet.setBitFormat(result.getString(5));
                subnets.add(subnet);
            }
            result.close();
            stmt.close();
            DisConnect();
            return subnets;

        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public ArrayList<Host> Get_Hosts(int subNetId)
    {
        try {
            Connect();
            ArrayList<Host> hosts = new ArrayList<Host>();
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM host where SubnetID ="+subNetId);

            while (result.next())
            {
                Host host = new Host();
                host.setId(result.getInt(1));
                host.setSubNetsId(subNetId);
                host.setIPAddress(result.getString(2));
                host.setBitFormat(result.getString(6));
                host.setDescription(result.getString(5));
                host.setDeviceID(result.getInt(4));
                hosts.add(host);
            }
            result.close();
            stmt.close();
            DisConnect();
            return hosts;

        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public int AddNetWork(NetworkAddress network)
    {
        try {
            Connect();

            Statement stmt = connection.createStatement();

            String insertTableSQL = "INSERT INTO network"
                    + "(IP , Prefix , BitFormat ) "
                    + "VALUES"
                    + "('"
                    +network.GetIPAddress()
                    +"',"
                    +network.GetPrefix()
                    +",'"
                    +network.getBitFormat()
                    +"')";
            PreparedStatement  pstmt = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
            //stmt.executeUpdate(insertTableSQL);
            DisConnect();
            return generatedKey;

        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return -1;
        }

    }

    @Override
    public int AddSubNet(SubnetAddress subnetAddress) {
        try {
            Connect();

            String insertTableSQL = "INSERT INTO subnet"
                    + "(IP , NetworkID ,Class, BitFormat ) "
                    + "VALUES"
                    + "('"
                    +subnetAddress.GetSubNetAddress()
                    +"',"
                    +subnetAddress.getNetworkId1()
                    +",'"
                    +subnetAddress.GetNetworkClasse()
                    +"','"
                    +subnetAddress.getBitFormat()
                    +"')";

            PreparedStatement  pstmt = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
            //stmt.executeUpdate(insertTableSQL);
            DisConnect();
            return generatedKey;


        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public int AddHost(Host host) {
        try {
            Connect();

            String insertTableSQL = "INSERT INTO host"
                    + "(IP , SubnetID ,Descreption, BitFormat,DeviceID ) "
                    + "VALUES"
                    + "('"
                    +host.getIPAddress()
                    +"',"
                    +host.getSubNetsId()
                    +",'"
                    +host.getDescription()
                    +"','"
                    +host.getBiTFormat()
                    +"','"
                    +host.getDeviceID()
                    +"')";

            PreparedStatement  pstmt = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.execute();
            ResultSet rs = pstmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
            //stmt.executeUpdate(insertTableSQL);
            DisConnect();
            return generatedKey;


        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public boolean DeleteNetWorkById(int networkId) {
        try {
            Connect();

            String deleteNetworkSql = "Delete From network where ID="+networkId;
            ArrayList<SubnetAddress> subnets=Get_SubnetAddresses(networkId);
            Connect();
            Statement  stmt = connection.createStatement();
            for (SubnetAddress subnet :subnets)
            {
                String deleteHostSql = "Delete From host where SubnetID="+subnet.getId();
                stmt.execute(deleteHostSql);
            }
            String deleteSubnetSql = "Delete From subnet where NetworkID="+networkId;

            stmt.execute(deleteSubnetSql);
            stmt.execute(deleteNetworkSql);
            stmt.close();
            DisConnect();
            return true;
        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean DeleteSubNetById(int subnetAddressId) {
        try {
            Connect();

            String deleteSubnetSql = "Delete From subnet where ID="+subnetAddressId;
            String deleteHostSql = "Delete From host where SubnetID="+subnetAddressId;
            Statement  stmt = connection.createStatement();
            stmt.execute(deleteHostSql);
            stmt.execute(deleteSubnetSql);
            stmt.close();
            DisConnect();
            return true;
        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean DeleteHostById(int hostId) {
        try {
            Connect();

            String deleteTableSQL = "Delete From host where ID="+hostId;

            Statement  stmt = connection.createStatement();
            stmt.execute(deleteTableSQL);
            stmt.close();
            DisConnect();
            return true;
                    }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Device GetDeviceById(int deviceId)
    {

        try {
            Connect();

            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Device where ID ="+deviceId);

                Device device = new Device();
                device.setId(deviceId);
                device.setName(result.getString(2));

            result.close();
            stmt.close();
            DisConnect();
            return device;

        }
        catch (Exception ex)
        {
            DisConnect();
            System.out.println(ex.getMessage());
            return null;
        }

    }

}
