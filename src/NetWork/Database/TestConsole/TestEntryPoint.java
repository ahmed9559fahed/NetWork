package NetWork.Database.TestConsole;

import NetWork.Database.Interface.IDataBaseService;
import NetWork.Database.Models.Host;
import NetWork.Database.Models.NetworkAddress;
import NetWork.Database.Models.SubnetAddress;
import NetWork.Database.Service.DataBaseService;

import java.util.ArrayList;

public class TestEntryPoint {

    private static  IDataBaseService DataBaseService;
    public static void main(String [] args)
    {
        System.out.println("Started");
        DataBaseService =new DataBaseService();

        ArrayList<NetworkAddress> networks= DataBaseService.Get_NETWORK_ADDRESSES();

        for (NetworkAddress networkAddress:networks)
        {
          System.out.println(networkAddress.GetIPAddress()+"\t"+networkAddress.GetPrefix());
        }

        ArrayList<SubnetAddress> subnets= DataBaseService.Get_SubnetAddresses(1);

        for (SubnetAddress subnet:subnets)
        {
            System.out.println(subnet.GetSubNetAddress()+"\t"+subnet.getBitFormat()+"\t"+subnet.getClass());
        }

        ArrayList<Host> hosts= DataBaseService.Get_Hosts(1);

        for (Host host:hosts)
        {
            System.out.println(host.getIPAddress()+"\t"+host.getDescription());
        }
    }

}
