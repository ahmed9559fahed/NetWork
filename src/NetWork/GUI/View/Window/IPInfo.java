package NetWork.GUI.View.Window;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.GUI.View.Controls.FlatButton;

import javax.swing.*;
import java.awt.*;

import NetWork.GUI.View.Controls.FlatTextbox;

import java.util.List;

@SuppressWarnings("serial")
public class IPInfo extends FrameWindow {

	protected IPv4Object IPObject;
	protected int Prefix;
	protected String Ip;

	/**
	 * @wbp.parser.constructor
	 */
	public IPInfo(NetworkAddress network) {
        //IPv4Object ipv4Object = new IPv4Object(subnet.getSubnetAddress() + "/" + "PREFIX");
		IPObject = new IPv4Object(network.getIPAddress()+"/"+network.getPrefix());
		Prefix=network.getPrefix();
		this.loadContent();

	}

	public IPInfo(SubnetAddress subnet) {
		IPObject = new IPv4Object(subnet.getSubnetAddress()+"/"+subnet.getPrefix());
		Prefix=subnet.getPrefix();
		this.loadContent();

	}

	public void loadContent() {
		this.setSize(new Dimension(600, 580));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/**
		 * HEADLINE
		 */
		JLabel lblIpInformationsFor = new JLabel("IP information for " + IPObject.getIP() + "/" + Prefix);
		lblIpInformationsFor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIpInformationsFor.setBounds(142, 16, 315, 16);
		getContentPane().add(lblIpInformationsFor);

		/* ------------------------------------------------------- */
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 487, 588, 12);
		getContentPane().add(separator);
		/* ------------------------------------------------------- */

		/* ============================================================= */

		/**
		 * NETWORK
		 */
		//label
		JLabel lblNetworkIp = new JLabel("Network IP:");
		lblNetworkIp.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetworkIp.setBounds(6, 73, 86, 16);
		getContentPane().add(lblNetworkIp);

		Ip=IPObject.getIP();
		//default ip
		FlatTextbox txtNetwork = new FlatTextbox();
		txtNetwork.setEditable(false);
		txtNetwork.setText(IPObject.getIP());
		txtNetwork.setBounds(134, 68, 137, 25);
		getContentPane().add(txtNetwork);

		//bit ip
		FlatTextbox txtBNetwork = new FlatTextbox();
		txtBNetwork.setEditable(false);
		txtBNetwork.setText(IPObject.GetBinary(IPObject.getIP()));
		txtBNetwork.setBounds(283, 68, 282, 25);
		getContentPane().add(txtBNetwork);

		/* ============================================================= */

		/**
		 * BRODCAST
		 */
		//label
		JLabel lblBrodcast = new JLabel("Brodcast:");
		lblBrodcast.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrodcast.setBounds(6, 120, 65, 16);
		getContentPane().add(lblBrodcast);

		//default ip
		FlatTextbox txtBrodcast = new FlatTextbox();
		txtBrodcast.setEditable(false);
		txtBrodcast.setText(IPObject.getBroadcastAddress());
		txtBrodcast.setBounds(134, 115, 137, 25);
		getContentPane().add(txtBrodcast);

		//bit ip
		FlatTextbox txtBBrodcast = new FlatTextbox();
		txtBBrodcast.setEditable(false);
		txtBBrodcast.setText(IPObject.GetBinary(IPObject.getBroadcastAddress()));
		txtBBrodcast.setBounds(283, 115, 282, 25);
		getContentPane().add(txtBBrodcast);

		/* ============================================================= */

		/**
		 * NETMASK
		 */
		//label
		JLabel lblNetmask = new JLabel("Netmask:");
		lblNetmask.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetmask.setBounds(6, 167, 65, 16);
		getContentPane().add(lblNetmask);

		//default ip
		FlatTextbox txtNetmask = new FlatTextbox();
		txtNetmask.setEditable(false);
		txtNetmask.setText(IPObject.getNetmask());
		txtNetmask.setBounds(134, 162, 137, 25);
		getContentPane().add(txtNetmask);

		//bit ip
		FlatTextbox txtBNetmask = new FlatTextbox();
		txtBNetmask.setEditable(false);
		txtBNetmask.setText(IPObject.GetBinary(IPObject.getNetmask()));
		txtBNetmask.setBounds(283, 162, 282, 25);
		getContentPane().add(txtBNetmask);

		/* ============================================================= */

		/**
		 * HOST RANGE
		 */
		//label
		IPv4Object op=new IPv4Object(Ip+"/"+Prefix);
		JLabel lblHostRange = new JLabel("Host range:");
		lblHostRange.setHorizontalAlignment(SwingConstants.LEFT);
		lblHostRange.setBounds(6, 216, 76, 16);
		getContentPane().add(lblHostRange);

		//input field
		FlatTextbox txtHostRange = new FlatTextbox();
		txtHostRange.setEditable(false);
		txtHostRange.setText(op.getHostAddressRange());
		txtHostRange.setBounds(134, 211, 431, 25);
		getContentPane().add(txtHostRange);

		/* ============================================================= */

		/**
		 * NUMBER OF HOSTS
		 */
		//label
		JLabel lblNumberOfHosts = new JLabel("Number of hosts:");
		lblNumberOfHosts.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumberOfHosts.setBounds(6, 266, 116, 16);
		getContentPane().add(lblNumberOfHosts);

		//input field
		FlatTextbox txtHostNumbers = new FlatTextbox();
		txtHostNumbers.setEditable(false);
		txtHostNumbers.setText(IPObject.getNumberOfHosts()+"");
		txtHostNumbers.setBounds(134, 261, 137, 25);
		getContentPane().add(txtHostNumbers);

		/* ------------------------------------------------------- */
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 298, 588, 12);
		getContentPane().add(separator_2);
		/* ------------------------------------------------------- */

		/* ============================================================= */

		/**
		 * IP LIST
		 */

		DefaultListModel<String> listModel = new DefaultListModel<String>();



		List<String> availableIPs = op.getAvailableIPs(Integer.parseInt(op.getNumberOfHosts()+""));
		for (String ip : availableIPs)
		{
			listModel.addElement(ip);
		}

		JScrollPane ipListScrollPane = new JScrollPane();

		JList<String> ipList = new JList<>(listModel);
		ipList.setBackground(Color.LIGHT_GRAY);

		ipListScrollPane.setViewportView(ipList);
		ipListScrollPane.setBounds(69, 322, 461, 153);
		getContentPane().add(ipListScrollPane);

		/* ------------------------------------------------------- */
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 44, 588, 12);
		getContentPane().add(separator_1);
		/* ------------------------------------------------------- */

		/* ============================================================= */

		FlatButton btnClose = new FlatButton(null);
		btnClose.setText("Close");
		btnClose.setBounds(242, 506, 116, 35);
		btnClose.addActionListener(e -> {
			this.setVisible(false);
			this.dispose();
		});
		
		getContentPane().add(btnClose);
	}
}
