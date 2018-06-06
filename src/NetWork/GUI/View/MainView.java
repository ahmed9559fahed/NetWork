package NetWork.GUI.View;

import javax.swing.JSeparator;

import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FrameWindow;
import NetWork.Data.Database.Models.Table.NetworkTableModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class MainView extends FrameWindow {
	private JTable table;
	public MainView() {
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 480, 488, 11);
		getContentPane().add(separator);
		
		FlatButton btnNewNetwork = new FlatButton("New Network");
		btnNewNetwork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NetworkView view = new NetworkView();
				
				view.setVisible(true);
			}
		});
		btnNewNetwork.setBounds(6, 505, 132, 34);
		getContentPane().add(btnNewNetwork);
		
		FlatButton btnDeleteNetwork = new FlatButton("Delete Network");
		btnDeleteNetwork.setBounds(176, 505, 148, 35);
		getContentPane().add(btnDeleteNetwork);
		
		FlatButton btnShowSubnets = new FlatButton("Show Subnets");
		btnShowSubnets.setForeground(Color.WHITE);
		btnShowSubnets.setBounds(362, 503, 132, 34);
		getContentPane().add(btnShowSubnets);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 488, 437);
		getContentPane().add(panel);
		
		table = new JTable(new NetworkTableModel());
		panel.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		panel.add(scrollPane);
		
		
		this.setVisible(true);
	}
}