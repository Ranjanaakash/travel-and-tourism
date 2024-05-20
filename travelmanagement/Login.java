package travelmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login, signup, Frgtpass;
    JTextField txtUsername, txtPassword;
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(140, 190, 245));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
    
       JPanel p2 = new JPanel();
       // p2.setBackground(new Color(140, 190, 245));
        p2.setBounds(400, 30, 400, 300);
        p2.setLayout(null);
        add(p2);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(60, 20, 100, 25);
        usrname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(usrname);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(60, 60, 300, 30);
        txtUsername.setBorder(BorderFactory.createEmptyBorder());
         p2.add(txtUsername);
        
        
        JLabel usrpassword = new JLabel("Password");
        usrpassword.setBounds(60, 110, 100, 25);
        usrpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(usrpassword);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(60, 150, 300, 30);
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(txtPassword);
        
        
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        
        Frgtpass = new JButton("Forgot Password");
        Frgtpass.setBounds(130, 250, 130, 30);
        Frgtpass.setBackground(new Color(133, 193, 233));
        Frgtpass.setForeground(Color.white);
        Frgtpass.setBorder(new LineBorder(new Color(133, 193, 233)));
        Frgtpass.addActionListener(this);
        p2.add(Frgtpass);
        
        JLabel text = new JLabel("Trouble in login....");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
               String Username = txtUsername.getText();
               String password = txtPassword.getText();
               
               String query = "select * from account where username = '"+Username+"' AND password = '"+password+"'";
               DBConnection conn = new DBConnection();
               ResultSet rs = conn.stmt.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Loading(Username);
               }
               else {
                   JOptionPane.showMessageDialog(null, "Incorrect Username or password");
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
        else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        Login login = new Login();
    }
}
