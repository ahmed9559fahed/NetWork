package NetWork.GUI.View.Controls.Interface;

import NetWork.Data.Database.Interface.IDatabaseModel;

public interface ITableModel<DatabaseModel extends IDatabaseModel> {
    void Load();

    void fireTableDataChanged();

    DatabaseModel getRow(int rowIndex);
}
