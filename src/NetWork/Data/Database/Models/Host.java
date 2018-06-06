package NetWork.Data.Database.Models;
public class Host {

    public Host()
    {

    }

    private int Id;
    private int SubnetId;
    private String IPAddress;
    private String Description;
    private String BitFormat;
    private int DeviceId;

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getDevice() {
        return this.DeviceId;
    }

    public void setDevice(int device) {
        this.DeviceId = device;
    }

    public String getBitFormat()
    {
        return this.BitFormat;
    }

    public void setBitFormat(String bitFormat) {
        this.BitFormat = bitFormat;
    }

    public int getSubnetId() {
        return this.SubnetId;
    }

    public void setSubnetId(int subnetsId) {
        this.SubnetId = subnetsId;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getIPAddress() {
        return this.IPAddress;
    }

    public void setIPAddress(String IPAddress) {
            this.IPAddress = IPAddress;
    }
}
