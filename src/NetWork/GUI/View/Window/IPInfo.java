package NetWork.GUI.View.Window;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.NetworkAddress;
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
import java.util.List;

public class IPInfo extends FrameWindow {

	protected IPv4Object IPObject;

	public IPInfo(NetworkAddress network) {
        //IPv4Object ipv4Object = new IPv4Object(subnet.getSubnetAddress() + "/" + "PREFIX");

		this.loadContent();
		IPObject = new IPv4Object(network.getIPAddress()+"/"+network.getPrefix());
	}

	public IPInfo(SubnetAddress subnet) {
		this.loadContent();
		IPObject = new IPv4Object(subnet.getSubnetAddress()+"/"+subnet.getPrefix());

	}

	public void loadContent() {
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
		txtNetwork.setText(IPObject.getIP());
		txtNetwork.setBounds(134, 68, 137, 25);
		getContentPane().add(txtNetwork);

		FlatTextbox txtBrodcast = new FlatTextbox();
		txtBrodcast.setEditable(false);
		txtBrodcast.setText(IPObject.getBroadcastAddress());
		txtBrodcast.setBounds(134, 115, 137, 25);
		getContentPane().add(txtBrodcast);

		FlatTextbox txtNetmask = new FlatTextbox();
		txtNetmask.setEditable(false);
		txtNetmask.setText(IPObject.getNetmask());
		txtNetmask.setBounds(134, 162, 137, 25);
		getContentPane().add(txtNetmask);

		FlatTextbox txtHostRange = new FlatTextbox();
		txtHostRange.setEditable(false);
		txtHostRange.setText(IPObject.getHostAddressRange());
		txtHostRange.setBounds(134, 211, 137, 25);
		getContentPane().add(txtHostRange);

		FlatTextbox txtHostNumbers = new FlatTextbox();
		txtHostNumbers.setEditable(false);
		txtHostNumbers.setText(IPObject.getNumberOfHosts()+"");
		txtHostNumbers.setBounds(134, 261, 137, 25);
		getContentPane().add(txtHostNumbers);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 298, 588, 12);
		getContentPane().add(separator_2);


		DefaultListModel<String> listModel = new DefaultListModel<String>();

		int numberOfHosts=Integer.parseInt(IPObject.getNumberOfHosts()+"");
		List<String> availableIPs = IPObject.getAvailableIPs(numberOfHosts);
		for (String ip : availableIPs)
		{
			listModel.addElement(ip);
		}

		JList<String> ipList = new JList<String>(listModel);
		ipList.setBackground(Color.LIGHT_GRAY);
		ipList.setBounds(69, 322, 461, 153);
		getContentPane().add(ipList);

		FlatTextbox txtBNetwork = new FlatTextbox();
		txtBNetwork.setEditable(false);
		txtBNetwork.setText(IPObject.GetBinary(IPObject.getIP()));
		txtBNetwork.setBounds(283, 68, 282, 25);
		getContentPane().add(txtBNetwork);

		FlatTextbox txtBBrodcast = new FlatTextbox();
		txtBBrodcast.setEditable(false);
		txtBBrodcast.setText(IPObject.GetBinary(IPObject.getBroadcastAddress()));
		txtBBrodcast.setBounds(283, 115, 282, 25);
		getContentPane().add(txtBBrodcast);

		FlatTextbox txtBNetmask = new FlatTextbox();
		txtBNetmask.setEditable(false);
		txtBNetmask.setText(IPObject.GetBinary(IPObject.getNetmask()));
		txtBNetmask.setBounds(283, 162, 282, 25);
		getContentPane().add(txtBNetmask);
	}
}
