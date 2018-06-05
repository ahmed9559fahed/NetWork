package NetWork.Database.Models;
public class Host {

    private int Id;
    private String SubNetsId;
    private String IPAddress;
    private String Description;

    public Host(String ipAddress,String description)
    {

       IPAddress=ipAddress;
       Description=description;
    }

    public String getSubNetsId() {
        return SubNetsId;
    }

    public void setSubNetsId(String subNetsId) {
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
