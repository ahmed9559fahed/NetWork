package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;

import javax.swing.*;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.SubnetModel;
import java.awt.Color;

public class Subnet extends ListView<SubnetModel<SubnetAddress>, SubnetAddress> {

	protected int networkId;

	public Subnet(int networkId) {
		this.networkId = networkId;
		this.tableModel = new SubnetModel(this.networkId);
		this.reloadTable();

		//TODO Load network model to get ip and prefix to show in title
		this.setTitle("List of Subnets for " + String.valueOf(this.networkId));

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		/*
		 * Button
		 */
		FlatButton btnAddNewSubnet = new FlatButton((String) null);
		btnAddNewSubnet.setText("Add new Subnet");
		btnAddNewSubnet.setBounds(10, 454, 138, 35);

		btnAddNewSubnet.addActionListener(e -> {
			NetWork.GUI.View.Formular.Subnet formularView = new NetWork.GUI.View.Formular.Subnet(networkId);
			formularView.setVisible(true);

			ReloadListView listener = new ReloadListView(this, formularView);
			formularView.addWindowListener(listener);
		});

		/*
		 * Button
		 */
		FlatButton flatButton = new FlatButton((String) null);
		flatButton.setText("Delete Subnet");
		flatButton.setBounds(176, 454, 138, 35);
		flatButton.addActionListener(e -> {
			try {
				SubnetAddress subnet = this.getSelectedElement();

				DatabaseService.getService().DeleteSubnetById(subnet.getId());

				reloadTable();
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid subnet!");
			}
		});


		/*
		 * Button
		 */
		FlatButton flatButton_1 = new FlatButton((String) null);
		flatButton_1.setText("Manage IPs");
		flatButton_1.setBounds(346, 454, 138, 35);
		flatButton_1.addActionListener(e -> {
			try {
				SubnetAddress subnet = getSelectedElement();

				Host hostView = new Host(networkId, subnet.getId());

				hostView.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});


		/*
		 * Table
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 488, 437);


		table = new JTable(this.tableModel);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		panel.add(scrollPane);


		getContentPane().add(btnAddNewSubnet);
		getContentPane().add(panel);
		getContentPane().add(flatButton_1);
		getContentPane().add(flatButton);
	}
}
