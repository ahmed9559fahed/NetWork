package NetWork.GUI.View.Window;

import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.List.Network;

import javax.xml.crypto.Data;

public class Welcome extends FrameWindow {

    public Welcome() {

        if(DatabaseService.getService().isConnected() == false) {
            Exception exception = DatabaseService.getService().getLastError();

            String errorString = "";
            if(exception != null) {
                errorString = exception.getMessage();
            }

            this.ShowError("Could not connected to database! " + errorString);

            System.exit(100);
        }

        Network network = new Network();
        network.setVisible(true);
    }
}
