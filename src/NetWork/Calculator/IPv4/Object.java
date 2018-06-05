package NetWork.Calculator.IPv4;

public class Object {

    protected String _IPv4;

    protected Integer _netmask;

    public Object(String ipv4, int netmask) {
        this._IPv4 = ipv4;
        this._netmask = netmask;
    }

    /**
     * Get the network address
     * @return
     */
    public String getNetworkAddress() {
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
    public Integer getAvailableHost()
    {
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
