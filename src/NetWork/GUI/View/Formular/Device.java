package NetWork.GUI.View.Formular;

import NetWork.Business.Calculater.IPv4.IPv4Object;
import NetWork.Data.Database.Models.SubnetAddress;
import NetWork.Data.Database.Service.DatabaseService;
import NetWork.GUI.View.Controls.FlatButton;
import NetWork.GUI.View.Controls.FrameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import NetWork.GUI.View.Controls.FlatTextbox;

@SuppressWarnings("serial")
public class Device extends FrameWindow {

	protected int windowWidth = 230;
	protected int windowHeight = 370;

	protected boolean updateEntry = false;
	protected NetWork.Data.Database.Models.Device updateDevice;


	public Device(NetWork.Data.Database.Models.Device device) {
		this.updateEntry = true;
		this.updateDevice = device;

		loadContent();
	}

	public Device() {
		loadContent();
	}

	protected void loadContent() {
		this.setSize(new Dimension(windowWidth, windowHeight));

		FrameWindow window = this;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/*
		 * HEADLINE
		 */
		JLabel lblAddNewNetwork;
		if(updateEntry == true) {
			lblAddNewNetwork = new JLabel("Edit Device");
		} else {
			lblAddNewNetwork = new JLabel("Add Device");
		}
		lblAddNewNetwork.setFont(new Font("Calibri", Font.BOLD, 20));
		lblAddNewNetwork.setBounds(12, 11, 202, 32);


		JSeparator headlineSeparator = new JSeparator();
		headlineSeparator.setBounds(10, 41, 202, 12);

		/*
		 * Device name
		 */
		JLabel lblDeviceName = new JLabel("Device Name");
		lblDeviceName.setBounds(12, 51, 93, 14);


		FlatTextbox txtDeviceName = new FlatTextbox();
		if(this.updateEntry == true) {
			txtDeviceName.setText(this.updateDevice.getName());
		}
		txtDeviceName.setBounds(12, 76, 202, 25);

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
				NetWork.Data.Database.Models.Device device = new NetWork.Data.Database.Models.Device();
				if(updateEntry == true){
					device.setId(updateDevice.getId());
				}
				device.setName(txtDeviceName.getText());


				if (updateEntry == true) {
					DatabaseService.getService().UpdateDevice(device);
				} else {
					DatabaseService.getService().AddDevice(device);
				}

				window.setVisible(false);
				window.dispose();
			}
		});

		getContentPane().add(lblAddNewNetwork);
		getContentPane().add(headlineSeparator);
		getContentPane().add(lblDeviceName);
		getContentPane().add(txtDeviceName);
		getContentPane().add(buttonSeparator);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
	}
}
