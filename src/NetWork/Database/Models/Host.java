package NetWork.Database.Models;
import java.util.UUID;
public class Host {

    private String Id;
    private String SubNetsId;
    private String IPAddress;
    private String Description;

    public Host(String subNetsId,String ipAddress,String description)
    {
       Id=UUID.randomUUID()+"";
       IPAddress=ipAddress;
       Description=description;
    }

    public String getSubNetsId() {
        return SubNetsId;
    }

    public void setSubNetsId(String subNetsId) {
        SubNetsId = subNetsId;
    }

    public String getId() {
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

    public void setId(String id) {
        Id = id;
    }

    public void setIPAddress(String IPAddress) {
            this.IPAddress = IPAddress;
    }
}
