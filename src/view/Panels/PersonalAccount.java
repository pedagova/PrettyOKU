package view.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controler;

public class PersonalAccount extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;

	private JButton image1;
	private JButton image2;
	private JButton image3;
	private JButton image5;

	private ImageIcon imageIcon1;
	private ImageIcon imageIcon2;
	private ImageIcon imageIcon3;
	private ImageIcon imageIcon5;

	private Controler ctrl;

	public PersonalAccount(Controler ctrl) {
		this.ctrl = ctrl;
		this.initComponents();
		this.initGUI();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.white);

		GridLayout g = new GridLayout(1, 4);
		g.setHgap(40);

		this.mainPanel.setLayout(g);
		this.imageIcon1 = new ImageIcon("src/images/actual_bid.png");
		this.image1 = new JButton(imageIcon1);
		this.image1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.image1.setBackground(null);
		image1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getBidItems();
			}
		});
		this.imageIcon2 = new ImageIcon("src/images/bought_prod.png");
		this.image2 = new JButton(imageIcon2);
		this.image2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.image2.setBackground(null);
		image2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getBoughtProducts();
			}
		});
		this.imageIcon3 = new ImageIcon("src/images/sold_prod.png");
		this.image3 = new JButton(imageIcon3);
		this.image3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.image3.setBackground(null);
		image3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getSellProducts();
			}
		});

		this.imageIcon5 = new ImageIcon("src/images/exit.png");
		this.image5 = new JButton(imageIcon5);
		this.image5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.image5.setBackground(null);
		image5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.loggOut();
				ctrl.getN(20);
			}
		});
	}

	private void initGUI() {
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.white);

		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.white);

		panel1.add(image1);
		this.mainPanel.add(panel1);

		panel2.add(image2);
		this.mainPanel.add(panel2);

		panel3.add(image3);
		this.mainPanel.add(panel3);

		panel5.add(image5);
		this.mainPanel.add(panel5);
		this.add(Box.createRigidArea(new Dimension(100, 1)), BorderLayout.WEST);
		this.add(Box.createRigidArea(new Dimension(100, 1)), BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(1, 100)), BorderLayout.NORTH);
		this.add(Box.createRigidArea(new Dimension(1, 500)), BorderLayout.SOUTH);
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
}
