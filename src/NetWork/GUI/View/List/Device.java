package NetWork.GUI.View.List;

import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.ListView;
import NetWork.GUI.View.Controls.Listener.ReloadListView;
import NetWork.GUI.View.Controls.Table.DeviceModel;
import NetWork.GUI.View.Controls.Table.HostModel;
import NetWork.GUI.View.Window.IPInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Device extends ListView<DeviceModel<NetWork.Data.Database.Models.Device>, NetWork.Data.Database.Models.Device> {

	public Device() {
		//TODO load network and subnet to get title
		this.setTitle("List all devices");


		this.tableModel = new DeviceModel<>();
		this.reloadTable();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

		/*
		 * Button
		 */
		FlatButton btnAddIP = new FlatButton((String) null);
		btnAddIP.setText("Add Device");
		btnAddIP.setBounds(6, 454, 220, 35);

		btnAddIP.addActionListener(e -> {
			NetWork.GUI.View.Formular.Device deviceView = new NetWork.GUI.View.Formular.Device();
			
			deviceView.setVisible(true);
			
			ReloadListView listener = new ReloadListView(this, deviceView);
			deviceView.addWindowListener(listener);
		});

		/*
		 * Button
		 */
		FlatButton btnDelete = new FlatButton(null);
		btnDelete.setText("Delete Device");
		btnDelete.setBounds(264, 454, 220, 35);
		btnDelete.addActionListener(e -> {
			try {
				NetWork.Data.Database.Models.Device device = this.getSelectedElement();

				if(DatabaseService.getService().DeleteDeviceById(device.getId()) == false) {
					this.ShowError("Bitte stellen Sie sicher, dass das Gerät keiner IP zugeordnet ist.");
					return;
				}

				reloadTable();
			} catch (ArrayIndexOutOfBoundsException aiofbException) {
				this.ShowError("Please select a valid ip address!");
			}
		});

		/*
		 * Button
		 */
		FlatButton btnEditDevice = new FlatButton(null);
		btnEditDevice.setText("Edit Device");
		btnEditDevice.setBounds(6, 500, 220, 35);
		btnEditDevice.addActionListener(e -> {
			NetWork.Data.Database.Models.Device device = getSelectedElement();
			NetWork.GUI.View.Formular.Device deviceView = new NetWork.GUI.View.Formular.Device(device);

			deviceView.setVisible(true);

			ReloadListView listener = new ReloadListView(this, deviceView);
			deviceView.addWindowListener(listener);
		});
		/*
		 * Button
		 */
		FlatButton btnShowIPs = new FlatButton((String) null);
		btnShowIPs.setText("Show IPs");
		btnShowIPs.setBounds(264, 500, 220, 35);
		btnShowIPs.addActionListener(e -> {
			this.ShowError("not implemented!");
		});


		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().add(btnAddIP);
		getContentPane().add(btnDelete);
		getContentPane().add(btnEditDevice);
		getContentPane().add(btnShowIPs);
		
	}
}
