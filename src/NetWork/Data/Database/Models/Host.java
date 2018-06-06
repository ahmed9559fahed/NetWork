package NetWork.Data.Database.Models;
public class Host {

    private int Id;
    private int SubNetsId;
    private String IPAddress;
    private String Description;
    private String BitFormat;
    private int DeviceID;

    public void setDeviceID(int deviceID) {
        DeviceID = deviceID;
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setBitFormat(String bitFormat) {
        BitFormat = bitFormat;
    }
    public String getBiTFormat()
    {
        return this.BitFormat;
    }

    public void setId(int id) {
        Id = id;
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
