package hotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener {
	
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c;
	JButton b;
	
	AddEmployee(){
			
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img4.jpg"));	
		JLabel l1=new JLabel(i1);
		l1.setBounds(0, 0, 800, 533);
		add(l1);

		JLabel name=new JLabel("NAME");
		name.setFont(new Font("serif",Font.BOLD,30));
		name.setForeground(Color.WHITE);
		name.setBounds(150, 20, 200, 50);
		l1.add(name);
		
		t1= new JTextField();
		t1.setBounds(300, 20, 400, 40);
		t1.setFont(new Font("serif",Font.BOLD,20));
		l1.add(t1);
		
		JLabel age=new JLabel("AGE");
		age.setFont(new Font("serif",Font.BOLD,30));
		age.setForeground(Color.WHITE);
		age.setBounds(150, 90, 200, 50);
		l1.add(age);
		
		t2= new JTextField();
		t2.setBounds(300, 90, 80, 40);
		t2.setFont(new Font("serif",Font.BOLD,20));
		l1.add(t2);
		
		JLabel gender=new JLabel("GENDER");
		gender.setFont(new Font("serif",Font.BOLD,30));
		gender.setForeground(Color.WHITE);
		gender.setBounds(150,160, 200, 50);
		l1.add(gender);
		
		r1=new JRadioButton("MALE");
		r1.setBounds(300, 160, 70, 30);
		l1.add(r1);
		
		r2=new JRadioButton("FEMALE");
		r2.setBounds(400, 160, 90, 30);
		l1.add(r2);
		
		
		
		JLabel job=new JLabel("JOB");
		job.setFont(new Font("serif",Font.BOLD,30));
		job.setForeground(Color.WHITE);
		job.setBounds(150,230, 200, 50);
		l1.add(job);
		
		
		String str[]= {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
		c=new JComboBox<>(str);
		c.setBounds(300, 230, 200, 50);
		l1.add(c);
		
		JLabel salary=new JLabel("SALARY");
		salary.setFont(new Font("serif",Font.BOLD,30));
		salary.setForeground(Color.WHITE);
		salary.setBounds(150,300, 200, 50);
		l1.add(salary);
		
		t4= new JTextField();
		t4.setBounds(300, 300, 180, 40);
		t4.setFont(new Font("serif",Font.BOLD,20));
		l1.add(t4);
		
		JLabel phone=new JLabel("PHONE");
		phone.setFont(new Font("serif",Font.BOLD,30));
		phone.setForeground(Color.WHITE);
		phone.setBounds(150,360, 200, 50);
		l1.add(phone);
		
		t5= new JTextField();
		t5.setBounds(300, 360, 180, 40);
		t5.setFont(new Font("serif",Font.BOLD,20));
		l1.add(t5);
		
		JLabel email=new JLabel("EMAIL");
		email.setFont(new Font("serif",Font.BOLD,30));
		email.setForeground(Color.WHITE);
		email.setBounds(150,420, 200, 50);
		l1.add(email);
		
		t6= new JTextField();
		t6.setBounds(300, 420, 180, 40);
		t6.setFont(new Font("serif",Font.BOLD,10));
		l1.add(t6);
		
		b=new JButton("SUBMIT");
		b.setBounds(600, 420, 100, 70);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.white);
		l1.add(b);
		b.addActionListener(this);
		
		
		
		setTitle("ADD EMPLOYEE DETAILS");
		setBounds(300,20,800,550);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AddEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String name=t1.getText();
		String age=t2.getText();
		String salary=t4.getText();
		String phone=t5.getText();
		String email=t6.getText();
		String gender =null;
		if(r1.isSelected()) {
			gender="MALE";
		}
		else if(r2.isSelected()) {
			gender="FEMALE";
		}
		String job=(String)c.getSelectedItem();
		//job is typecasted to String cuz it was returning an object
		MyConnection c=new MyConnection();
		String str="insert into employee values('"+name+"','"+age+"',"+"'"+gender+"',"+"'"+job+"',"+"'"+salary+"',"+"'"+phone+"',"+"'"+email+"');";
		try {
			c.s.executeUpdate(str);//For updating the table
			JOptionPane.showMessageDialog(null,"New Employee Added Successfully");
			this.setVisible(false);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		
	}
	
}
