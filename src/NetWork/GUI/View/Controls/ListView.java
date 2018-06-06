package NetWork.GUI.View.Controls;

import NetWork.Data.Database.Interface.IDatabaseModel;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.GUI.View.Controls.Interface.IReloadableListView;
import NetWork.GUI.View.Controls.Interface.ITableModel;
import NetWork.GUI.View.Controls.Table.NetworkModel;

import javax.swing.*;

public abstract class ListView
        <TableModel extends ITableModel<DatabaseModel>, DatabaseModel extends IDatabaseModel> extends FrameWindow implements IReloadableListView<TableModel, DatabaseModel>
{

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

    public DatabaseModel getSelectedElement() {
        int selectedRow = table.getSelectedRow();
        DatabaseModel model = tableModel.getRow(selectedRow);

        return model;
    }

}
