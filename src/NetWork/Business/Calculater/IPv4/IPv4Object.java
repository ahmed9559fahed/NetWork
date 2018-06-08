package NetWork.Business.Calculater.IPv4;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class IPv4Object {

    public int BaseIPnumeric;
    public int netmaskNumeric;

    /**
     * Specify IP in CIDR format like: new IPv4Object("10.1.0.25/16");
     *
     * @param
     */
    public String GetBinary(String Ip) {


        /* IP */
        String[] st = Ip.split("\\.");

        if (st.length != 4)
            throw new NumberFormatException("Invalid IP address: " + Ip);

        int i = 24;
        BaseIPnumeric = 0;

        for (int n = 0; n < st.length; n++) {

            int value = Integer.parseInt(st[n]);

            if (value != (value & 0xff)) {

                throw new NumberFormatException("Invalid IP address: " + Ip);
            }

            BaseIPnumeric += value << i;
            i -= 8;
        }
       return  getBinary(BaseIPnumeric);
    }


    public IPv4Object(String IPinCIDRFormat) throws NumberFormatException {

        String[] st = IPinCIDRFormat.split("\\/");
        if (st.length != 2)

            throw new NumberFormatException("Invalid CIDR format '"
                    + IPinCIDRFormat + "', should be: xx.xx.xx.xx/xx");

        String symbolicIP = st[0];
        String symbolicCIDR = st[1];

        Integer numericCIDR = new Integer(symbolicCIDR);
        if (numericCIDR > 32)

            throw new NumberFormatException("CIDR can not be greater than 32");

        /* IP */
        st = symbolicIP.split("\\.");

        if (st.length != 4)
            throw new NumberFormatException("Invalid IP address: " + symbolicIP);

        int i = 24;
        BaseIPnumeric = 0;

        for (int n = 0; n < st.length; n++) {

            int value = Integer.parseInt(st[n]);

            if (value != (value & 0xff)) {

                throw new NumberFormatException("Invalid IP address: " + symbolicIP);
            }

            BaseIPnumeric += value << i;
            i -= 8;
        }

        /* netmask from CIDR */
        if (numericCIDR < 8)
            throw new NumberFormatException("Netmask CIDR can not be less than 8");
        netmaskNumeric = 0xffffffff;
        netmaskNumeric = netmaskNumeric << (32 - numericCIDR);

    }

    /**
     * Get the IP in symbolic form, i.e. xxx.xxx.xxx.xxx
     *
     *@return
     */
    public String getIP() {
        return convertNumericIpToSymbolic(BaseIPnumeric);
    }

    private String convertNumericIpToSymbolic(Integer ip) {
        StringBuffer sb = new StringBuffer(15);

        for (int shift = 24; shift > 0; shift -= 8) {

            // process 3 bytes, from high order byte down.
            sb.append(Integer.toString((ip >>> shift) & 0xff));

            sb.append('.');
        }
        sb.append(Integer.toString(ip & 0xff));

        return sb.toString();
    }

    /**
     * Get the net mask in symbolic form, i.e. xxx.xxx.xxx.xxx
     *
     *@return
     */

    public String getNetmask() {
        StringBuffer sb = new StringBuffer(15);

        for (int shift = 24; shift > 0; shift -= 8) {

            // process 3 bytes, from high order byte down.
            sb.append(Integer.toString((netmaskNumeric >>> shift) & 0xff));

            sb.append('.');
        }
        sb.append(Integer.toString(netmaskNumeric & 0xff));

        return sb.toString();
    }

    /**
     * Get the IP and netmask in CIDR form, i.e. xxx.xxx.xxx.xxx/xx
     *
     *@return
     */

    public String getCIDR() {
        int i;
        for (i = 0; i < 32; i++) {

            if ((netmaskNumeric << i) == 0)
                break;

        }
        return convertNumericIpToSymbolic(BaseIPnumeric & netmaskNumeric) + "/" + i;
    }

    /**
     * Get an arry of all the IP addresses available for the IP and netmask/CIDR
     * given at initialization
     *
     *@return
     */
    public List<String> getAvailableIPs(int numberofIPs) {

        ArrayList<String> result = new ArrayList<String>();
        int numberOfBits;

        for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {

            if ((netmaskNumeric << numberOfBits) == 0)
                break;
        }
        Integer numberOfIPs = 0;
        for (int n = 0; n < (32 - numberOfBits); n++) {

            numberOfIPs = numberOfIPs << 1;
            numberOfIPs = numberOfIPs | 0x01;
        }

        Integer baseIP = BaseIPnumeric & netmaskNumeric;

        for (int i = 1; i < (numberOfIPs) && i < numberofIPs; i++) {

            Integer ourIP = baseIP + i;

            String ip = convertNumericIpToSymbolic(ourIP);

            result.add(ip);
        }
        return result;
    }

    /**
     * Range of hosts
     *
     *@return
     */
    public String getHostAddressRange() {

        int numberOfBits;
        for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {

            if ((netmaskNumeric << numberOfBits) == 0)
                break;
        }
        Integer numberOfIPs = 0;
        for (int n = 0; n < (32 - numberOfBits); n++) {

            numberOfIPs = numberOfIPs << 1;
            numberOfIPs = numberOfIPs | 0x01;
        }

        Integer baseIP = BaseIPnumeric & netmaskNumeric;
        String firstIP = convertNumericIpToSymbolic(baseIP + 1);
        String lastIP = convertNumericIpToSymbolic(baseIP + numberOfIPs - 1);
        return firstIP + " - " + lastIP;
    }

    /**
     * Returns number of hosts available in given range
     *
     *@return number of hosts
     */
    public int getNumberOfHosts() {
        int numberOfBits;

        for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {

            if ((netmaskNumeric << numberOfBits) == 0)
                break;
        }

        Double x = Math.pow(2, (32 - numberOfBits));

        if (x == -1)
            x = 1D;

        return x.intValue();
    }

    /**
     * The XOR of the netmask
     *
     *@return wildcard mask in text form, i.e. 0.0.15.255
     */

    public String getWildcardMask() {
        Integer wildcardMask = netmaskNumeric ^ 0xffffffff;

        StringBuffer sb = new StringBuffer(15);
        for (int shift = 24; shift > 0; shift -= 8) {

            // process 3 bytes, from high order byte down.
            sb.append(Integer.toString((wildcardMask >>> shift) & 0xff));

            sb.append('.');
        }
        sb.append(Integer.toString(wildcardMask & 0xff));

        return sb.toString();
    }

    public String getBroadcastAddress() {

        if (netmaskNumeric == 0xffffffff)
            return "0.0.0.0";

        int numberOfBits;
        for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {

            if ((netmaskNumeric << numberOfBits) == 0)
                break;
        }
        Integer numberOfIPs = 0;
        for (int n = 0; n < (32 - numberOfBits); n++) {

            numberOfIPs = numberOfIPs << 1;
            numberOfIPs = numberOfIPs | 0x01;
        }

        Integer baseIP = BaseIPnumeric & netmaskNumeric;
        Integer ourIP = baseIP + numberOfIPs;

        String ip = convertNumericIpToSymbolic(ourIP);

        return ip;
    }

    public String getBinary(Integer number) {
        String result = "";

        Integer ourMaskBitPattern = 1;
        for (int i = 1; i <= 32; i++) {

            if ((number & ourMaskBitPattern) != 0) {

                result = "1" + result; // the bit is 1
            } else { // the bit is 0

                result = "0" + result;
            }
            if ((i % 8) == 0 && i != 0 && i != 32)

                result = "." + result;
            ourMaskBitPattern = ourMaskBitPattern << 1;

        }
        return result;
    }

    public String getNetmaskInBinary() {

        return getBinary(netmaskNumeric);
    }

    /**
     * Checks if the given IP address contains in subnet
     *
     *@param IPaddress
     *@return
     */
    public boolean contains(String IPaddress) {

        Integer checkingIP = 0;
        String[] st = IPaddress.split(".");

        if (st.length != 4)
            throw new NumberFormatException("Invalid IP address: " + IPaddress);

        int i = 24;
        for (int n = 0; n < st.length; n++) {

            int value = Integer.parseInt(st[n]);

            if (value != (value & 0xff)) {

                throw new NumberFormatException("Invalid IP address: "
                        + IPaddress);
            }

            checkingIP += value << i;
            i -= 8;
        }

        if ((BaseIPnumeric & netmaskNumeric) == (checkingIP & netmaskNumeric))

            return true;
        else
            return false;
    }

    public boolean contains(IPv4Object child) {

        Integer subnetID = child.BaseIPnumeric;

        Integer subnetMask = child.netmaskNumeric;

        if ((subnetID & this.netmaskNumeric) == (this.BaseIPnumeric & this.netmaskNumeric)) {

            if ((this.netmaskNumeric < subnetMask) == true
                    && this.BaseIPnumeric <= subnetID) {

                return true;
            }

        }
        return false;
    }

     public boolean validateIPAddress() {
        String IPAddress = getIP();

        if (IPAddress.startsWith("0")) {
            return false;

        }

        if (IPAddress.isEmpty()) {

            return false;
        }

        if (IPAddress
                .matches("/A(25[0-5]|2[0-4]/d|[0-1]?/d?/d)(/.(25[0-5]|2[0-4]/d|[0-1]?/d?/d)){3}/z")) {

            return true;
        }
        return false;
    }


    public ArrayList<SubnetAddress> GetSubnets(String ip,int prefix,int networkId)
    {

        try {
            int networkPrefix = DatabaseService.getService().GetNetworkAddressById(networkId).getPrefix();

            DatabaseService.getService().DeleteAllSubnetByNetworkID(networkId);
            int Hostbits = 32 - networkPrefix;
            int subnetHostBits = 32 - prefix;
            int subnetBits = Hostbits - subnetHostBits;
            int subnetNumber = (int) Math.pow(2, subnetBits);

            ArrayList<SubnetAddress> subnetses = new ArrayList<SubnetAddress>();

            ArrayList<SubnetAddress> lastSubNet = DatabaseService.getService().GetSubnetAddresses(networkId, " order by id desc limit 1");
            if (lastSubNet.size() == 0) {
                SubnetAddress obj1 = new SubnetAddress();
                obj1.setSubnetAddress(ip);
                obj1.setPrefix(prefix);
                subnetses.add(obj1);
                IPv4Object object = new IPv4Object(ip + "/" + prefix);
                String broadcast = object.getBroadcastAddress();
                //int numberOfHosts = object.getNumberOfHosts();
                String lastBroadcast = broadcast;
                for (int i = 0; i < subnetNumber - 1; i++) {
                    SubnetAddress obj = new SubnetAddress();
                    obj.setSubnetAddress(GetNextIp(lastBroadcast));
                    obj.setPrefix(prefix);
                    obj.setNetworkId(networkId);
                    subnetses.add(obj);
                    IPv4Object iPv4Object = new IPv4Object(obj.getSubnetAddress() + "/" + obj.getPrefix());
                    lastBroadcast = iPv4Object.getBroadcastAddress();

                }

                return subnetses;
            } else {
                return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    private String GetNextIp(String ip)
    {
        String[] st = ip.split("\\.");
        int oct1=Integer.parseInt(st[0]);
        int oct2=Integer.parseInt(st[1]);
        int oct3=Integer.parseInt(st[2]);
        int oct4=Integer.parseInt(st[3]);
        if(oct4<255)
        {
            oct4++;
        return oct1+"."+oct2+"."+oct3+"."+oct4;
        }
        if(oct3<255)
        {
            oct3++;
            return oct1+"."+oct2+"."+oct3+"."+oct4;
        }
        if(oct2<255)
        {
            oct2++;
            return oct1+"."+oct2+"."+oct3+"."+oct4;
        }
        if(oct1<255)
        {
            oct1++;
            return oct1+"."+oct2+"."+oct3+"."+oct4;
        }

        return "";
    }
}
