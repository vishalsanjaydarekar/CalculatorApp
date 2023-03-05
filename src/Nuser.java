import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Nuser extends JFrame implements ActionListener
  {
	
     JButton b1,b2,b3;
     JTextField t_u,tno,tadd,ta;
     JComboBox cb;
     JPasswordField t_p;
     JLabel l_u,l_p,lno,ladd,l,lq,la,ltitle;
     ImageIcon i;
     Font f;
     Connection cn = null;
     Statement stm=null;
     ResultSet rs;
     String login_name,password;
    
     PreparedStatement prstm;
     String sql;
     Nuser()
       {
            super("New user");
            setSize(700,400);
            setLocation(250,260);
            setLayout(null);
         
            f=new Font("Arial",Font.BOLD,25);
              ltitle=new JLabel("Sign Up");
             ltitle.setFont(f);            

            i=new ImageIcon("new.jpg");
            l=new JLabel(i);
	    b1=new JButton("Save");
	    b2=new JButton("Back");
            b3=new JButton("Exit");
            
            lq=new JLabel("Gender");    lq.setForeground(Color.BLACK);
            la=new JLabel("Email");
            cb=new JComboBox();
            ta=new JTextField();
	    l_u=new JLabel("New User");
	    l_p=new JLabel("New pass");
            lno=new JLabel("Contact Number");
	     ladd=new JLabel("Address");
	    t_u=new JTextField();
	    t_p=new JPasswordField();
	    tno=new JTextField();
	    tadd=new JTextField();
	
                                add(ltitle);
				add(b1);
				add(b2);
				add(b3);
                               
                                add(lq);
                                add(la);
				add(l_u);
				add(l_p);
				add(lno);
                               // add(ladd);
                                add(ta);
                                add(cb);
                                cb.addItem("Select Gender");
                                cb.addItem("Male");
                                cb.addItem("Female");
                                cb.addItem("Other");
				
				add(t_u);
				add(t_p);
				add(tno);
		     	        //add(tadd);
                                 add(l);

                           ltitle.setBounds(0,30,500,30);
                         l.setBounds(0,90,700,400);
			l_u.setBounds(50,80,100,30);
                        t_u.setBounds(160,80,160,30);

			l_p.setBounds(50,120,100,30);
                        t_p.setBounds(160,120,160,30);

			// ladd.setBounds(50,160,100,30);
                        // tadd.setBounds(160,160,160,30);
                        la.setBounds(50,160,100,30);
                        ta.setBounds(160,160,160,30);

                        lq.setBounds(50,200,140,30);
                        cb.setBounds(160,200,160,30);

			lno.setBounds(50,240,140,30);
                        tno.setBounds(160,240,160,30);

                        
                        
                        
			
			
			
	                
                        
		
			b1.setBounds(50,300,100,30);
			b2.setBounds(160,300,100,30);
			b3.setBounds(270,300,100,30); 
             
                    b1.setMnemonic('S');
	                b2.setMnemonic('B');
	                b3.setMnemonic('E');



			b1.addActionListener(this);
			b3.addActionListener(this);
                        b2.addActionListener(this);
                        text_validator(tno);
			try
	{
	  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cal_login","root","");
	  stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=stm.executeQuery("select * from mylogin");
	
	  }
	catch(Exception ec)
	{
	ec.printStackTrace();
	}
                        setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
void text_validator(final JTextField tt)
{
   tt.addKeyListener(new KeyAdapter()
   {
    public void keyTyped(KeyEvent e)
	 {
	  if(tt.getText().length()<10 && e.getKeyChar()>='0' && e.getKeyChar()<='9')
	       super.keyTyped(e); // Optional
	   else
	     {
		   e.consume();  //erase the event
		 
		 }
	 }
	  
   });
  }

public void actionPerformed(ActionEvent e)
{
 try	
    {
        
	if(e.getSource()==b1)
	{  
          if(t_u.getText().length()==0 ||  tno.getText().length()==0 || cb.getSelectedItem().toString().equals("Select Gender") || ta.getText().length()==0|| tno.getText().length()==0)
	{
	 JOptionPane.showMessageDialog(null,"All fields are necessary");
	 t_u.requestFocus();
	}
   else if(tno.getText().length()<10)
      {
        JOptionPane.showMessageDialog(null,"Phone Number must be 10 digits");
         tno.setText("");
      }
       else
       	 {
	login_name=t_u.getText();
	password=t_p.getText();

        

	   sql="insert into mylogin values('"+login_name+"','"+password+"','"+cb.getSelectedItem()+"','"+ta.getText()+"','"+tno.getText()+"')";
	   prstm=cn.prepareStatement(sql);
           prstm.execute();	prstm.close();
              JOptionPane.showMessageDialog(null,"**** record successfully inserted:*****");
                t_u.setText("");
		t_p.setText("");
                tno.setText("");
                tadd.setText("");
		cb.setSelectedItem("Select Que");
                ta.setText("");
		t_u.requestFocus();
	
            }
	     }
        if(e.getSource()==b2)
        {
			Login m1 = new Login();
			m1.setVisible(true);
            setVisible(false);
        
        }
         if(e.getSource()==b3)
		  {
		    System.exit(0);
		  }
		
}
catch(Exception ex)
	         {
		System.out.println(ex);    	  
	         }
}
public static void main(String args[])
  {
   new Nuser();
  }
	
}

