package guiProject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUI implements ActionListener {

	int count = 0;
	JFrame frame;
	JPanel lPanel;
	JPanel createPnl;
	JPanel homePnl;
	JPanel updatePnl;
	JPanel deletePnl;
	JPanel displayPnl;
	JTextField textField;
	
	
   public GUI() {
	   
	    frame = new JFrame();
	   textField =new JTextField(20);
	   textField.addActionListener(this);
	   
	   //sideMenu Buttons
	   JButton button = new JButton("Home");
	   JButton button2 = new JButton("Create");
	   JButton button3 = new JButton("Update");
	   JButton button4 = new JButton("Delete");
	   JButton button5 = new JButton("Display");
	   JButton button6 = new JButton("Exit");
	   JLabel picLabel = new JLabel();
	   //picLabel.setIcon(new ImageIcon("miniCow.jpg"));
	   button.addActionListener(this);
	   button2.addActionListener(this);
	   button3.addActionListener(this);
	   button4.addActionListener(this);
	   button5.addActionListener(this);
	   button6.addActionListener(this);
	   

	   
	   //lPanel sideMenu settings
	   lPanel = new JPanel();
	   lPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	   lPanel.setBackground(Color.GRAY);
	   lPanel.setPreferredSize(new Dimension(150,150));
	   //lPanel.add(picLabel);
	   
	   lPanel.add(button6);
	   frame.add(lPanel, BorderLayout.WEST);
	   
	 
	   
	   //Home Panel
	   homePnl = new JPanel();
	   homePnl.setBackground(Color.BLACK);
	   JLabel homeLbl = new JLabel("CHome");
	   homePnl.add(homeLbl);
	   
	   //Create Panel
	   createPnl = new JPanel();
	   createPnl.setBackground(Color.GREEN);
	   JLabel createLbl = new JLabel("Create");
	   createPnl.add(createLbl);
	   
	   //Update Panel
	   updatePnl = new JPanel();
	   createPnl.setBackground(Color.BLUE);
	   JLabel updateLbl = new JLabel("Update");
	   updatePnl.add(updateLbl);
	   
	  //Delete Panel
	   deletePnl = new JPanel();
	   deletePnl.setBackground(Color.RED);
	   JLabel deleteLbl = new JLabel("Delete");
	   homePnl.add(deleteLbl);
	   
	   //Display Panel
	   displayPnl = new JPanel();
	   displayPnl.setBackground(Color.WHITE);
	   JLabel displayLbl = new JLabel("Display");
	   homePnl.add(displayLbl);
	   
	   //Tabs
	   JTabbedPane tp = new JTabbedPane();
	   tp.add("Home", homePnl);
	   tp.add("Create",createPnl);
	   tp.add("Update",updatePnl);
	   tp.add("Delete",deletePnl);
	   tp.add("Display",displayPnl);
	   frame.add(tp);
	   
	   //frame settings
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setTitle("Hello GUI");
	   frame.setSize(500,500);
	   frame.setVisible(true);
	   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		String text = textField.getText();
//	    textField.selectAll();
//		count++;
//		label.setText(text);
	}
	
	

}
