import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
import java.text.*;

class home1 extends JFrame implements ActionListener
{
	Connection cn;
	Statement stm;
	ResultSet rs;
	PreparedStatement prstm;
	String sql;
    int flg=0; 
	DateButton db1;
	JMenuBar mb;
	ImageIcon i1;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem mi1,mi2,mi4,mi5,mi7,mi6,mi3,mi8;
	JLabel l1,l2,l3,l4,l5,l6,l8,l7,l9,l10,l11,l;
	
	JTable tab;
    DefaultTableModel mdl;
	JScrollPane jsp;    int i=0;
 
	
	int r_cnt=0;
	
		Font fnt;
		JButton b1,b2,b3,b4,b5,b6,b7,b9,b10;
		JTextField t2,t3,t4;
		JComboBox cb1,cb2,cb3,cb4,cb5;
		
	home1()
	{
		super("HOME");
	
		

		setSize(1000,800);
		setLayout(null);
		setLocation(100,10);
		
		
		
		 i1=new ImageIcon(getClass().getResource("123.jpg"));
			l=new JLabel(i1);
			add(l);
		  l.setBounds(0,0,1000,700);
		db1 = new DateButton();
	
		mi1=new JMenuItem("Add NewsPaper");
		mi2=new JMenuItem("BACK");
		mi4=new JMenuItem("Generate bill");
		mi6=new JMenuItem("Change Password");
		mi3=new JMenuItem("Customer Details");
		mi7=new JMenuItem("Add Section");
		mi5=new JMenuItem("Add User");
		mi8=new JMenuItem("Bill_report");
		
		m1=new JMenu("Administrator");
		m2=new JMenu("Bill ");
		m3=new JMenu("Report");
		m4=new JMenu("Add NewsPaper");
		m5=new JMenu("Details");
		
		mb=new JMenuBar();
		
	//	b1 = new JButton("BACK");
		
		
		l1 = new JLabel("*** Welcome ***");
		l1.setFont(new Font("Serif",Font.BOLD,40));	
		getContentPane().setBackground(Color.pink);

		add(l1);
		//m1.add(mi1);
		//m1.add(mi6);
		m1.addSeparator();	
		m2.add(mi4);
		m4.add(mi1);
		m5.add(mi3);
		m3.add(mi8);
		
		mb.add(m1);		mb.add(m5);		mb.add(m4); 	    mb.add(m2);		//	m1.add(mi5);
		m3.addSeparator();
		mb.add(m3);		add(db1);		
		
		setJMenuBar(mb);
		
		m1.add(mi2);
		
		
		l1.setBounds(300,100,500,50);
	//	b1.setBounds(500,100,200,30);
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi8.addActionListener(this);
	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mi1)
		{
			//Newspaper f=new Newspaper();
			dispose();
		}
		if(e.getSource()==mi2)
		{
			Login f=new Login();
			dispose();
		}
		
		
		if(e.getSource()==mi3)
		{
			//cust_details f=new cust_details();
			dispose();
		}
		
		if(e.getSource()==mi6)
		{
			ChangePassword f=new ChangePassword();
			dispose();
		}
		
		
		
		if(e.getSource()==mi4)
		{
			//Bill1 f=new Bill1();
			dispose();
		}
		if(e.getSource()==mi7)
		{
			//Section f=new Section();
		}
		if(e.getSource()==mi5)
		{
			Nuser n= new Nuser();
			dispose();
		}
		
		if(e.getSource()==mi8)
		{
		//	Bill_report f=new Bill_report();
			dispose();
		}
		
		
	}
	
		
	public static void main(String args[])
	{
		new home1();
	}
}