package NetWork.GUI.View;

import NetWork.GUI.View.Controls.FrameWindow;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JButton;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Table.SubnetModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubnetListView extends ListView<SubnetModel> {

	protected int networkId;

	public SubnetListView(int networkId) {
		this.networkId = networkId;

		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 474, 384);
		getContentPane().add(panel);
		
		table = new JTable();
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		FlatButton fltbtnAddNewSubnet = new FlatButton((String) null);
		fltbtnAddNewSubnet.setText("Add new Subnet");
		fltbtnAddNewSubnet.setBounds(10, 454, 138, 35);
		getContentPane().add(fltbtnAddNewSubnet);
		
		FlatButton flatButton = new FlatButton((String) null);
		flatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		flatButton.setText("Delete Subnet");
		flatButton.setBounds(176, 454, 138, 35);
		getContentPane().add(flatButton);
		
		FlatButton flatButton_1 = new FlatButton((String) null);
		flatButton_1.setText("Manage IPs");
		flatButton_1.setBounds(346, 454, 138, 35);
		getContentPane().add(flatButton_1);
	}
}
