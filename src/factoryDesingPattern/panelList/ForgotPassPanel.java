package factoryDesingPattern.panelList;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import dataAccessObjectDesingPattern.Dao;
import model.AppObserver;

public class ForgotPassPanel extends JFrame implements AppObserver
{

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
		ForgotPassPanel frame = new ForgotPassPanel();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
	}

	@Override
	public void onAppStart() {
		return;		
	}

	@Override
	public void opAppEnd() {
		return;
		
	}

	@Override
	public void onUserLogIn() {
		return;
		
	}

	@Override
	public void onUserLogOut() {
		return;
		
	}

	@Override
	public void onBddUpdate(String comand, Dao act) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        handleOnBddUpdate(comand, act);
		    }
		});
	}
	
	void handleOnBddUpdate(String comand, Dao act){
		
	}
	
	@Override
	public void onBddRequest(String comand, String id) {
				
	}
}
