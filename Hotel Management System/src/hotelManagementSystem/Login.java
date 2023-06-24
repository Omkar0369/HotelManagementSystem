package hotelManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JTextField t1;
	JPasswordField t2;
	JLabel l1,l2,l3;
	JButton b1,b2;
	Login(){
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img2.jpg"));
		JLabel l3=new JLabel(i1);
		l3.setBounds(0, 0, 600, 400);
		add(l3);

		l1=new JLabel("USERNAME: ");
		l1.setBounds(40,30,150,50);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("serif", Font.PLAIN, 25));
		l3.add(l1);

		l2=new JLabel("PASSWORD: ");
		l2.setBounds(40,120,150,50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif", Font.PLAIN, 25));
		l3.add(l2);

		t1=new JTextField();
		t1.setBounds(300,30,200,50);
		l3.add(t1);

		t2=new JPasswordField();
		t2.setBounds(300,120,200,50);
		l3.add(t2);

		b1=new JButton("Login ");
		b1.setBounds(40,230,150,50);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("serif", Font.PLAIN, 20));
		b1.addActionListener(this);
		l3.add(b1);

		b2=new JButton("Cancel ");
		b2.setBounds(340,230,150,50);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("serif", Font.PLAIN, 20));
		b2.addActionListener(this);

		//    	this.addWindowListener (new WindowAdapter() {
		//    		public void windowClosing (WindowEvent e) {
		//    			dispose();
		//    		}
		//    	});

		l3.add(b2);

		setBounds(300,100,600,400);
		setLayout(null);
		setVisible(true);


	}
	public static void main(String[] args) {
		new Login();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {//getSource is for buttons
			String username=t1.getText();
			String password=t2.getText();
			MyConnection c=new MyConnection();
			//creating query
			String str="select * from login where username='"+username+"'"+" and password='"+password+"'";
			//The above syntax cuz we enter values as ('Omkar','12345'); in mysql
			//Now executing the query with help of statement s
			try {
				ResultSet rs=c.s.executeQuery(str);
				//Query is used to compare the result
				//result is stored in resultset interface which is in sql package
				if(rs.next()) {
					//if password matches
					//rs.next jumps from column to column in table
					
					new	Dashboard().setVisible(true);
				
					this.setVisible(false);


				}else {
					//if password doesnt match
					JOptionPane.showMessageDialog(null, "Invalid username or password, Try Again");
					this.setVisible(false);
				}
			}
			catch(SQLException e) {

			}
		}
		else if(ae.getSource()==b2) {
			System.exit(0);
		}

	}
}













