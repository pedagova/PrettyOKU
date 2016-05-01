package factoryDesingPattern.panelList;

import javax.swing.JProgressBar;
import java.awt.*;
import javax.swing.*;

public class ItemRegisterPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JProgressBar current;
	JTextArea out;
	
	JButton find;
	Thread runner;
	int num = 0;

	private JPanel panel = new JPanel();
	private JTextArea text = new JTextArea();
	
	public ItemRegisterPanel() {
		super("Progress");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		current = new JProgressBar(0, 100);
		current.setValue(0);
		current.setStringPainted(true);
		pane.add(current);
		setContentPane(pane);
	}

	public void iterate() {
		while (num < 2000) {
			current.setValue(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			num += Math.random()*25;
			if(this.current.getValue()==100){
				this.text.setText("Process complete, your new pass is: " + "5sd4s31df31fsd21s3");
				this.panel.add(this.text);
				this.panel.setVisible(true);
				this.panel.setPreferredSize(new Dimension(500,500));
				this.add(this.panel);
			}
		}
	}

	public static void main(String[] arguments) {
		ItemRegisterPanel frame = new ItemRegisterPanel();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
	}
}