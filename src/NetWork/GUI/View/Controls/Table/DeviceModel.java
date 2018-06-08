package NetWork.GUI.View.Controls.Table;

import NetWork.Business.IPService;
import NetWork.Data.Database.Interface.IDatabaseModel;
import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Models.Host;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.Interface.ITableModel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DeviceModel<DatabaseModel extends IDatabaseModel> extends AbstractTableModel implements ITableModel<DatabaseModel> {

    protected String[] columnNames = {"Name"};

    protected ArrayList<Device> resultSet;

    protected int rowsCount;

    public void Load() {
        resultSet = DatabaseService.getService().GetDeviceList();
        this.rowsCount = this.resultSet.size();
    }

    /**
     * Return Column names
     * @param column
     * @return
     */
    public String getColumnName(int column) {
        return this.columnNames[column];
    }


    /**
     * Returns number of columns
     * @return int
     * @Override
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Disable Cell editing for all columns
     * @param row
     * @param column
     * @return
     */
    public boolean isCellEditable(int row, int column){
        return false;
    }

    @Override
    public int getRowCount() {
        return this.rowsCount;
    }

    public DatabaseModel getRow(int rowIndex) {
        return (DatabaseModel)this.resultSet.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Device device = this.resultSet.get(rowIndex);

        switch (columnIndex) {
            case 0: {
                return device.getName();
            }
            default: {
                return "";
            }
        }
    }
}
