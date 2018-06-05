package NetWork.View;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;

import NetWork.Controls.FlatButton;
import NetWork.Controls.FrameWindow;

import javax.swing.JList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class MainView extends FrameWindow {
	public MainView() {
	
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("192.168.0.0/23");
		listModel.addElement("10.10.10.0/24");
		listModel.addElement("168.211.252.0/12");
		
		JList<String> list = new JList<String>(listModel);
		list.setBackground(new Color(204, 204, 204));
		list.setBounds(10, 11, 474, 379);
		
		getContentPane().add(list);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 402, 267, 11);
		getContentPane().add(separator);
		
		FlatButton btnNewNetwork = new FlatButton("New Network");
		btnNewNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetworkView view = new NetworkView();
				
				view.setVisible(true);
			}
		});
		btnNewNetwork.setBounds(20, 424, 132, 34);
		getContentPane().add(btnNewNetwork);
		
		FlatButton btnDeleteNetwork = new FlatButton("Delete Network");
		btnDeleteNetwork.setBounds(180, 424, 132, 34);
		getContentPane().add(btnDeleteNetwork);
		
		FlatButton btnShowSubnets = new FlatButton("Show Subnets");
		btnShowSubnets.setForeground(Color.WHITE);
		btnShowSubnets.setBounds(335, 424, 132, 34);
		getContentPane().add(btnShowSubnets);
		
		FlatButton btnOptions = new FlatButton("Options");
		btnOptions.setBounds(20, 476, 132, 34);
		getContentPane().add(btnOptions);
		
		FlatButton btnLoad = new FlatButton("Load");
		btnLoad.setBounds(180, 476, 132, 34);
		getContentPane().add(btnLoad);
		
		FlatButton btnSave = new FlatButton("Save");
		btnSave.setBounds(335, 476, 132, 34);
		getContentPane().add(btnSave);
		
		this.setVisible(true);
	}
}
