package NetWork.GUI.View.Controls.Interface;

import NetWork.Data.Database.Interface.IDatabaseModel;
import NetWork.GUI.View.Controls.Table.NetworkModel;

import javax.swing.*;

public interface IReloadableListView<TableModel extends ITableModel, DatabaseModel extends IDatabaseModel> {
    void reloadTable();

    DatabaseModel getSelectedElement();
}
