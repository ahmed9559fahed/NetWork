package NetWork.GUI.View.Controls;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrameWindow extends JFrame {

	protected int windowWidth = 500;
	protected int windowHeight = 580;
	
	public FrameWindow() {
		super();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setApplicationIcon();
		this.setResizable(false);
		
		this.setSize(new Dimension(windowWidth, windowHeight));
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
	}

	public void ShowError(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void setApplicationIcon() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Class<? extends JFrame> j = this.getClass();
		Image image = tk.createImage(j.getResource("/images/icon-white.png"));
		this.setIconImage(image);
	}
}
