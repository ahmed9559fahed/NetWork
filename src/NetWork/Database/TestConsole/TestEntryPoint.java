package NetWork.Database.TestConsole;

import NetWork.Database.Interface.IDataBaseService;
import NetWork.Database.Models.NetworkAddress;
import NetWork.Database.Service.DataBaseService;

import java.util.ArrayList;

public class TestEntryPoint {

    private static  IDataBaseService DataBaseService;
    public static void main(String [] args)
    {
        System.out.print("Started");
        DataBaseService =new DataBaseService();
        DataBaseService.Connect();
        ArrayList<NetworkAddress> networks= DataBaseService.Get_NETWORK_ADDRESSES();

        for (NetworkAddress networkAddress:networks)
        {
          System.out.println(networkAddress.GetIPAddress());
        }

    }

}
