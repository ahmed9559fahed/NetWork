package NetWork.GUI.View;

import NetWork.GUI.View.Controls.FlatTextbox;
import NetWork.GUI.View.Controls.FrameWindow;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import java.awt.Font;
import NetWork.GUI.View.Controls.FlatButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class NetworkView extends FrameWindow {
	
	protected int windowWidth = 230;
	protected int windowHeight = 370;
	
	public NetworkView() {
		this.setSize(new Dimension(windowWidth, windowHeight));
		
		FrameWindow window = this;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/*
		 * HEADLINE
		 */
		JLabel lblAddNewNetwork = new JLabel("Add new Network");
		lblAddNewNetwork.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddNewNetwork.setBounds(12, 11, 202, 32);
		getContentPane().add(lblAddNewNetwork);
		
		JSeparator headlineSeparator = new JSeparator();
		headlineSeparator.setBounds(10, 41, 202, 12);
		getContentPane().add(headlineSeparator);
		
		
		/*
		 * IPv4 IPv6 Selector
		 */
		JRadioButton rdbtnIpv = new JRadioButton("IPv4");
		rdbtnIpv.setSelected(true);
		rdbtnIpv.setBackground(new Color(255, 255, 255));
		rdbtnIpv.setBounds(12, 54, 74, 23);
		getContentPane().add(rdbtnIpv);
		
		JRadioButton radioButton = new JRadioButton("IPv6");
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setBounds(84, 54, 74, 23);
		getContentPane().add(radioButton);
		
		
		/*
		 * IP ADDRESS 
		 */
		JLabel lblNewLabel = new JLabel("Netzwerk Adresse:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 94, 127, 14);
		getContentPane().add(lblNewLabel);

		FlatTextbox ipTextbox = new FlatTextbox();
		ipTextbox.setBounds(12, 117, 202, 29);
		getContentPane().add(ipTextbox);
		
		
		/*
		 * IP PREFIX
		 */
		JLabel lblNetzwerkPrefix = new JLabel("Netzwerk Prefix:");
		lblNetzwerkPrefix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNetzwerkPrefix.setBounds(12, 153, 127, 14);
		getContentPane().add(lblNetzwerkPrefix);
		
		FlatTextbox prefixTextbox = new FlatTextbox();
		prefixTextbox.setBounds(12, 235, 202, 29);
		getContentPane().add(prefixTextbox);
		
		
		/*
		 * DESCRIPTION
		 */
		JLabel lblBeschreibung = new JLabel("Description:");
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBeschreibung.setBounds(12, 212, 127, 14);
		getContentPane().add(lblBeschreibung);
		
		FlatTextbox descriptionTextbox = new FlatTextbox();
		descriptionTextbox.setBounds(12, 176, 202, 29);
		getContentPane().add(descriptionTextbox);
		
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				window.dispose();
			}
		});

		btnSave.setText("Save");
		btnSave.setBounds(123, 295, 91, 29);
		getContentPane().add(btnSave);
	}
}
