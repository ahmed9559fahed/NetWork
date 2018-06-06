package NetWork.GUI.View.Controls.Table;

import javax.swing.table.AbstractTableModel;

public class NetworkModel extends AbstractTableModel {

	protected String[] columnNames = {"IP Address", "Prefix"};

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
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return "sdfsd";
	}
}
