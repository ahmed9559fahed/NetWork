package NetWork.Controls;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameWindow extends JFrame {

	protected int windowWidth = 500;
	protected int windowHeight = 580;
	
	public FrameWindow() {
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setSize(new Dimension(windowWidth, windowHeight));
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	}
}
