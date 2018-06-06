package NetWork.GUI.View.Controls;

import NetWork.GUI.View.Controls.Interface.IReloadableListView;
import NetWork.GUI.View.Controls.Interface.ITableModel;

import javax.swing.*;

public class ListView<TableModel extends ITableModel> extends FrameWindow implements IReloadableListView {

    protected JTable table;

    protected ListView selfWindow;

    protected TableModel tableModel;

    public ListView() {
        super();

        selfWindow = this;
    }

    public void reloadTable() {
        tableModel.Load();
        tableModel.fireTableDataChanged();
    }
}
