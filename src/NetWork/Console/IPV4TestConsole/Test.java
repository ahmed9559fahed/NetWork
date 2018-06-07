package NetWork.Console.IPV4TestConsole;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.SubnetAddress;

import java.util.ArrayList;


public class Test {

    public static void main(String [] Args)
    {



        IPv4Object ipv42 = new IPv4Object("192.168.1.0/28");

        ArrayList<SubnetAddress> subnets= ipv42.GetSubnets("192.168.1.0",26,29,29);
        //Get Network Ip
        System.out.println("NetworkIp: "+ipv42.getIP());
        //Get Broadcast
        System.out.println("Brodcast: "+ipv42.getBroadcastAddress());
        //Get Netmask
        System.out.println("Netmask: "+ipv42.getNetmask());
        //Get CIDR
        System.out.println("CIDR: "+ipv42.getCIDR());
        //Get Host Range
        System.out.println("HostRange: "+ipv42.getHostAddressRange());
        //Get Number of avaliable Hosts
        System.out.println("NumberOfHosts: "+ipv42.getNumberOfHosts());

        System.out.println("Binary Of Broadcast: " + ipv42.GetBinary(ipv42.getBroadcastAddress()));

/*
        //Get list of Avaliable IP Addresses
        List<String> availableIPs = ipv42.getAvailableIPs(Integer.parseInt(ipv42.getNumberOfHosts()+""));
        int counter=0;

        for (String ip : availableIPs) { System.out.print(ip);
            System.out.println(" "); counter++; if((counter%10)==0)
                System.out.print("n");
        }




        IPv4Object ipv43 = new IPv4Object("12.12.12.0/16");

        IPv4Object ipv4Child = new IPv4Object("12.12.12.0/17");
        IPv4Object ipv44 = new IPv4Object("192.168.20.0/16");
        System.out.println(ipv44.getIP());
        System.out.println(ipv44.getNetmask());

        System.out.println(ipv44.getCIDR());
        System.out.println("======= MATCHES =======");
        System.out.println(ipv44.getBinary(ipv44.BaseIPnumeric));
        System.out.println(ipv44.getBinary(ipv44.netmaskNumeric));

        System.out.println(ipv44.contains(ipv4Child));

        System.out.println(ipv44.getBinary(ipv44.BaseIPnumeric));
        System.out.println(ipv44.getBinary(ipv44.netmaskNumeric));

        System.out.println(ipv4Child.getBinary(ipv4Child.BaseIPnumeric));

        System.out.println(ipv4Child.getBinary(ipv4Child.netmaskNumeric));

        System.out.println(ipv44.contains(ipv4Child));
*/
        }

}
