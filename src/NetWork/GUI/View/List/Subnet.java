package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FrameWindow;

import javax.swing.*;
import java.awt.Button;

import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.SubnetModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

public class Subnet extends ListView<SubnetModel<SubnetAddress>, SubnetAddress> {

	protected int networkId;

	public Subnet(int networkId) {
		this.networkId = networkId;
		this.tableModel = new SubnetModel(this.networkId);
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
				SubnetAddress subnet = this.getSelectedElement();

				DatabaseService.getService().DeleteSubnetById(subnet.getId());

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
