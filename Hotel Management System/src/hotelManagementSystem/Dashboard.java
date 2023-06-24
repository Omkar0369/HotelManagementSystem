package hotelManagementSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
public class Dashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	Dashboard(){
		mb=new JMenuBar();
		mb.setBounds(0,0,1950,30);
		//mb.setForeground(Color.WHITE);
		mb.setBackground(Color.BLACK);
		add(mb);
		
		m1=new JMenu("HOTEL MANAGEMENT");
		m1.setForeground(Color.WHITE);
		mb.add(m1);
		
		m2=new JMenu("ADMIN");
		m2.setForeground(Color.WHITE);
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2=new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);

		m2.add(i2);
		
		i3=new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);

		m2.add(i3);
		
		i4=new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);

		m2.add(i4);
		
		ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img3.jpg"));
		
		Image m=i.getImage().getScaledInstance(1900,800, Image.SCALE_DEFAULT);
		//For adjusting the size of image
		ImageIcon n=new ImageIcon(m);
		
		
		JLabel l1=new JLabel(n);//Label is required to display the icon
		l1.setBounds(0, 0, 1900,800);
		add(l1);
		
		JLabel l2=new JLabel("Welcome to Hotel Continental");
		l2.setForeground(Color.BLACK);
		l2.setBounds(450,50,1900,50);
		l2.setFont(new Font("serif", Font.CENTER_BASELINE, 30));
		l1.add(l2);
		
		
		
		
		setBounds(0,0,1950,800);
		setLayout(null);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Dashboard();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("RECEPTION")) {//getActionCommand is for selecting menu items
			new Reception().setVisible(true);
		}else if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee().setVisible(true);
		}else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver().setVisible(true);
		}
			
		
		
		
	}
}
