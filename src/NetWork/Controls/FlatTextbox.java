package NetWork.Controls;

import NetWork.Controls.Helper.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class FlatTextbox extends JTextPane{

	public FlatTextbox() {
		super();
		
		Border border = BorderFactory.createLineBorder(Color.BORDER_GREY.getAWTColor());
		this.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		this.setBackground(Color.WHITE);
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
