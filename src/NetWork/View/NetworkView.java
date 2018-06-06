package NetWork.View;

import NetWork.Controls.FlatTextbox;
import NetWork.Controls.FrameWindow;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import NetWork.Controls.FlatButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class NetworkView extends FrameWindow {
	
	protected int windowWidth = 230;
	protected int windowHeight = 370;
	
	public NetworkView() {
		JTextPane textPane = new FlatTextbox();
		textPane.setBounds(12, 117, 202, 29);
		getContentPane().add(textPane);
		
		this.setSize(new Dimension(windowWidth, windowHeight));
		
		FrameWindow window = this; 
		
		JLabel lblNewLabel = new JLabel("Netzwerk Adresse:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 94, 127, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNetzwerkPrefix = new JLabel("Netzwerk Prefix:");
		lblNetzwerkPrefix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNetzwerkPrefix.setBounds(12, 153, 127, 14);
		getContentPane().add(lblNetzwerkPrefix);
		
		FlatTextbox flatTextbox = new FlatTextbox();
		flatTextbox.setBounds(12, 176, 202, 29);
		getContentPane().add(flatTextbox);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung:");
		lblBeschreibung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBeschreibung.setBounds(12, 212, 127, 14);
		getContentPane().add(lblBeschreibung);
		
		FlatTextbox flatTextbox_1 = new FlatTextbox();
		flatTextbox_1.setBounds(12, 235, 202, 29);
		getContentPane().add(flatTextbox_1);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 272, 202, 12);
		getContentPane().add(separator);
		
		JRadioButton rdbtnIpv = new JRadioButton("IPv4");
		rdbtnIpv.setSelected(true);
		rdbtnIpv.setBackground(new Color(255, 255, 255));
		rdbtnIpv.setBounds(12, 54, 74, 23);
		getContentPane().add(rdbtnIpv);
		
		JRadioButton radioButton = new JRadioButton("IPv6");
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setBounds(84, 54, 74, 23);
		getContentPane().add(radioButton);
		
		JLabel lblAddNewNetwork = new JLabel("Add new Network");
		lblAddNewNetwork.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddNewNetwork.setBounds(12, 11, 202, 32);
		getContentPane().add(lblAddNewNetwork);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 41, 202, 12);
		getContentPane().add(separator_1);
	}
}
