package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import controller.Controler;
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
	private JLabel image4;
	private JLabel image5;
	
	private ImageIcon imageIcon1;
	private ImageIcon imageIcon2;
	private ImageIcon imageIcon3;
	private ImageIcon imageIcon4;
	private ImageIcon imageIcon5;
	
	public PersonalAccount(Controler ctrl){
		this.initComponents();
		this.initGUI();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.white);
		this.mainPanel.setLayout(new GridLayout(1, 5));
		this.imageIcon1 = new ImageIcon("src/images/actual_bid.png");
		this.image1 = new JLabel(imageIcon1);
		this.imageIcon2 = new ImageIcon("src/images/bought_prod.png");
		this.image2 = new JLabel(imageIcon2);
		this.imageIcon3 = new ImageIcon("src/images/sold_prod.png");
		this.image3 = new JLabel(imageIcon3);
		this.imageIcon4 = new ImageIcon("src/images/personal_info.png");
		this.image4 = new JLabel(imageIcon4);
		this.imageIcon5 = new ImageIcon("src/images/exit.png");
		this.image5 = new JLabel(imageIcon5);
	}
	
	private void initGUI() {
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.red);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.white);
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.white);
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.white);
		
		panel1.add(image1);
		this.mainPanel.add(panel1);
		
		panel2.add(image2);
		this.mainPanel.add(panel2);
		
		panel3.add(image3);
		this.mainPanel.add(panel3);
		
		panel4.add(image4);
		this.mainPanel.add(panel4);
		
		panel5.add(image5);
		this.mainPanel.add(panel5);
		this.add(Box.createRigidArea(new Dimension(300, 1)), BorderLayout.WEST);
		this.add(Box.createRigidArea(new Dimension(300, 1)), BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(1,100)), BorderLayout.NORTH);
		this.add(Box.createRigidArea(new Dimension(1,500)), BorderLayout.SOUTH);
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
}
