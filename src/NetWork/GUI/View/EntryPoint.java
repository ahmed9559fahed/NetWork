package NetWork.GUI.View;

import javax.swing.JFrame;

import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.List.Network;
import NetWork.GUI.View.Window.IPInfo;

public class EntryPoint {

    public static void main(String[] args) {

        //Init database
       // DatabaseService.getService();

        SubnetAddress subnet = DatabaseService.getService().GetSubnetAddressById(5);

        FrameWindow window = new IPInfo(subnet);
window.setVisible(true);
        //JFrame frame = new Network();
        
        //frame.setVisible(true);
    }


}
