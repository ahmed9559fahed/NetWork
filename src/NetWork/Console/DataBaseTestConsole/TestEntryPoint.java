package NetWork.Console.DataBaseTestConsole;

import NetWork.Data.Database.Interface.IDataBaseService;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;

import java.util.ArrayList;

public class TestEntryPoint {

    private static  IDataBaseService databaseService;
    public static void main(String [] args)
    {



        System.out.println("Started");
        databaseService = DatabaseService.getService();

        NetworkAddress networkAddress=new NetworkAddress();
        networkAddress.setBitFormat("11110000.11110000.11110000.11110000");
        networkAddress.setPrefix(24);
        networkAddress.setIPAddress("192.168.50.50");
        int networkId = databaseService.AddNetwork(networkAddress);


        ArrayList<SubnetAddress> subnets = new ArrayList<SubnetAddress>();
        SubnetAddress subnet1 = new SubnetAddress();
        subnet1.setSubnetAddress("192.245.212.245");
        subnet1.setBitFormat("11110000.10101010.00000000.11001100");
        subnet1.setNetworkId(networkId);
        subnet1.setPrefix(24);

        SubnetAddress subnet2 = new SubnetAddress();
        subnet2.setSubnetAddress("192.245.218.245");
        subnet2.setBitFormat("11110000.10101010.00000000.11001100");
        subnet2.setNetworkId(networkId);
        subnet2.setPrefix(16);

        SubnetAddress subnet3=new SubnetAddress();
        subnet3.setSubnetAddress("192.245.215.245");
        subnet3.setBitFormat("11110000.10101010.00000000.11001100");
        subnet3.setNetworkId(networkId);
        subnet3.setPrefix(24);
        
        subnets.add(subnet1);
        subnets.add(subnet2);
        subnets.add(subnet3);

        for (SubnetAddress subnet :subnets)
        {
            int subnetID = databaseService.AddSubnet(subnet);

            ArrayList<Host> hosts = new ArrayList<Host>();
            Host host1=new Host();
            host1.setIPAddress("192.168.1.1");
            host1.setSubnetId(subnetID);
            host1.setDescription("Bernd PC1");
            host1.setDevice(1);
            host1.setBitFormat("11111111.00000000.11111111.00000000");

            Host host2=new Host();
            host2.setIPAddress("192.168.1.1");
            host2.setSubnetId(subnetID);
            host2.setDescription("Bernd PC2");
            host2.setDevice(2);
            host2.setBitFormat("11111111.00000000.11111111.00000000");

            Host host3=new Host();
            host3.setIPAddress("192.168.1.1");
            host3.setSubnetId(subnetID);
            host3.setDescription("Bernd PC3");
            host3.setDevice(2);
            host3.setBitFormat("11111111.00000000.11111111.00000000");

            hosts.add(host1);
            hosts.add(host2);
            hosts.add(host3);

            for (Host host :hosts)
            {
                databaseService.AddHost(host);
            }

        }

        System.out.println();

        ArrayList<NetworkAddress> networks= databaseService.GetNetworkAddresses();
        for (NetworkAddress network:networks)
        {
          System.out.println(network.getIPAddress()+"\t"+network.getPrefix());
        }

        System.out.println();

        ArrayList<SubnetAddress> subnetsList= databaseService.GetSubnetAddresses(1);
        for (SubnetAddress subnet:subnetsList)
        {
            System.out.println(subnet.getSubnetAddress()+"\t"+subnet.getBitFormat()+"\t"+subnet.getPrefix());
        }

        System.out.println();
        ArrayList<Host> hosts= databaseService.GetHosts(1);
        for (Host host:hosts)
        {
            System.out.println(host.getIPAddress()+"\t"+host.getDescription()+"\t"+host.getDevice());
        }

        databaseService.DeleteHostById(1);
        databaseService.DeleteSubnetById(1);
        databaseService.DeleteNetworkById(1);

    }




}
