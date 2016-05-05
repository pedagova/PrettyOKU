/*
 * @(#)DesktopPaneTest.java  1.0  13 February 2005
 *
 * Copyright (c) 2004 Werner Randelshofer, Switzerland.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */

package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * DesktopPaneTest.
 *
 * @author  Werner Randelshofer
 * @version 1.0  13 February 2005  Created.
 */
public class DesktopPaneTest extends javax.swing.JPanel {
    
    /** Creates new form. */
    public DesktopPaneTest() {
        initComponents();
        toolFrame.putClientProperty("JInternalFrame.isPalette", true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JSeparator();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JSeparator();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        cutMenuItem14 = new javax.swing.JMenuItem();
        copyMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jSeparator18 = new javax.swing.JSeparator();
        jRadioButtonMenuItem7 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem8 = new javax.swing.JRadioButtonMenuItem();
        jSeparator19 = new javax.swing.JSeparator();
        zoomInMenuItem3 = new javax.swing.JMenuItem();
        zoomOutMenuItem3 = new javax.swing.JMenuItem();
        smallInternalFrame = new javax.swing.JInternalFrame();
        windowModifiedCheckBox = new javax.swing.JCheckBox();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JSeparator();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JSeparator();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        cutMenuItem15 = new javax.swing.JMenuItem();
        copyMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jSeparator22 = new javax.swing.JSeparator();
        jRadioButtonMenuItem9 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem10 = new javax.swing.JRadioButtonMenuItem();
        jSeparator23 = new javax.swing.JSeparator();
        zoomInMenuItem4 = new javax.swing.JMenuItem();
        zoomOutMenuItem4 = new javax.swing.JMenuItem();
        toolFrame = new javax.swing.JInternalFrame();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        setLayout(new java.awt.BorderLayout());

        jInternalFrame4.setIconifiable(true);
        jInternalFrame4.setMaximizable(true);
        jInternalFrame4.setResizable(true);
        jInternalFrame4.setTitle("Internal Frame");
        jInternalFrame4.setVisible(true);

        jMenu13.setText("File");

        jMenuItem37.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_MASK));
        jMenuItem37.setText("New");
        jMenuItem37.addActionListener(formListener);
        jMenu13.add(jMenuItem37);

        jMenuItem38.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
        jMenuItem38.setText("Open...");
        jMenuItem38.addActionListener(formListener);
        jMenu13.add(jMenuItem38);

        jMenu14.setText("Open Recent Document");

        jMenuItem39.setText("File1.txt");
        jMenuItem39.addActionListener(formListener);
        jMenu14.add(jMenuItem39);

        jMenuItem40.setText("File2.txt");
        jMenuItem40.addActionListener(formListener);
        jMenu14.add(jMenuItem40);

        jMenu13.add(jMenu14);
        jMenu13.add(jSeparator16);

        jMenuItem41.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.META_MASK));
        jMenuItem41.setText("Close");
        jMenuItem41.addActionListener(formListener);
        jMenu13.add(jMenuItem41);

        jMenuItem42.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
        jMenuItem42.setText("Save");
        jMenuItem42.addActionListener(formListener);
        jMenu13.add(jMenuItem42);

        jMenuItem43.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK|InputEvent.SHIFT_MASK));
        jMenuItem43.setText("Save As...");
        jMenuItem43.addActionListener(formListener);
        jMenu13.add(jMenuItem43);

        jMenuItem44.setText("Revert to Saved");
        jMenuItem44.addActionListener(formListener);
        jMenu13.add(jMenuItem44);
        jMenu13.add(jSeparator17);

        jMenuItem45.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.META_MASK|InputEvent.SHIFT_MASK));
        jMenuItem45.setText("Page Setup...");
        jMenuItem45.addActionListener(formListener);
        jMenu13.add(jMenuItem45);

        jMenuItem46.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.META_MASK));
        jMenuItem46.setText("Print...");
        jMenuItem46.addActionListener(formListener);
        jMenu13.add(jMenuItem46);

        jMenuBar4.add(jMenu13);

        jMenu15.setText("Edit");

        cutMenuItem14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    cutMenuItem14.setText("Cut");
    jMenu15.add(cutMenuItem14);

    copyMenuItem15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_MASK));
    copyMenuItem15.setText("Copy");
    jMenu15.add(copyMenuItem15);

    jMenuItem47.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_MASK));
    jMenuItem47.setText("Paste");
    jMenu15.add(jMenuItem47);

    jMenuItem48.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
    jMenuItem48.setText("Delete");
    jMenu15.add(jMenuItem48);

    jMenuBar4.add(jMenu15);

    jMenu16.setText("View");

    jCheckBoxMenuItem4.setSelected(true);
    jCheckBoxMenuItem4.setText("Ångström H");
    jMenu16.add(jCheckBoxMenuItem4);
    jMenu16.add(jSeparator18);

    jRadioButtonMenuItem7.setText("Dock at Right");
    jMenu16.add(jRadioButtonMenuItem7);

    jRadioButtonMenuItem8.setSelected(true);
    jRadioButtonMenuItem8.setText("Ångström H");
    jMenu16.add(jRadioButtonMenuItem8);
    jMenu16.add(jSeparator19);

    zoomInMenuItem3.setText("Ångström H");
    jMenu16.add(zoomInMenuItem3);

    zoomOutMenuItem3.setText("Zoom Out");
    jMenu16.add(zoomOutMenuItem3);

    jMenuBar4.add(jMenu16);

    jInternalFrame4.setJMenuBar(jMenuBar4);

    jInternalFrame4.setBounds(40, 30, 170, 170);
    jDesktopPane1.add(jInternalFrame4, javax.swing.JLayeredPane.DEFAULT_LAYER);

    smallInternalFrame.setClosable(true);
    smallInternalFrame.setIconifiable(true);
    smallInternalFrame.setMaximizable(true);
    smallInternalFrame.setResizable(true);
    smallInternalFrame.setTitle("Small Size");
    smallInternalFrame.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    smallInternalFrame.setVisible(true);

    windowModifiedCheckBox.setText("Window Modified");
    windowModifiedCheckBox.addItemListener(formListener);
    smallInternalFrame.getContentPane().add(windowModifiedCheckBox, java.awt.BorderLayout.CENTER);

    jMenuBar5.setFont(new java.awt.Font("Lucida Grande", 0, 11));

    jMenu17.setText("File");
    jMenu17.setFont(new java.awt.Font("Lucida Grande", 0, 11));

    jMenuItem49.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_MASK));
    jMenuItem49.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem49.setText("New");
    jMenu17.add(jMenuItem49);

    jMenuItem50.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
    jMenuItem50.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem50.setText("Open...");
    jMenu17.add(jMenuItem50);

    jMenu18.setText("Open Recent");
    jMenu18.setFont(new java.awt.Font("Lucida Grande", 0, 11));

    jMenuItem51.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem51.setText("File1.txt");
    jMenu18.add(jMenuItem51);

    jMenuItem52.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem52.setText("File2.txt");
    jMenu18.add(jMenuItem52);

    jMenu17.add(jMenu18);
    jMenu17.add(jSeparator20);

    jMenuItem53.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.META_MASK));
    jMenuItem53.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem53.setText("Close");
    jMenu17.add(jMenuItem53);

    jMenuItem54.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
    jMenuItem54.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem54.setText("Save");
    jMenu17.add(jMenuItem54);

    jMenuItem55.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK|InputEvent.SHIFT_MASK));
    jMenuItem55.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem55.setText("Save As...");
    jMenu17.add(jMenuItem55);

    jMenuItem56.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem56.setText("Revert to Saved");
    jMenu17.add(jMenuItem56);
    jMenu17.add(jSeparator21);

    jMenuItem57.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.META_MASK|InputEvent.SHIFT_MASK));
    jMenuItem57.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem57.setText("Page Setup...");
    jMenu17.add(jMenuItem57);

    jMenuItem58.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.META_MASK));
    jMenuItem58.setFont(new java.awt.Font("Lucida Grande", 0, 11));
    jMenuItem58.setText("Print...");
    jMenu17.add(jMenuItem58);

    jMenuBar5.add(jMenu17);

    jMenu19.setText("Edit");
    jMenu19.setFont(new java.awt.Font("Lucida Grande", 0, 11));

    cutMenuItem15.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
cutMenuItem15.setFont(new java.awt.Font("Lucida Grande", 0, 11));
cutMenuItem15.setText("Cut");
jMenu19.add(cutMenuItem15);

copyMenuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_MASK));
copyMenuItem16.setFont(new java.awt.Font("Lucida Grande", 0, 11));
copyMenuItem16.setText("Copy");
jMenu19.add(copyMenuItem16);

jMenuItem59.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_MASK));
jMenuItem59.setFont(new java.awt.Font("Lucida Grande", 0, 11));
jMenuItem59.setText("Paste");
jMenu19.add(jMenuItem59);

jMenuItem60.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
jMenuItem60.setFont(new java.awt.Font("Lucida Grande", 0, 11));
jMenuItem60.setText("Delete");
jMenu19.add(jMenuItem60);

jMenuBar5.add(jMenu19);

jMenu20.setText("View");
jMenu20.setFont(new java.awt.Font("Lucida Grande", 0, 11));

jCheckBoxMenuItem5.setFont(new java.awt.Font("Lucida Grande", 0, 11));
jCheckBoxMenuItem5.setSelected(true);
jCheckBoxMenuItem5.setText("Show Toolbar");
jMenu20.add(jCheckBoxMenuItem5);
jMenu20.add(jSeparator22);

jRadioButtonMenuItem9.setFont(new java.awt.Font("Lucida Grande", 0, 11));
jRadioButtonMenuItem9.setText("Dock at Right");
jMenu20.add(jRadioButtonMenuItem9);

jRadioButtonMenuItem10.setFont(new java.awt.Font("Lucida Grande", 0, 11));
jRadioButtonMenuItem10.setSelected(true);
jRadioButtonMenuItem10.setText("Dock at Bottom");
jMenu20.add(jRadioButtonMenuItem10);
jMenu20.add(jSeparator23);

zoomInMenuItem4.setFont(new java.awt.Font("Lucida Grande", 0, 11));
zoomInMenuItem4.setText("Zoom In");
jMenu20.add(zoomInMenuItem4);

zoomOutMenuItem4.setFont(new java.awt.Font("Lucida Grande", 0, 11));
zoomOutMenuItem4.setText("Zoom Out");
jMenu20.add(zoomOutMenuItem4);

jMenuBar5.add(jMenu20);

smallInternalFrame.setJMenuBar(jMenuBar5);

smallInternalFrame.setBounds(200, 180, 180, 170);
jDesktopPane1.add(smallInternalFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);

toolFrame.setIconifiable(true);
toolFrame.setMaximizable(true);
toolFrame.setResizable(true);
toolFrame.setNormalBounds(new java.awt.Rectangle(240, 50, 120, 120));
toolFrame.setVisible(true);
toolFrame.getContentPane().setLayout(new javax.swing.BoxLayout(toolFrame.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

jCheckBox1.setText("jCheckBox1");
toolFrame.getContentPane().add(jCheckBox1);

jCheckBox2.setText("jCheckBox2");
toolFrame.getContentPane().add(jCheckBox2);

toolFrame.setBounds(240, 50, 120, 90);
jDesktopPane1.add(toolFrame, javax.swing.JLayeredPane.DEFAULT_LAYER);

add(jDesktopPane1, java.awt.BorderLayout.CENTER);
}

// Code for dispatching events from components to event handlers.

private class FormListener implements java.awt.event.ActionListener, java.awt.event.ItemListener {
    FormListener() {}
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jMenuItem37) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem38) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem39) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem40) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem41) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem42) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem43) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem44) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem45) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
        else if (evt.getSource() == jMenuItem46) {
            DesktopPaneTest.this.menuPerformed(evt);
        }
    }

    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getSource() == windowModifiedCheckBox) {
            DesktopPaneTest.this.windowModifiedChanged(evt);
        }
    }
    }// </editor-fold>//GEN-END:initComponents

    private void menuPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPerformed
System.out.println("Menu Performed "+evt);
    }//GEN-LAST:event_menuPerformed

    private void windowModifiedChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_windowModifiedChanged
        smallInternalFrame.putClientProperty("windowModified", evt.getStateChange() == ItemEvent.SELECTED);
    }//GEN-LAST:event_windowModifiedChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem15;
    private javax.swing.JMenuItem copyMenuItem16;
    private javax.swing.JMenuItem cutMenuItem14;
    private javax.swing.JMenuItem cutMenuItem15;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem10;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem9;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JInternalFrame smallInternalFrame;
    private javax.swing.JInternalFrame toolFrame;
    private javax.swing.JCheckBox windowModifiedCheckBox;
    private javax.swing.JMenuItem zoomInMenuItem3;
    private javax.swing.JMenuItem zoomInMenuItem4;
    private javax.swing.JMenuItem zoomOutMenuItem3;
    private javax.swing.JMenuItem zoomOutMenuItem4;
    // End of variables declaration//GEN-END:variables
    
}
