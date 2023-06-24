package hotelManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class Room extends JFrame implements ActionListener {
	JTable t1;
	JButton b1,b2;
	Room(){
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img5.jpg"));
		JLabel l=new JLabel(i);
		l.setBounds(500, 20, 500, 500);
		add(l);
	
		
		t1=new JTable();
		t1.setBounds(0, 40, 500, 400);
		add(t1);
		
		b1=new JButton("LOAD DATA");
		b1.setBounds(50, 450, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("CANCEL");
		b2.setBounds(300, 450, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l1=new JLabel("ROOM N0");
		l1.setBounds(5, 0, 100, 50);
		l1.setFont(new Font("serif", Font.BOLD, 15));
		add(l1);
		
		JLabel l2=new JLabel("STATUS");
		l2.setBounds(105, 0, 100, 50);
		l2.setFont(new Font("serif", Font.BOLD, 15));
		add(l2);
		
		JLabel l3=new JLabel("AVAILIBILE");
		l3.setBounds(200, 0, 110, 50);
		l3.setFont(new Font("serif", Font.BOLD, 15));
		add(l3);
		
		JLabel l4=new JLabel("PRICE");
		l4.setBounds(305, 0, 100, 50);
		l4.setFont(new Font("serif", Font.BOLD, 15));
		add(l4);
		
		JLabel l5=new JLabel("TYPE");
		l5.setBounds(405, 0, 100, 50);
		l5.setFont(new Font("serif", Font.BOLD, 15));
		add(l5);
		
		
	
		setTitle("ROOMS INFO");
		setLayout(null);
		setBounds(100, 0, 1000, 600);
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		new Room();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			try {
				MyConnection c=new MyConnection();
				String str="Select * from room;";
				ResultSet rs=c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(SQLException e) {
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

}
