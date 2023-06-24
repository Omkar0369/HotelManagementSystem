package hotelManagementSystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AddCustomer extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1;
	Choice c2;
	JRadioButton r1,r2;
	JButton b1,b2;
	
	AddCustomer(){
		ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img8.jpg"));
		JLabel l=new JLabel(i);
		l.setBounds(0,0,600,900);
		add(l);
		
		JLabel id=new JLabel("ID");
		id.setBounds(100, 20, 150, 50);
		id.setForeground(Color.BLACK);
		id.setFont(new Font("serif", Font.BOLD, 30));
		l.add(id);
		
		c1=new JComboBox(new String[] {"PASSPORT","DRIVERS LICSENSE","VOTER ID"});
		c1.setBounds(300, 20, 200, 30);
		l.add(c1);
		
		JLabel number=new JLabel("NUMBER");
		number.setBounds(100, 70, 150, 50);
		number.setForeground(Color.BLACK);
		number.setFont(new Font("serif", Font.BOLD, 30));
		l.add(number);
		
		t1=new JTextField();
		t1.setBounds(300, 70, 150, 30);
		l.add(t1);
		
		JLabel name=new JLabel("NAME");
		name.setBounds(100, 130, 150, 50);
		name.setForeground(Color.BLACK);
		name.setFont(new Font("serif", Font.BOLD, 30));
		l.add(name);
		
		t2=new JTextField();
		t2.setBounds(300, 130, 200, 30);
		l.add(t2);
		
		JLabel gender=new JLabel("GENDER");
		gender.setBounds(100, 180, 150, 50);
		gender.setForeground(Color.BLACK);
		gender.setFont(new Font("serif", Font.BOLD, 30));
		l.add(gender);
		
		r1=new JRadioButton("MALE");
		r1.setBackground(Color.black);
		r1.setForeground(Color.white);
		r1.setBounds(300, 180, 70, 40);
		l.add(r1);
		
		r2=new JRadioButton("FEMALE");
		r2.setBounds(400, 180, 80, 40);
		r2.setBackground(Color.black);
		r2.setForeground(Color.white);
		l.add(r2);
		
		JLabel country=new JLabel("COUNTRY");
		country.setBounds(100, 230, 200, 50);
		country.setForeground(Color.BLACK);
		country.setFont(new Font("serif", Font.BOLD, 30));
		l.add(country);
		
		t3=new JTextField();
		t3.setBounds(300, 240, 200, 30);
		l.add(t3);
		
		JLabel room=new JLabel("ROOM NO");
		room.setBounds(100, 280, 150, 50);
		room.setForeground(Color.BLACK);
		room.setFont(new Font("serif", Font.BOLD, 30));
		l.add(room);
		
		c2=new Choice();//choice box gives dynamic allocation
		try {
			MyConnection c=new MyConnection();
			String str="Select * from room;";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) {
				c2.add(rs.getString("room_number"));
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		c2.setBounds(300, 300, 100, 50);
		l.add(c2);
		
		JLabel status=new JLabel("CHECKED IN");
		status.setBounds(100, 330, 200, 50);
		status.setForeground(Color.BLACK);
		status.setFont(new Font("serif", Font.BOLD, 30));
		l.add(status);
		
		t4=new JTextField();
		t4.setBounds(300, 340, 200, 30);
		l.add(t4);
		
		JLabel deposit=new JLabel("DEPOSIT");
		deposit.setBounds(100, 380, 200, 50);
		deposit.setForeground(Color.BLACK);
		deposit.setFont(new Font("serif", Font.BOLD, 30));
		l.add(deposit);
		
		t5=new JTextField();
		t5.setBounds(300, 390, 200, 30);
		l.add(t5);
		
		b1=new JButton("ADD CUSTOMER");
		b1.setBounds(100, 460, 150, 50);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		l.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("CANCEL");
		b2.setBounds(300, 460, 100, 50);
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		l.add(b2);
		b2.addActionListener(this);
		
			

		setTitle("ADD CUSTOMER");
		setLayout(null);
		setBounds(250, 0, 600, 650);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		String id=(String)c1.getSelectedItem();
		String number=t1.getText();
		String name=t2.getText();
		String gender=null;
		if(r1.isSelected()) {
			gender="MALE";
		}else if(r2.isSelected()) {
			gender="FEMALE";
		}
		String country=t3.getText();
		String room=c2.getSelectedItem();
		String status=t4.getText();
		String deposit=t5.getText();
		
		String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"');";
	
		String str1="update room set available='OCCUPIED' where room_number='"+room+"';";
		try {
			MyConnection c=new MyConnection();
			c.s.executeUpdate(str);
			c.s.executeUpdate(str1);
			JOptionPane.showMessageDialog(null,"NEW CUSTOMER ADDED SUCCESSFULLY");
			new Reception().setVisible(true);
			this.setVisible(false);
		}catch(SQLException e) {
			System.out.println(e);
		}
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
		
	}
	public static void main(String[] args) {
		new AddCustomer();
	}
	
}
