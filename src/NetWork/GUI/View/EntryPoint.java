package NetWork.GUI.View;

import javax.swing.JFrame;

import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.List.Network;

public class EntryPoint {

    public static void main(String[] args) {

        //Init database
        DatabaseService.getService();

        JFrame frame = new Network();
        
        frame.setVisible(true);
    }
}
