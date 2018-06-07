package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.HostModel;
import NetWork.GUI.View.Controls.Table.SubnetModel;

import javax.swing.*;
import java.awt.*;

public class Host extends ListView<HostModel<NetWork.Data.Database.Models.Host>, NetWork.Data.Database.Models.Host> {

	protected int networkId;
	protected int subnetId;

	public Host(int networkId, int subnetId) {
		this.networkId = networkId;
		this.subnetId = subnetId;

		//TODO load network and subnet to get title
		this.setTitle("List of IPs for " + String.valueOf(this.networkId) + " -> " + String.valueOf(this.subnetId));


		this.tableModel = new HostModel(this.networkId);
		this.reloadTable();

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
				NetWork.Data.Database.Models.Host subnet = this.getSelectedElement();

				//TODO delete IP

				reloadTable();
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});


		/*
		 * Button
		 */
		FlatButton flatButton_1 = new FlatButton((String) null);
		flatButton_1.setText("Manage IPs");
		flatButton_1.setBounds(346, 454, 138, 35);


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
