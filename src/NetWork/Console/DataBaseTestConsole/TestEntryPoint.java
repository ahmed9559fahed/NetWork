package NetWork.Console.DataBaseTestConsole;

import NetWork.Data.Database.Interface.IDataBaseService;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DataBaseService;

import java.util.ArrayList;

public class TestEntryPoint {

    private static  IDataBaseService DataBaseService;
    public static void main(String [] args)
    {
        System.out.println("Started");
        DataBaseService =new DataBaseService();

        NetworkAddress networkAddress=new NetworkAddress();
        networkAddress.setBitFormat("11110000.11110000.11110000.11110000");
        networkAddress.SetPrefix(24);
        networkAddress.SetIPAddress("192.168.50.50");
        int networkId=DataBaseService.AddNetWork(networkAddress);


        ArrayList<SubnetAddress> subnets=new ArrayList<SubnetAddress>();
        SubnetAddress subnet1=new SubnetAddress();
        subnet1.setSubNetAddress("192.245.212.245");
        subnet1.setBitFormat("11110000.10101010.00000000.11001100");
        subnet1.setNetworkId1(networkId);
        subnet1.SetNetworkClasse("C");

        SubnetAddress subnet2=new SubnetAddress();
        subnet2.setSubNetAddress("192.245.218.245");
        subnet2.setBitFormat("11110000.10101010.00000000.11001100");
        subnet2.setNetworkId1(networkId);
        subnet2.SetNetworkClasse("B");

        SubnetAddress subnet3=new SubnetAddress();
        subnet3.setSubNetAddress("192.245.215.245");
        subnet3.setBitFormat("11110000.10101010.00000000.11001100");
        subnet3.setNetworkId1(networkId);
        subnet3.SetNetworkClasse("A");
        
        subnets.add(subnet1);
        subnets.add(subnet2);
        subnets.add(subnet3);

        for (SubnetAddress subnet :subnets)
        {
            int subnetID=DataBaseService.AddSubNet(subnet);

            ArrayList<Host> hosts=new ArrayList<Host>();
            Host host1=new Host();
            host1.setIPAddress("192.168.1.1");
            host1.setSubNetsId(subnetID);
            host1.setDescription("Bernd PC1");
            host1.setDeviceID(3);
            host1.setBitFormat("11111111.00000000.11111111.00000000");

            Host host2=new Host();
            host2.setIPAddress("192.168.1.1");
            host2.setSubNetsId(subnetID);
            host2.setDescription("Bernd PC2");
            host2.setDeviceID(2);
            host2.setBitFormat("11111111.00000000.11111111.00000000");

            Host host3=new Host();
            host3.setIPAddress("192.168.1.1");
            host3.setSubNetsId(subnetID);
            host3.setDescription("Bernd PC3");
            host3.setDeviceID(1);
            host3.setBitFormat("11111111.00000000.11111111.00000000");

            hosts.add(host1);
            hosts.add(host2);
            hosts.add(host3);

            for (Host host :hosts)
            {
             DataBaseService.AddHost(host);
            }

        }

        System.out.println();

        ArrayList<NetworkAddress> networks= DataBaseService.Get_NETWORK_ADDRESSES();
        for (NetworkAddress network:networks)
        {
          System.out.println(network.GetIPAddress()+"\t"+network.GetPrefix());
        }

        System.out.println();

        ArrayList<SubnetAddress> subnetsList= DataBaseService.Get_SubnetAddresses(1);
        for (SubnetAddress subnet:subnetsList)
        {
            System.out.println(subnet.GetSubNetAddress()+"\t"+subnet.getBitFormat()+"\t"+subnet.GetNetworkClasse());
        }

        System.out.println();
        ArrayList<Host> hosts= DataBaseService.Get_Hosts(1);
        for (Host host:hosts)
        {
            System.out.println(host.getIPAddress()+"\t"+host.getDescription()+"\t"+host.getDeviceID());
        }

        DataBaseService.DeleteHostById(1);
        DataBaseService.DeleteSubNetById(1);
        DataBaseService.DeleteNetWorkById(1);

    }

}
