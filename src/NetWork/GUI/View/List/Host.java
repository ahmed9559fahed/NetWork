package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.HostModel;
import NetWork.GUI.View.Window.IPInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Host extends ListView<HostModel<NetWork.Data.Database.Models.Host>, NetWork.Data.Database.Models.Host> {

	protected int networkId;
	protected int subnetId;

	public Host(int networkId, int subnetId) {
		this.networkId = networkId;
		this.subnetId = subnetId;

		//TODO load network and subnet to get title
		this.setTitle("List of IPs for " + String.valueOf(this.networkId) + " -> " + String.valueOf(this.subnetId));


		this.tableModel = new HostModel<>(this.subnetId);
		this.reloadTable();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(null);

		/*
		 * Button
		 */
		FlatButton btnAddIP = new FlatButton((String) null);
		btnAddIP.setText("Add IP");
		btnAddIP.setBounds(6, 454, 220, 35);

		btnAddIP.addActionListener(e -> {
			FrameWindow frame = new NetWork.GUI.View.Formular.Host(this.subnetId);

			frame.setVisible(true);

			ReloadListView listener = new ReloadListView(this, frame);
			frame.addWindowListener(listener);
		});

		/*
		 * Button
		 */
		FlatButton btnDelete = new FlatButton((String) null);
		btnDelete.setText("Delete IP");
		btnDelete.setBounds(264, 454, 220, 35);
		btnDelete.addActionListener(e -> {
			try {
				NetWork.Data.Database.Models.Host host = this.getSelectedElement();

				DatabaseService.getService().DeleteHostById(host.getId());

				reloadTable();
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid ip address!");
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

		FlatButton btnManageDevices = new FlatButton((String) null);
		btnManageDevices.setText("Manage Devices");
		btnManageDevices.setBounds(6, 500, 220, 35);
		btnManageDevices.addActionListener(e -> {
			Device deviceListView = new Device();
			deviceListView.setVisible(true);
		});

		FlatButton btnSubnetInfo = new FlatButton((String) null);
		btnSubnetInfo.addActionListener(e -> {
			try {
				SubnetAddress subnet = DatabaseService.getService().GetSubnetAddressById(this.subnetId);
				IPInfo ipInfo = new IPInfo(subnet);

				ipInfo.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});

		btnSubnetInfo.setText("Subnet Info");
		btnSubnetInfo.setBounds(264, 500, 220, 35);

		getContentPane().add(btnAddIP);
		getContentPane().add(panel);
		getContentPane().add(btnDelete);
		getContentPane().add(btnManageDevices);
		getContentPane().add(btnSubnetInfo);
	}
}
