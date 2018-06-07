package NetWork.GUI.View.Controls.Interface;

import NetWork.Data.Database.Interface.IDatabaseModel;

public interface IReloadableListView<DatabaseModel extends IDatabaseModel> {
    void reloadTable();

    DatabaseModel getSelectedElement();
}
