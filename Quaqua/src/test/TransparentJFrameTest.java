/*
 * @(#)TransparentJFrameTest.java
 *
 * Copyright (c) 2003-2013 Werner Randelshofer, Switzerland.
 * All rights reserved.
 *
 * The copyright of this software is owned by Werner Randelshofer.
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * Werner Randelshofer. For details see accompanying license terms.
 */
package test;

import java.awt.*;
import javax.swing.*;

/**
 * Transparent JFrame test.
 *
 * @author Werner Randelshofer
 * @version $Id: TransparentJFrameTest.java 458 2013-05-29 15:44:33Z wrandelshofer $
 */
public class TransparentJFrameTest extends javax.swing.JFrame {
    
    /**
     * Creates new form TransparentJFrameTest
     */
    public TransparentJFrameTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().putClientProperty(
                "apple.awt.draggableWindowBackground", Boolean.FALSE
                );
        setLayout(new FlowLayout());
        
        setBackground(new Color(0x80000000,true));
        //((JComponent) getContentPane()).setOpaque(true);
        //((JComponent) getContentPane()).setBackground(Color.LIGHT_GRAY);
        
        JPanel p = new JPanel() {
            public void paintComponent(Graphics gr) {
                super.paintComponents(gr);
                Graphics2D g = (Graphics2D) gr;
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
                g.setColor(new Color(0,true));
                g.fillOval(0,0,getWidth(),getHeight());
            }
        };
        p.setPreferredSize(new Dimension(60,60));
        getContentPane().add(p);
        setSize(300,300);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransparentJFrameTest().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
