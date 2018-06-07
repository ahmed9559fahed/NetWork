package NetWork.GUI.View.Window;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.FlatButton;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import NetWork.GUI.View.Controls.FlatTextbox;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Dimension;

public class IPInfo extends FrameWindow {
	public IPInfo(int subnetId) {
        //SubnetAddress subnet = DatabaseService.getService().GetSubnetAddressById(subnetId);
        //IPv4Object ipv4Object = new IPv4Object(subnet.getSubnetAddress() + "/" + "PREFIX");

		this.setSize(new Dimension(600, 580));

		FlatButton btnClose = new FlatButton((String) null);
        btnClose.setText("Close");
        btnClose.setBounds(242, 506, 116, 35);
		getContentPane().add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 487, 588, 12);
		getContentPane().add(separator);
		
		JLabel lblIpInformationsFor = new JLabel("IP information for 192.168.0.0/24");
		lblIpInformationsFor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIpInformationsFor.setBounds(142, 16, 315, 16);
		getContentPane().add(lblIpInformationsFor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 44, 588, 12);
		getContentPane().add(separator_1);
		
		JLabel lblNetworkIp = new JLabel("Network IP:");
		lblNetworkIp.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetworkIp.setBounds(6, 73, 86, 16);
		getContentPane().add(lblNetworkIp);
		
		JLabel lblBrodcast = new JLabel("Brodcast:");
		lblBrodcast.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrodcast.setBounds(6, 120, 65, 16);
		getContentPane().add(lblBrodcast);
		
		JLabel lblNetmask = new JLabel("Netmask:");
		lblNetmask.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetmask.setBounds(6, 167, 65, 16);
		getContentPane().add(lblNetmask);
		
		JLabel lblHostRange = new JLabel("Host range:");
		lblHostRange.setHorizontalAlignment(SwingConstants.LEFT);
		lblHostRange.setBounds(6, 216, 76, 16);
		getContentPane().add(lblHostRange);
		
		JLabel lblNumberOfHosts = new JLabel("Number of hosts:");
		lblNumberOfHosts.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumberOfHosts.setBounds(6, 266, 116, 16);
		getContentPane().add(lblNumberOfHosts);
		
		FlatTextbox txtNetwork = new FlatTextbox();
		txtNetwork.setEditable(false);
		txtNetwork.setBounds(134, 68, 137, 25);
		getContentPane().add(txtNetwork);
		
		FlatTextbox txtBrodcast = new FlatTextbox();
		txtBrodcast.setEditable(false);
		txtBrodcast.setBounds(134, 115, 137, 25);
		getContentPane().add(txtBrodcast);
		
		FlatTextbox txtNetmask = new FlatTextbox();
		txtNetmask.setEditable(false);
		txtNetmask.setBounds(134, 162, 137, 25);
		getContentPane().add(txtNetmask);
		
		FlatTextbox txtHostRange = new FlatTextbox();
		txtHostRange.setEditable(false);
		txtHostRange.setBounds(134, 211, 137, 25);
		getContentPane().add(txtHostRange);
		
		FlatTextbox txtHostNumbers = new FlatTextbox();
		txtHostNumbers.setEditable(false);
		txtHostNumbers.setBounds(134, 261, 137, 25);
		getContentPane().add(txtHostNumbers);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 298, 588, 12);
		getContentPane().add(separator_2);

		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Jane Doe");
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");
		
		JList<String> ipList = new JList<String>(listModel);
		ipList.setBackground(Color.LIGHT_GRAY);
		ipList.setBounds(69, 322, 461, 153);
		getContentPane().add(ipList);
		
		FlatTextbox txtBNetwork = new FlatTextbox();
		txtBNetwork.setEditable(false);
		txtBNetwork.setBounds(283, 68, 282, 25);
		getContentPane().add(txtBNetwork);
		
		FlatTextbox txtBBrodcast = new FlatTextbox();
		txtBBrodcast.setEditable(false);
		txtBBrodcast.setBounds(283, 115, 282, 25);
		getContentPane().add(txtBBrodcast);
		
		FlatTextbox txtBNetmask = new FlatTextbox();
		txtBNetmask.setEditable(false);
		txtBNetmask.setBounds(283, 162, 282, 25);
		getContentPane().add(txtBNetmask);
	}
}
