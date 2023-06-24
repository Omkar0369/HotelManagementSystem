package hotelManagementSystem;
import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	SearchRoom(){
		//		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img11.jpg"));
		//		JLabel l=new JLabel(i);
		//		l.setBounds(450, 0, 400, 250);
		//		add(l);

				
				t1=new JTable();
				t1.setBounds(0, 100, 1000, 200);
				add(t1);
				
	

		b1=new JButton("SUBMIT");
		b1.setBounds(100, 300, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		b2=new JButton("BACK");
		b2.setBounds(400, 300, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);

		JLabel l2=new JLabel("ROOM BED TYPE");
		l2.setBounds(50, 10, 200, 50);
		add(l2);
		
		JLabel l3=new JLabel("ROOM NUMBER");
		l3.setBounds(40, 50, 200, 50);
		add(l3);
		
		JLabel l4=new JLabel("AVAILABLE");
		l4.setBounds(240, 50, 200, 50);
		add(l4);
		
		JLabel l5=new JLabel("CLEAN STATUS");
		l5.setBounds(440, 50, 200, 50);
		add(l5);
		
		JLabel l6=new JLabel("PRICE");
		l6.setBounds(640, 50, 200, 50);
		add(l6);
		
		JLabel l7=new JLabel("BED TYPE");
		l7.setBounds(840, 50, 200, 50);
		add(l7);

		c1=new JComboBox(new String[] {"SINGLE BED","DOUBLE BED"});
		c1.setBounds(200, 10, 150, 20);
		c1.setBackground(Color.white);
		add(c1);
		
		c2=new JCheckBox("ONLY DISPLAY AVAILABLE");
		c2.setBounds(450,10,200,50);
		c2.setBackground(Color.white);
		add(c2);
		
		getContentPane().setBackground(Color.white);

		setTitle("SEARCH FOR ROOM");
		setLayout(null);
		setBounds(200, 20, 1000, 500);
		setVisible(true);
	}


	public static void main(String [] args) {
		new SearchRoom();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				try {
					
					String str="Select * from room where bed_type='"+c1.getSelectedItem()+ "';";
					String str2="select * from room where available='AVAILABLE' AND bed_type='"+c1.getSelectedItem()+ "';";
					
					MyConnection c=new MyConnection();
					ResultSet rs;
					if(c2.isSelected()) {
						rs=c.s.executeQuery(str2);
						t1.setModel(DbUtils.resultSetToTableModel(rs));
					}else {
						rs=c.s.executeQuery(str);
						t1.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}else if(ae.getSource()==b2) {
				new Reception().setVisible(true);
				this.setVisible(false);
			}

	}
}
