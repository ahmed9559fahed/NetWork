package NetWork.Data.Database.Models.Table;

import javax.swing.table.AbstractTableModel;

public class NetworkTableModel extends AbstractTableModel {
    public boolean isCellEditable(int row, int column){

        return false;
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return "sdfsd";
	}
}
