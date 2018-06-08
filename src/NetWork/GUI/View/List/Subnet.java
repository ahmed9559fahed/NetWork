package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;

import javax.swing.*;
import javax.xml.crypto.Data;

import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.SubnetModel;
import NetWork.GUI.View.Window.IPInfo;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnAddNewSubnet.setBounds(10, 454, 220, 35);

		btnAddNewSubnet.addActionListener(e -> {
			NetWork.GUI.View.Formular.Subnet formularView = new NetWork.GUI.View.Formular.Subnet(networkId);
			formularView.setVisible(true);

			ReloadListView listener = new ReloadListView(this, formularView);
			formularView.addWindowListener(listener);
		});

		/*
		 * Button
		 */
		FlatButton fltbtnShowInfo = new FlatButton((String) null);
		fltbtnShowInfo.setText("Delete Subnet");
		fltbtnShowInfo.setBounds(10, 505, 220, 35);
		fltbtnShowInfo.addActionListener(e -> {
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
		flatButton_1.setBounds(264, 454, 220, 35);
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
		getContentPane().add(fltbtnShowInfo);
		
		FlatButton fltbtnIpInfo = new FlatButton((String) null);
		fltbtnIpInfo.addActionListener(e -> {
			try {
				SubnetAddress subnet = getSelectedElement();
				IPInfo ipInfo = new IPInfo(subnet);

				ipInfo.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid network!");
			}
		});
		
		fltbtnIpInfo.setText("IP Info");
		fltbtnIpInfo.setBounds(264, 505, 220, 35);
		getContentPane().add(fltbtnIpInfo);
	}
}
