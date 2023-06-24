package hotelManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
	
	
	HotelManagementSystem(){
		
		setBounds(250,50, 600, 600);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelManagementSystem/Icons/img1.jpg"));
		JLabel l1=new JLabel(i1);
		l1.setBounds(0, 0, 600, 600);
		add(l1);
		JLabel l2=new JLabel("Hotel Management System");
		l2.setBounds(20,20,400,100);
		l2.setFont(new Font("serif", Font.PLAIN, 30));
		l2.setForeground(Color.WHITE);
		l1.add(l2);
		JButton b1=new JButton("NEXT");
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.BLACK);
		b1.setBounds(450,20,100,50);
		b1.addActionListener(this);
		l1.add(b1);
		setLayout(null);
		setVisible(true);
		
		while(true)
		{
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
			}
		}
	}
	public static void main(String[] args) {
		new HotelManagementSystem();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Login().setVisible(true);
		this.setVisible(false);
		
		
	}
}