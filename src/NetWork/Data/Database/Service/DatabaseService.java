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

public class DatabaseService implements IDataBaseService {

    private Connection connection;

    private final static String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static DatabaseService instance = null;

    protected String ServerHost = "localhost";
    protected String ServerDatabase = "test";
    protected String ServerUsername = "root";
    protected String ServerPassword = "root";

    public DatabaseService() {
        this.Connect();
    }

    protected void finalize()
    {
        this.Disconnect();
    }

    public static DatabaseService getService() {
        if(DatabaseService.instance == null) {
            DatabaseService.instance = new DatabaseService();
        }

        return DatabaseService.instance;
    }


    @Override
    public boolean Connect()
    {
        try
        {
            String driverName = DATABASE_DRIVER;
            Class.forName(driverName); // here is the ClassNotFoundException

            String url = "jdbc:mysql://" + this.ServerHost + "/" + this.ServerDatabase + "?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            this.connection = DriverManager.getConnection(url, this.ServerUsername, this.ServerPassword);

            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean Disconnect() {
       try
       {
           this.connection.close();
           return true;
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
           return false ;
       }
    }

    @Override
    public ArrayList<NetworkAddress> GetNetworkAddresses() {

        try {
            ArrayList<NetworkAddress> networks = new ArrayList<>();

            Statement stmt = this.connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM network");

            while (result.next())
            {
                NetworkAddress network = new NetworkAddress();

                network.setId(result.getInt(1));
                network.setIPAddress(result.getString(2));
                network.setPrefix(result.getInt(3));
                network.setBitFormat(result.getString(4));

                networks.add(network);
            }

            result.close();
            stmt.close();

            return networks;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public NetworkAddress GetNetworkAddressById(int networkId)
    {
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM network where id= " + networkId);
            result.first();

            NetworkAddress network = new NetworkAddress();

            network.setId(result.getInt(1));
            network.setIPAddress(result.getString(2));
            network.setPrefix(result.getInt(3));
            network.setBitFormat(result.getString(4));

            result.close();
            stmt.close();

            return network;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public ArrayList<SubnetAddress> GetSubnetAddresses(int networkId)
    {
        try {
            ArrayList<SubnetAddress> subnets = new ArrayList<>();

            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM subnet where network_id =" + String.valueOf(networkId));

            while (result.next())
            {
                SubnetAddress subnet = new SubnetAddress();

                subnet.setId(result.getInt(1));
                subnet.setPrefix(result.getInt(4));
                subnet.setSubnetAddress(result.getString(2));
                subnet.setNetworkId(networkId);
                subnet.setBitFormat(result.getString(5));

                subnets.add(subnet);
            }

            result.close();
            stmt.close();

            return subnets;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public SubnetAddress GetSubnetAddressById(int subnetId)
    {
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM subnet where id= " + subnetId);
            result.first();

            SubnetAddress subnet = new SubnetAddress();

            subnet.setId(result.getInt(1));
            subnet.setPrefix(result.getInt(4));
            subnet.setSubnetAddress(result.getString(2));
            subnet.setNetworkId(subnetId);
            subnet.setBitFormat(result.getString(5));

            result.close();
            stmt.close();

            return subnet;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public ArrayList<Host> GetHosts(int subNetId)
    {
        try {
            ArrayList<Host> hosts = new ArrayList<>();

            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM host where subnet_id ="+subNetId);

            while (result.next())
            {
                Host host = new Host();

                host.setId(result.getInt(1));
                host.setSubnetId(subNetId);
                host.setIPAddress(result.getString(2));
                host.setBitFormat(result.getString(6));
                host.setDescription(result.getString(5));
                host.setDevice(result.getInt(4));

                hosts.add(host);
            }

            result.close();
            stmt.close();
            return hosts;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int AddNetwork(NetworkAddress network)
    {
        try {
            String insertTableSQL = "INSERT INTO network (ip , prefix , bit_format ) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, network.getIPAddress());
            statement.setInt(2, network.getPrefix());
            statement.setString(3, network.getBitFormat());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            statement.close();

            return generatedKey;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public int AddSubnet(SubnetAddress subnetAddress) {
        try {
            String insertTableSQL = "INSERT INTO subnet (ip , network_id, prefix, bit_format ) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, subnetAddress.getSubnetAddress());
            statement.setInt(2, subnetAddress.getNetworkId());
            statement.setInt(3, subnetAddress.getPrefix());
            statement.setString(4, subnetAddress.getBitFormat());

            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            statement.close();

            return generatedKey;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public int AddHost(Host host) {
        try {
            String insertTableSQL = "INSERT INTO host (IP , subnet_id, description, bit_format, device_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, host.getIPAddress());
            statement.setInt(2, host.getSubnetId());
            statement.setString(3, host.getDescription());
            statement.setString(4, host.getBitFormat());
            statement.setInt(5, host.getDevice());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            rs.close();
            statement.close();

            return generatedKey;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    @Override
    public boolean DeleteNetworkById(int networkId) {
        try {
            String deleteNetworkSql = "DELETE FROM network where id="+networkId;
            ArrayList<SubnetAddress> subnets= this.GetSubnetAddresses(networkId);

            Statement stmt = connection.createStatement();

            for (SubnetAddress subnet :subnets)
            {
                String deleteHostSql = "DELETE FROM host where subnet_id=" + subnet.getId();
                stmt.execute(deleteHostSql);
            }

            String deleteSubnetSql = "Delete From subnet where network_id=" + networkId;

            stmt.execute(deleteSubnetSql);
            stmt.execute(deleteNetworkSql);

            stmt.close();

            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean DeleteSubnetById(int subnetAddressId) {
        try {
            String deleteSubnetSql = "DELETE FROM subnet where id="+subnetAddressId;
            String deleteHostSql = "DELETE FROM host where subnet_id="+subnetAddressId;

            Statement stmt = connection.createStatement();
            stmt.execute(deleteHostSql);
            stmt.execute(deleteSubnetSql);

            stmt.close();

            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean DeleteHostById(int hostId) {
        try {
            String deleteTableSQL = "DELETE FROM host where id="+hostId;

            Statement stmt = connection.createStatement();
            stmt.execute(deleteTableSQL);

            stmt.close();

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Device GetDeviceById(int deviceId)
    {
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Device where id ="+deviceId);

            Device device = new Device();
            device.setId(deviceId);
            device.setName(result.getString(2));

            result.close();
            stmt.close();

            return device;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

}
