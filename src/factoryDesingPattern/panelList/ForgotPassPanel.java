package factoryDesingPattern.panelList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import controller.Controler;
import factoryDesingPattern.BasicPanel;
import factoryDesingPattern.panelList.progressBar.javaExample;
import factoryDesingPattern.panelList.progressBar.javaExample.Task;

public class ForgotPassPanel extends BasicPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForgotPassPanel(Dimension dimension, Controler ctrl){
		
	}
	@Override
	public void initComponets() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initGUI() {
		// TODO Auto-generated method stub

	}
	
	private JProgressBar progressBar;
	private JButton startButton;
	private JTextArea taskOutput;
	private Task task;

	class Task extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			Random random = new Random();
			int progress = 0;
			// Initialize progress property.
			setProgress(0);
			// Sleep for at least one second to simulate "startup".
			try {
				Thread.sleep(1000 + random.nextInt(2000));
			} catch (InterruptedException ignore) {
			}
			while (progress < 100) {
				// Sleep for up to one second.
				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException ignore) {
				}
				// Make random progress.
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
			return null;
		}

		/*
		 * Executed in event dispatch thread
		 */
		public void done() {
			Toolkit.getDefaultToolkit().beep();
			startButton.setEnabled(true);
			taskOutput.append("Done!\n");
			taskOutput.append("Yout new password is: " + generatePass());

		}
	}
	
	private String generatePass(){
		StringBuilder chain = new StringBuilder();
		for(int i=0; i< 15; ++i){
			chain.append(Math.random());
		}
		return chain.toString();
	}

	public void javaExample() {
		super.setLayout(new BorderLayout());

		// Create the demo's UI.
		startButton = new JButton("Generate new password");
		startButton.setActionCommand("Generate new password");
		startButton.addActionListener((ActionListener) this);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);

		// Call setStringPainted now so that the progress bar height
		// stays the same whether or not the string is shown.
		progressBar.setStringPainted(true);

		taskOutput = new JTextArea(5, 20);
		taskOutput.setMargin(new Insets(5, 5, 5, 5));
		taskOutput.setEditable(false);

		JPanel panel = new JPanel();
		panel.add(startButton);
		panel.add(progressBar);

		add(panel, BorderLayout.PAGE_START);
		add(new JScrollPane(taskOutput), BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/**
	 * Invoked when the user presses the start button.
	 */
	public void actionPerformed(ActionEvent evt) {
		progressBar.setIndeterminate(true);
		startButton.setEnabled(false);
		// Instances of javax.swing.SwingWorker are not reusuable, so
		// we create new instances as needed.
		task = new Task();
		task.addPropertyChangeListener((PropertyChangeListener) this);
		task.execute();
	}

	/**
	 * Invoked when task's progress property changes.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			progressBar.setIndeterminate(false);
			progressBar.setValue(progress);
			taskOutput.append(String.format("Completed %d%% of task.\n", progress));
		}
	}

	/**
	 * Create the GUI and show it. As with all GUI code, this must run on the
	 * event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new javaExample();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (Exception e) {
			System.err.print("Error at Look And Feel");
		}
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
