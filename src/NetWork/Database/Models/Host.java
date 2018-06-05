package NetWork.Database.Models;
public class Host {

    private int Id;
    private int SubNetsId;
    private String IPAddress;
    private String Description;
    private String BitFormat;

    public void setBitFormat(String bitFormat) {
        BitFormat = bitFormat;
    }
    public String GetBiTFormat()
    {
        return this.BitFormat;
    }

    public Host(String ipAddress, String description)
    {

       IPAddress=ipAddress;
       Description=description;
    }

    public Host()
    {

    }
    public int getSubNetsId() {
        return SubNetsId;
    }

    public void setSubNetsId(int subNetsId) {
        SubNetsId = subNetsId;
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return Description;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setIPAddress(String IPAddress) {
            this.IPAddress = IPAddress;
    }
}
