package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataAccessObjectDesingPattern.ItemVO;

public class PersonalAccount extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel mainPanel;
	
	private JLabel image1;
	
	private JLabel image2;

	private JLabel image3;
	
	private ImageIcon imageIcon1;
	private ImageIcon imageIcon2;
	private ImageIcon imageIcon3;
	
	public PersonalAccount(){
		this.initComponents();
		this.initGUI();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(1, 4));
		this.imageIcon1 = new ImageIcon("src/images/imagen2.png");
		this.image1 = new JLabel(imageIcon1);
		this.imageIcon2 = new ImageIcon("src/images/imagen1.jpg");
		this.image2 = new JLabel(imageIcon2);
		this.imageIcon3 = new ImageIcon("src/images/imagen2.png");
		this.image3 = new JLabel(imageIcon3);
	}
	
	private void initGUI() {
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		panel1.add(image1);
		this.mainPanel.add(panel1);
		
		panel2.add(image2);
		this.mainPanel.add(panel2);
		
		panel3.add(image3);
		this.mainPanel.add(panel3);
		
		this.add(this.mainPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("example");
		frame.pack();
		PersonalAccount userVO = new PersonalAccount();
		frame.setPreferredSize(new Dimension(1000, 1000));
		frame.add(userVO);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}
