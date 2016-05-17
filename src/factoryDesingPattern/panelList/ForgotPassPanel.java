package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ForgotPassPanel extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar current;
	private JTextArea out;
	
	private JButton find;
	private Thread runner;
	private int num = 0;

	private JPanel panel = new JPanel();
	private JTextArea text = new JTextArea();
	
	public ForgotPassPanel() {
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
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		ForgotPassPanel frame = new ForgotPassPanel();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
	}
}
