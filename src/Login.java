//javac -cp ".;c:\*" Login.java

/*create table mylogin
(
login_name varchar(50) not null,
password varchar(10) not null,

select * from mylogin;
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import java.text.*;  
import java.util.Date;
import java.text.SimpleDateFormat;

class Login extends JFrame implements ActionListener
{
	Connection conn;
	Statement s;
	ResultSet rs;
	JLabel l1,l2,l3;
    JTextField t1,t2,date;
 JPanel p0,p1;   
    JButton b1,b2;
	JMenuBar mbr;
	JMenu m1;
	JMenuItem mi1,mi2,mi3;
    int cnt=3;

	 ImageIcon i;
   JLabel l;
	Font fnt;
	
	Login()
    {   
		
       setSize(600,400);
		setTitle("Login Page");
		setLocation(400,200);
		setLayout(null);
		setVisible(true);
	//getContentPane().setBackground(Color.pink);
			fnt = new Font("Lucida Calligraphy", Font.BOLD, 28);	
	  i=new ImageIcon("index.JPEG");
    l=new JLabel(i);
//	l3.setFont("Lucida Calligraphy", Font.BOLD, 28);


	p0 = new JPanel();
		p0.setLayout(null);
	//	p0.setBackground(Color.pink);
		p0.setBounds(50,0,800,40);
	/*
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.GRAY);
		p1.setBounds(10,110,454,362);
	
	*/
	
/*	dt = new JLabel("Local Time:");
	dt.setFont(new Font("Serif",Font.BOLD,15));*/
		date = new JTextField();/*date.setBackground(Color.GRAY);date.setBorder(new LineBorder(Color.GRAY));	*/
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		date.setText(sdf.format(d));



		
		mbr = new JMenuBar();
		m1 = new JMenu("Menu");
		mi1= new JMenuItem("ChangePassword");
		mi2= new JMenuItem("PasswordRecovery");
		mi3= new JMenuItem("New User");


        l1 = new JLabel("Login name ");
        l2 = new JLabel("Password ");
		l3 = new JLabel("Welcome");
		l3.setFont(new Font("ALGERIAN",Font.BOLD,30));
l2.setFont(new Font("red",Font.BOLD,25));
l1.setFont(new Font("red",Font.BOLD,25));


  

	
	
		l3.setForeground(Color.green);
	
	
		
		
        t1 = new JTextField();
        t2 = new JPasswordField();

        b1 = new JButton("Login");
        b2 = new JButton("Sing-Up");

		/*add(mbr);
		mbr.add(m1);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);*/
		
		
        add(l1);    add(l2); 	add(l3);
		add(t1);
        add(t2);  add(b1);     add(b2);
		
		add(p0);    //p0.add(dt); 
		p0.add(date);
		
		   
   add(l);
   
   
   l.setBounds(300,40,300,150);
  
		//dt.setBounds(500,10,700,20);
		date.setBounds(300,0,100,20);
		

		mbr.setBounds(0,5,40,20);
		m1.setBounds(2,5,40,20);
        l1.setBounds(20,60,150,30);
        l3.setBounds(100,10,200,40);

		
        t1.setBounds(170,70,120,25);

        l2.setBounds(20,110,150,30);
        t2.setBounds(170,110,120,25);

        b1.setBounds(60,170,80,20);
        b2.setBounds(180,170,80,20);

        b1.setMnemonic('L');
        b2.setMnemonic('X');

        b1.addActionListener(this);
        b2.addActionListener(this);

		mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
		
 
  try
			{	
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cal_login","root","");
			s = conn.createStatement();
			}
		
				catch(Exception e)
				{
					e.printStackTrace();
				}

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 
 public void actionPerformed(ActionEvent ae)
 {	
		int cnt=0;
		int f=0;
	
		if(ae.getSource()==b1)
        { 
	
			String s1,s2;
			s1=t1.getText();
			s2=t2.getText();
			
			try
			{
					rs = s.executeQuery("select * from mylogin where login_name='"+s1+"' and  password = '"+s2+"'");
					rs.next();
					rs.getString(1);
					JOptionPane.showMessageDialog(null,"*****Login Successfull ***");
					new MyCalculator(s2);
					//new Nuser();
					dispose();
			
			}
			catch(Exception el)
			{
				JOptionPane.showMessageDialog(null,"Please Try Again !!!","Invalid Password!!!",JOptionPane.ERROR_MESSAGE);
			}
			t1.setText("");
			t2.setText("");
			t1.requestFocus();
		}
   if(ae.getSource()==b2)
   {
    // System.exit(0);
	new Nuser();
	dispose();
   }

   
  if(ae.getSource()==mi1)
   {
		 new ChangePassword();
   }
  
  
  if(ae.getSource()==mi2)
  {
			new PasswordRecovery();
  
  }
  
  if(ae.getSource()==mi3)
  {
			new Nuser();
  
  }
  
  
  
 }
  
  
  public static void main(String args[])
  {
   new Login();
  } 
}