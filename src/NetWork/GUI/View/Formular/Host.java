package NetWork.GUI.View.Formular;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.Device;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.ComboBox.DeviceModel;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FlatTextbox;
import NetWork.GUI.View.Controls.FrameWindow;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("serial")
public class Host extends FrameWindow {

	protected int windowWidth = 230;
	protected int windowHeight = 370;

	protected SubnetAddress subnetAddress;
	protected int SubnetId;

	public Host(int subnetId) {
		this.SubnetId = subnetId;
		this.subnetAddress = DatabaseService.getService().GetSubnetAddressById(subnetId);

		this.setSize(new Dimension(windowWidth, windowHeight));
		
		FrameWindow window = this;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/*
		 * HEADLINE
		 */
		JLabel lblAddNewNetwork = new JLabel("Add new IP Adress");
		lblAddNewNetwork.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddNewNetwork.setBounds(12, 11, 202, 32);
		
	
		JSeparator headlineSeparator = new JSeparator();
		headlineSeparator.setBounds(10, 41, 202, 12);
		
		
		/*
		 * IP ADDRESS 
		 */
		JLabel lblNewLabel = new JLabel("IP Adresse");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 63, 127, 14);

		IPv4Object ipObject = new IPv4Object(subnetAddress.getSubnetAddress() + "/" + subnetAddress.getPrefix());

		List<String> ipList = ipObject.getAvailableIPs(ipObject.getNumberOfHosts());

		String[] convertedIPList = new String[ipList.size()];
		convertedIPList = ipList.toArray(convertedIPList);

		JComboBox<Object> IPBox = new JComboBox<Object>(convertedIPList);
		IPBox.setBounds(12, 88, 202, 26);
		
		/*
		 * DEVICE
		 */
		JLabel lblDevice = new JLabel("Device");
		lblDevice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDevice.setBounds(12, 134, 127, 14);

		JComboBox<Object> deviceBox = new JComboBox<Object>(new DeviceModel());
		deviceBox.setBounds(12, 159, 202, 26);

	
		/*
		 * DESCRIPTION
		 */
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(12, 209, 127, 14);
		
		
		FlatTextbox txtDescription = new FlatTextbox();
		txtDescription.setBounds(12, 234, 202, 25);
		
		/*
		 * Button separator
		 */
		JSeparator buttonSeparator = new JSeparator();
		buttonSeparator.setBounds(12, 272, 202, 12);
		
		
		/*
		 * Cancel button 
		 */
		FlatButton btnCancel = new FlatButton((String) null);
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				window.dispose();
			}
		});
		
		btnCancel.setBounds(12, 295, 91, 29);
		

		/*
		 * SAVE button
		 */
		FlatButton btnSave = new FlatButton((String) null);
		btnSave.setText("Save");
		btnSave.setBounds(123, 295, 91, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetWork.Data.Database.Models.Host host = new NetWork.Data.Database.Models.Host();

				Object selectedIP = IPBox.getSelectedItem();
				Object selectedDevice = deviceBox.getSelectedItem();
				String description = txtDescription.getText();
				//st.setIPAddress(IPAddress);

				host.setSubnetId(SubnetId);
				host.setIPAddress((String)selectedIP);
				host.setDevice(((Device)selectedDevice).getId());

				host.setDescription(description);

				DatabaseService.getService().AddHost(host);

				window.setVisible(false);
				window.dispose();
			}
		});

		getContentPane().add(lblAddNewNetwork);
		getContentPane().add(headlineSeparator);
		getContentPane().add(lblNewLabel);
		getContentPane().add(buttonSeparator);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		getContentPane().add(IPBox);
		getContentPane().add(lblDevice);
		getContentPane().add(deviceBox);
		getContentPane().add(lblDescription);
		getContentPane().add(txtDescription);
		
	}
}
