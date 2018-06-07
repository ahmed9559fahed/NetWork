package NetWork.GUI.View.List;

import javax.swing.*;
import javax.swing.table.TableColumn;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.NetworkModel;
import NetWork.GUI.View.Window.IPInfo;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Network extends ListView<NetworkModel<NetworkAddress>, NetworkAddress> {
	public Network() {
		this.setSize(new Dimension(490, 580));
		//TODO Load network model to get ip and prefix to show in title
		this.setTitle("List of networks");

		this.tableModel = new NetworkModel();
		this.reloadTable();
		
		FlatButton btnNewNetwork = new FlatButton("New Network");
		btnNewNetwork.addActionListener(e -> {
			NetWork.GUI.View.Formular.Network view = new NetWork.GUI.View.Formular.Network();

			view.setVisible(true);

			ReloadListView listener = new ReloadListView(this, view);
			view.addWindowListener(listener);
		});

		btnNewNetwork.setBounds(10, 454, 220, 35);
		getContentPane().add(btnNewNetwork);
		
		FlatButton btnDeleteNetwork = new FlatButton("Delete Network");
		btnDeleteNetwork.setBounds(254, 454, 220, 35);
		btnDeleteNetwork.addActionListener(e -> {
			try {
				NetworkAddress network = this.getSelectedElement();

				DatabaseService.getService().DeleteNetworkById(network.GetId());

				reloadTable();
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});
		getContentPane().add(btnDeleteNetwork);
		
		FlatButton btnShowSubnets = new FlatButton("Show Subnets");
		btnShowSubnets.addActionListener(e -> {
			try {
				NetworkAddress network = getSelectedElement();

				Subnet subnetView = new Subnet(network.getId());

				subnetView.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});

		btnShowSubnets.setForeground(Color.WHITE);
		btnShowSubnets.setBounds(254, 500, 220, 35);
		getContentPane().add(btnShowSubnets);

		/*
		 * Table
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 474, 437);
		getContentPane().add(panel);

		table = new JTable(this.tableModel);

		TableColumn column = null;
		for (int i = 0; i < 3; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 2) {
				column.setPreferredWidth(200); //sport column is bigger
			} else {
				column.setPreferredWidth(50);
			}
		}

		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		panel.add(scrollPane);
		
		FlatButton flatButton = new FlatButton("IP Info");
		flatButton.addActionListener(e -> {
			try {
				NetworkAddress network = getSelectedElement();
				IPInfo ipInfo = new IPInfo(network);

				ipInfo.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});
		flatButton.setForeground(Color.WHITE);
		flatButton.setBounds(10, 500, 220, 35);
		getContentPane().add(flatButton);
	}
}