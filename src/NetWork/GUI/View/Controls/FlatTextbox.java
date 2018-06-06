package NetWork.GUI.View.Controls;

import NetWork.GUI.View.Controls.Helper.Color;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class FlatTextbox extends JFormattedTextField {

	public FlatTextbox(MaskFormatter mf) {
		super(mf);
	}

	public FlatTextbox() {
		super();
		
		this.displayDefaultBorder();

		this.setBackground(Color.WHITE);
	}

	public void displayDefaultBorder() {
		Border border = BorderFactory.createLineBorder(Color.BORDER_GREY.getAWTColor());
		this.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	public void displayErrorBorder() {
		Border border = BorderFactory.createLineBorder(Color.DANGER.getAWTColor());
		this.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
	}

	public void setBackground(Color color) {
		java.awt.Color convertedColor = java.awt.Color.decode(color.getColor());

		this.setBackground(convertedColor);
	}

	public void setForeground(Color color) {
		java.awt.Color convertedColor = java.awt.Color.decode(color.getColor());

		this.setForeground(convertedColor);
	}
	
	public void setBounds(int x, int y, int width, int height) {
		int minHeight = 25;

		if(height != minHeight) {
			super.setBounds(x, y, width, minHeight);

			return;
		}

		super.setBounds(x, y, width, height);
	}
}
