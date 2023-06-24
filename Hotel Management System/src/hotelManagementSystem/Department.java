package hotelManagementSystem;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener {
	
	JButton b1,b2;
	JTable t1;
	Department(){
		//		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img11.jpg"));
		//		JLabel l=new JLabel(i);
		//		l.setBounds(450, 0, 400, 250);
		//		add(l);

				
				t1=new JTable();
				t1.setBounds(20, 50, 500, 300);
				add(t1);
				
	

		b1=new JButton("LOAD");
		b1.setBounds(30, 380, 150, 50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);

		b2=new JButton("BACK");
		b2.setBounds(230, 380, 150, 50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);

		JLabel l1=new JLabel("DEPARTMENT");
		l1.setBounds(60, 10, 100, 50);
		add(l1);
		
		JLabel l2=new JLabel("BUDGET");
		l2.setBounds(260, 10, 100, 50);
		add(l2);

	
		getContentPane().setBackground(Color.white);

		setTitle("DEPARTMENT");
		setLayout(null);
		setBounds(200, 20, 500, 500);
		setVisible(true);
	}


	public static void main(String [] args) {
		new Department();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				try {
					
					String str="Select * from department;" ;
					//String str2="select * from room where available='AVAILABLE' AND bed_type='"+c1.getSelectedItem()+ "';";
					
					MyConnection c=new MyConnection();
					ResultSet rs=c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}else if(ae.getSource()==b2) {
				new Reception().setVisible(true);
				this.setVisible(false);
			}

	}
}
