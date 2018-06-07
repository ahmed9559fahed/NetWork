package NetWork.GUI.View.Controls.Listener;

import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.Interface.IReloadableListView;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ReloadListView implements WindowListener {

    protected IReloadableListView listView;

    protected FrameWindow contextView;

    public ReloadListView(IReloadableListView listView, FrameWindow contextView) {
        this.listView = listView;
        this.contextView = contextView;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        listView.reloadTable();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
