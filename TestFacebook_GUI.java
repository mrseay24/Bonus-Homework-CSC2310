import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BoxView;

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFacebook_GUI {
	  
	   String blank1 = "                             ";
       // Create a vector that can store String objects
       Vector vName = new Vector<String>();
       String sMood[] = new String[100];
       int iMood = 0;
       int iSelected = 0;       
       // Create a JFrame
       JFrame jFrame1;
       // Create a JList that is capable of storing String type items
       JList list = new JList(vName);
       // Create a JButton for Add Name and Change Mood
	   JButton jButton1, jButton2;
       // Create a JPanel for Name List, Add Name, Change Mood
	   JPanel jPanel1, jPanel2, jPanel3, jPanel4;
       // Create a JLabel Name. New Mood
	   JLabel jLabel1, jLabel2, jLabel3, jLabel4;
       // Create a JText Name, Mood
	   JTextArea jText1, jText2, jText3;
	   JTextField jField1, jField2;

    public TestFacebook_GUI() {
        // initialize string array
    	for (int i = 0; i < 100; i++)
    	{
    		sMood[1] = "";
    	}
    	facebook_GUI();
    }
	public void facebook_GUI() {
		jFrame1 = new JFrame("Facebook_GUI");
		jFrame1.setSize(600, 400);
		
		jLabel1 = new JLabel("Name:");
		jLabel2 = new JLabel("New Mood:");
		jLabel3 = new JLabel(blank1);
		jLabel4 = new JLabel(blank1);		
		
		jText1 = new JTextArea(blank1);
		jText1.setEditable(false);
		jText2 = new JTextArea(blank1);
		jText2.setEditable(false);
		jText3 = new JTextArea();
		jText3.setEditable(false);		
		
		jField1 = new JTextField();
		jField1.setEditable(true);		
		jField2 = new JTextField();
		jField2.setEditable(true);
		
		jButton1 = new JButton("Add Person");
		jButton2 = new JButton("Change Mood");		
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jPanel3 = new JPanel();
		jPanel4 = new JPanel();		

        // default Mood
		jText3.setText("default_mood");
		jPanel4.setBackground(Color.LIGHT_GRAY);    				
		
		list.setSelectedIndex(0);
	    list.setPreferredSize(new Dimension(150,200));
		list.setVisible(true);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // select Name from List and display mood
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					iSelected = list.getSelectedIndex();
	                if (sMood[iSelected].toString().equalsIgnoreCase("happy"))
	                {
	    				jText3.setText("happy");
	    				jPanel4.setBackground(Color.RED);
	                }
	                else
	                {
	    				jText3.setText("default_mood");
	    				jPanel4.setBackground(Color.LIGHT_GRAY);
	                }					
			}
		 }
		);
		// Add Button
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if (vName.contains(jField1.getText()))
                {
                	// name already exist in Vector and List
                }
                else
                {
   				  // Add what the user types in JTextField jf, to the vector
                  vName.add(jField1.getText());                	
  				  // Now set the updated vector to JList and mood
  				  list.setListData(vName);
  				  sMood[iMood] = "default_mood";
  				  iMood++;
                }
			}
		 }
		);
        // New Mood Button
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if (jField2.getText().equalsIgnoreCase("happy"))
                {
    				jText3.setText("happy");
    				jPanel4.setBackground(Color.RED);
    				sMood[iSelected] = "happy";
                }
                else
                {
    				jText3.setText("default_mood");
    				jPanel4.setBackground(Color.LIGHT_GRAY);
    				sMood[iSelected] = "default_mood";    				
                }

			}
		 }
		);

		jPanel1.setLayout(new BorderLayout());		
		jPanel1.add(list);
		
		jPanel2.setLayout(new BoxLayout(jPanel2, 0));		
		jPanel2.add(jLabel3);
		jPanel2.add(jLabel1);
		jPanel2.add(jField1);		
		jPanel2.add(jButton1);
		jPanel2.add(jText1);		
		
		jPanel3.setLayout(new BoxLayout(jPanel3, 0));		
		jPanel3.add(jLabel4);
		jPanel3.add(jLabel2);
		jPanel3.add(jField2);		
		jPanel3.add(jButton2);
		jPanel3.add(jText2);

        jPanel4.setPreferredSize(new Dimension(150,200));
		jPanel4.add(jText3);

		jFrame1.getContentPane().add(jPanel1, BorderLayout.WEST);
		jFrame1.getContentPane().add(jPanel2, BorderLayout.NORTH);
		jFrame1.getContentPane().add(jPanel3, BorderLayout.SOUTH);
		jFrame1.getContentPane().add(jPanel4, BorderLayout.CENTER);
		
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
        jFrame1.setVisible(true);
        
	}
	public static void main (String[] args){

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception ex)  {
			
		}
		TestFacebook_GUI facebook_GUI = new TestFacebook_GUI();
		
   }
 }