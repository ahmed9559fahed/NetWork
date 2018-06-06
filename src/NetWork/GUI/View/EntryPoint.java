package NetWork.GUI.View;

import javax.swing.JFrame;

import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.MainView;

public class EntryPoint {

    public static void main(String[] args) {

        //Init database
        DatabaseService.getService();

        JFrame frame = new MainView();
        
        frame.setVisible(true);
    }
}
