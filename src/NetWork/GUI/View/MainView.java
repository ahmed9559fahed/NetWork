package NetWork.GUI.View;

import javax.swing.JSeparator;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.Interface.IReloadableListView;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.NetworkModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class MainView extends ListView<NetworkModel> {

	public MainView() {
		this.tableModel = new NetworkModel();
		this.tableModel.Load();

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 480, 488, 11);
		getContentPane().add(separator);
		
		FlatButton btnNewNetwork = new FlatButton("New Network");
		btnNewNetwork.addActionListener(e -> {
			NetworkView view = new NetworkView();

			view.setVisible(true);

			ReloadListView listener = new ReloadListView(this, view);
			view.addWindowListener(listener);
		});

		btnNewNetwork.setBounds(6, 505, 132, 34);
		getContentPane().add(btnNewNetwork);
		
		FlatButton btnDeleteNetwork = new FlatButton("Delete Network");
		btnDeleteNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetworkAddress network = getSelectedElement();

				DatabaseService.getService().DeleteNetworkById(network.GetId());

				reloadTable();
			}
		});

		btnDeleteNetwork.setBounds(176, 505, 148, 35);
		getContentPane().add(btnDeleteNetwork);
		
		FlatButton btnShowSubnets = new FlatButton("Show Subnets");
		btnShowSubnets.addActionListener(e -> {
			NetworkAddress network = getSelectedElement();

			SubnetListView subnetView = new SubnetListView(network.getId());

			subnetView.setVisible(true);
		});

		btnShowSubnets.setForeground(Color.WHITE);
		btnShowSubnets.setBounds(352, 505, 132, 34);
		getContentPane().add(btnShowSubnets);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 488, 437);
		getContentPane().add(panel);

		table = new JTable(this.tableModel);
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		panel.add(scrollPane);

		this.setVisible(true);
	}
	
	protected NetworkAddress getSelectedElement() {
		int selectedRow = table.getSelectedRow();
		NetworkAddress network = tableModel.getRow(selectedRow);
		
		return network;
	}

}