package com.file_io.core;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/** 
 * 
 *	Name: Benjamin DosSantos 
 *	Assignment: Search Table
 *	Project Description: The Program
 *  is intended to create a JFrame 
 *  that has a 2D Array. The program
 *  then allows for the user to search 
 *  for a value or a string of text to 
 *  see if it is contained in the 2D Array.
 **/

public class TableExample extends JFrame
{
    public TableExample()
    {
    	this.setLayout(new FlowLayout());
    	this.setSize(500, 800);
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        //headers for the table
        String[] columns = new String[] {"Id", "Name"};
         
        //actual data for the table in a 2d array
        final String[][] data = new String[][] {
            {"1", "John"},
            {"2", "Rambo"},
            {"3", "Zorro"},
        };
        
        //create table model with data
        DefaultTableModel model = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        };
         
        JTable table = new JTable(model);
        this.add(new JScrollPane(table));

        JLabel  searchlabel= new JLabel("Search: ", JLabel.RIGHT);
        final JLabel  found = new JLabel("", JLabel.CENTER);
        final JTextField searchText = new JTextField(6);

        JButton searchButton = new JButton("SEARCH");
        searchButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {    
        	   //call a method that tells us if the text exists
        	   //change the text to the label found
        	   boolean isFound = checkValue(data, searchText.getText());
        	   found.setText(isFound + "");
           }
        }); //end of action listener

        this.add(searchlabel);
        this.add(searchText);
        this.add(searchButton);
        this.add(found);        
        this.setVisible(true);
    }//end of TableExanmple()
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableExample();
            }//end of run
        });
    }//end of main    
    
    public static boolean checkValue(String[][] data, String searchText){
		int count_array_1 = 0,
			count_array_2 = 0;
    	
		boolean isFound = false;
		
    	for(String[] array_1: data){
			for(String array_2: array_1){
				if(data[count_array_1][count_array_2].equalsIgnoreCase(searchText)){
					return true;
				}
				count_array_2++;
			}
			count_array_2 = 0;
			count_array_1++;
		}
		return isFound;
    }// End of checkIntValue
}//end of class
