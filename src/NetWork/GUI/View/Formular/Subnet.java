package NetWork.GUI.View.Formular;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.NetworkAddress;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FlatTextbox;
import NetWork.GUI.View.Controls.FrameWindow;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Subnet extends FrameWindow {

	protected int windowWidth = 230;
	protected int windowHeight = 370;

	protected int networkId;


	public Subnet(int networkId) {
		this.networkId = networkId;
		NetworkAddress network = DatabaseService.getService().GetNetworkAddressById(networkId);
		IPv4Object iPv4NetworkObject = new IPv4Object(network.getIPAddress() + "/" + network.getPrefix());


		this.setSize(new Dimension(windowWidth, windowHeight));
		
		FrameWindow window = this;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/*
		 * HEADLINE
		 */
		JLabel lblAddNewNetwork = new JLabel("Add new Subnet");
		lblAddNewNetwork.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddNewNetwork.setBounds(12, 11, 202, 32);
		getContentPane().add(lblAddNewNetwork);
		
		JSeparator headlineSeparator = new JSeparator();
		headlineSeparator.setBounds(10, 41, 202, 12);
		getContentPane().add(headlineSeparator);
		
		
		/*
		 * IPv4 IPv6 Selector
		 */
		/*JRadioButton rdbtnIpv = new JRadioButton("IPv4");
		rdbtnIpv.setSelected(true);
		rdbtnIpv.setBackground(new Color(255, 255, 255));
		rdbtnIpv.setBounds(12, 54, 74, 23);
		getContentPane().add(rdbtnIpv);
		
		JRadioButton radioButton = new JRadioButton("IPv6");
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setBounds(84, 54, 74, 23);
		getContentPane().add(radioButton);*/
		
		
		/*
		 * IP ADDRESS 
		 */
		JLabel lblNewLabel = new JLabel("Network Address:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 94, 127, 14);
		getContentPane().add(lblNewLabel);

		FlatTextbox ipTextbox = new FlatTextbox();
		ipTextbox.setEditable(false);
		ipTextbox.setBounds(12, 117, 202, 29);
		ipTextbox.setText(iPv4NetworkObject.getCIDR());
		getContentPane().add(ipTextbox);
		
		
		/*
		 * IP PREFIX
		 */
		JLabel lblNetzwerkPrefix = new JLabel("Subnetz Prefix:");
		lblNetzwerkPrefix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNetzwerkPrefix.setBounds(12, 153, 127, 14);
		getContentPane().add(lblNetzwerkPrefix);


		MaskFormatter ipv4Prefix = null;
		try {
			ipv4Prefix = new MaskFormatter("##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		FlatTextbox prefixTextbox = new FlatTextbox(ipv4Prefix);
		prefixTextbox.setBounds(12, 176, 202, 29);
		getContentPane().add(prefixTextbox);
		/*
		 * Button separator
		 */
		JSeparator buttonSeparator = new JSeparator();
		buttonSeparator.setBounds(12, 272, 202, 12);
		getContentPane().add(buttonSeparator);
		
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
		getContentPane().add(btnCancel);

		/*
		 * SAVE button
		 */
		FlatButton btnSave = new FlatButton((String) null);
		btnSave.setText("Save");
		btnSave.setBounds(123, 295, 91, 29);
		btnSave.addActionListener(e-> {
			try {
				SubnetAddress subnet = new SubnetAddress();
				subnet.setSubnetAddress(iPv4NetworkObject.getIP());
				subnet.setPrefix(Integer.parseInt(prefixTextbox.getText()));
				subnet.setBitFormat(iPv4NetworkObject.getIP());
				subnet.setNetworkId(networkId);

				IPv4Object obj=new IPv4Object(iPv4NetworkObject.getIP() + "/" + prefixTextbox.getText());
				ArrayList<SubnetAddress> subnets = obj.GetSubnets(obj.getIP(), Integer.parseInt(prefixTextbox.getText()), networkId);

				for (SubnetAddress object : subnets) {
					DatabaseService.getService().AddSubnet(object);
				}
			} catch (Exception exception) {
				prefixTextbox.displayErrorBorder();
				ShowError(exception.getMessage());
				return;
			}

			window.setVisible(false);
			window.dispose();

		});

		getContentPane().add(btnSave);
	}
}
