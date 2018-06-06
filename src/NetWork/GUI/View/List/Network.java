package NetWork.GUI.View.List;

import javax.swing.JSeparator;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.NetworkModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class Network extends ListView<NetworkModel<NetworkAddress>, NetworkAddress> {

	public Network() {
		this.tableModel = new NetworkModel();
		this.reloadTable();

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 480, 488, 11);
		getContentPane().add(separator);
		
		FlatButton btnNewNetwork = new FlatButton("New Network");
		btnNewNetwork.addActionListener(e -> {
			NetWork.GUI.View.Formular.Network view = new NetWork.GUI.View.Formular.Network();

			view.setVisible(true);

			ReloadListView listener = new ReloadListView(this, view);
			view.addWindowListener(listener);
		});

		btnNewNetwork.setBounds(6, 505, 132, 34);
		getContentPane().add(btnNewNetwork);
		
		FlatButton btnDeleteNetwork = new FlatButton("Delete Network");
		btnDeleteNetwork.setBounds(176, 505, 148, 35);
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
		btnShowSubnets.setBounds(352, 505, 132, 34);
		getContentPane().add(btnShowSubnets);

		/*
		 * Table
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 488, 437);
		getContentPane().add(panel);

		table = new JTable(this.tableModel);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		panel.add(scrollPane);
	}
}