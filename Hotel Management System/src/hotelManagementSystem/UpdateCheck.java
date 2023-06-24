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
public class UpdateCheck extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5;
	Choice c1;
	JButton b1,b2,b3;
	UpdateCheck(){
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img10.jpg"));
		JLabel l=new JLabel(i);
		l.setBounds(0, 0, 512, 650);
		add(l);
	
//		
//		t1=new JTable();
//		t1.setBounds(0, 40, 500, 400);
//		add(t1);
		
		b1=new JButton("CHECK");
		b1.setBounds(100, 400, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		l.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(300, 400, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		l.add(b2);
		
		
		JLabel l1=new JLabel("GUEST ID");
		l1.setBounds(50, 50, 150, 50);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l1);
		
		JLabel l2=new JLabel("ROOM NO");
		l2.setBounds(50, 100, 150, 50);
		l2.setFont(new Font("serif", Font.BOLD, 20));
		l2.setForeground(Color.WHITE);
		l.add(l2);
		
		JLabel l3=new JLabel("NAME");
		l3.setBounds(50, 150, 200, 50);
		l3.setFont(new Font("serif", Font.BOLD, 20));
		l3.setForeground(Color.WHITE);
		l.add(l3);
		
		JLabel l4=new JLabel("CHECK IN");
		l4.setBounds(50, 200, 200, 50);
		l4.setFont(new Font("serif", Font.BOLD, 20));
		l4.setForeground(Color.WHITE);
		l.add(l4);
		
		JLabel l5=new JLabel("AMOUNT PAID");
		l5.setBounds(50, 250, 200, 50);
		l5.setFont(new Font("serif", Font.BOLD, 20));
		l5.setForeground(Color.WHITE);
		l.add(l5);
		
		JLabel l6=new JLabel("PENDING AMOUNT");
		l6.setBounds(50, 300, 200, 50);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("serif", Font.BOLD, 20));
		l.add(l6);
		
		c1=new Choice();
		try {
			MyConnection c=new MyConnection();
			String str="Select * from customer;";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		c1.setBounds(300,50, 150, 120);
		l.add(c1);
		
		t1=new JTextField();
		t1.setBounds(300, 100, 50, 40);
		l.add(t1);
		
		t2=new JTextField();
		t2.setBounds(300, 150, 150, 40);
		l.add(t2);
		
		t3=new JTextField();
		t3.setBounds(300, 200, 150, 40);
		l.add(t3);
		
		t4=new JTextField();
		t4.setBounds(300, 250, 150, 40);
		l.add(t4);
		
		t5=new JTextField();
		t5.setBounds(300, 300, 150, 40);
		l.add(t5);
		

	
	
		setTitle("CHECK STATUS");
		setLayout(null);
		setBounds(400, 0, 512, 650);
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		new UpdateCheck();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			try {
			MyConnection c=new MyConnection();
			String room=null;
			String deposit=null;
			int amountPaid;
			String price=null;
			String id=c1.getSelectedItem();
			String str="select * from customer where number='"+id+"';";
		
			
				ResultSet rs=c.s.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					
					room=rs.getString("room");
					deposit=rs.getString("deposit");
				}
			
				ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+"';");
				while(rs2.next()) {
				price=rs2.getString("price");
				amountPaid=Integer.parseInt(price)-Integer.parseInt(deposit);
				t5.setText(Integer.toString(amountPaid));
				}
				
				
			}catch(Exception e) {
				e.getMessage();
			}
			
			
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

}