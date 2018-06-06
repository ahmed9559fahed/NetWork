package NetWork.GUI.View.Controls;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.Border;

import NetWork.GUI.View.Controls.Helper.Color;

@SuppressWarnings("serial")
public class FlatButton extends JButton {

	public FlatButton(String text) {
        this(text, null);
    }
	
	public FlatButton(String text, Icon icon) {
		super(text, icon);

		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setOpaque(true);
		//this.setBorder(new RoundedBorder(50));
		//this.setContentAreaFilled(false);
		
		this.setBackgroud(Color.PRIMARY);
		this.setForeground(Color.WHITE);
	}
	
	public void setBackgroud(Color color) {
		java.awt.Color convertedColor = java.awt.Color.decode(color.getColor());
		
		this.setBackground(convertedColor);
	}
	
	public void setForeground(Color color) {
		java.awt.Color convertedColor = java.awt.Color.decode(color.getColor());
		
		this.setForeground(convertedColor);
	}

	public void setBounds(int x, int y, int width, int height) {
		int minHeight = 35;

		if(height != minHeight) {
			super.setBounds(x, y, width, minHeight);

			return;
		}

		super.setBounds(x, y, width, height);
	}
	
	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
}
