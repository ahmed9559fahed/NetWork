package NetWork.Calculator.IPv6;

import com.github.jgonian.ipmath.Ipv6;

public class Object {

    protected String _IPv6;

    protected Integer _netmask;

    public Object(String ipv4, int netmask) {
        this._IPv6 = ipv4;
        this._netmask = netmask;
    }

    /**
     * Get the network address
     * @return
     */
    public String getNetworkAddress() {
        Ipv6 ipv6 = Ipv6.of(this._IPv6);

        return "";
    }

    /**
     * return the default gateway (default x.x.x.1)
     * @return
     */
    public String getDefaultGateway() {
        return "";
    }

    /**
     * Count the available hosts for the given ip subnet
     *
     * @return
     */
    public Integer getAvailableHosts() {
       return 0;
    }

    /**
     * A, B, C
     * @return
     */
    public String getIPClass() {
        return "";
    }
}
