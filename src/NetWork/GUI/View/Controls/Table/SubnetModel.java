package NetWork.GUI.View.Controls.Table;

import NetWork.Business.IPService;
import NetWork.Data.Database.Interface.IDatabaseModel;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.Interface.ITableModel;

import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SubnetModel<DatabaseModel extends IDatabaseModel> extends AbstractTableModel implements ITableModel<DatabaseModel> {

    protected int networkId;

    public SubnetModel(int networkId)
    {
        this.networkId = networkId;

        Service = new DatabaseService();
    }

    protected String[] columnNames = {"IP Address", "Prefix"};

    protected ArrayList<SubnetAddress> resultSet;

    protected DatabaseService Service;
    protected int rowsCount;

    public void Load() {
        resultSet = Service.GetSubnetAddresses(this.networkId);
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
        DatabaseModel databaseModel = (DatabaseModel)this.resultSet.get(rowIndex);
		return databaseModel;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SubnetAddress network = this.resultSet.get(rowIndex);

        switch (columnIndex) {
            case 0: {
                return network.getSubnetAddress();
            }
            case 1: {
                return network.getPrefix();
            }
            default: {
                return "";
            }
        }
    }
}
