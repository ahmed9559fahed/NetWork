package NetWork.Console;

import NetWork.Business.IPService;
import NetWork.Data.Database.Models.NetworkAddress;

import java.util.ArrayList;

public class TestIPService {
    public static void  main(String [] Args)
    {
        IPService service=new IPService();
        ArrayList<NetworkAddress> networks=service.GetNetworks();

        NetworkAddress network=new NetworkAddress();
        network.setBitFormat("11110000.11111111.00000000.11111111");
        network.setIPAddress("192.168.112.1");
        network.setPrefix(32);

        service.AddNetwork(network);
    }
}
