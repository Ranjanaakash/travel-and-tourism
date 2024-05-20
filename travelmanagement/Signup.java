 
package travelmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField txtUsername, txtname, txtpassword, txtsecurityans;
    Choice security;
    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel usrname = new JLabel("Username *");
        usrname.setFont(new Font("Tahoma", Font.BOLD, 15));
        usrname.setBounds(50, 20, 125, 25);
        p1.add(usrname);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(190, 20, 180, 25);
        txtUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtUsername);
        
        JLabel lname = new JLabel("Name *");
        lname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lname.setBounds(50, 60, 125, 25);
        p1.add(lname);
        
        txtname = new JTextField();
        txtname.setBounds(190, 60, 180, 25);
        txtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtname);
        
        
        JLabel usrpassword = new JLabel("Password *");
        usrpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        usrpassword.setBounds(50, 100, 125, 25);
        p1.add(usrpassword);
        
        txtpassword = new JTextField();
        txtpassword.setBounds(190, 100, 180, 25);
        txtpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtpassword);
        
        JLabel usrsecurity = new JLabel("Security Question *");
        usrsecurity.setFont(new Font("Tahoma", Font.BOLD, 15));
        usrsecurity.setBounds(50, 140, 125, 15);
        p1.add(usrsecurity);
        
        security = new Choice();
        security.add("Favourite Food Name");
        security.add("Favourite Pet Name");
        security.add("Favourite Player Name");
        security.add("Favourite Color");
        security.add("Favourite Dress");
        security.add("Your Lucky Number");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);
        
         JLabel securityans = new JLabel("Answer *");
        securityans.setFont(new Font("Tahoma", Font.BOLD, 15));
        securityans.setBounds(50, 175, 125, 25);
        p1.add(securityans);
        
        txtsecurityans = new JTextField();
        txtsecurityans.setBounds(190, 180, 180, 25);
        txtsecurityans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtsecurityans);
        
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 15));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);
        
//        JLabel lnae = new JLabel("Ajay");
//        lnae.setFont(new Font("Tahoma", Font.BOLD, 15));
//        lnae.setBounds(300, 300, 150, 25);
//        p1.add(lnae);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = txtUsername.getText();
            String name = txtname.getText();
            String password = txtpassword.getText();
            String question = security.getSelectedItem();
            String answer = txtsecurityans.getText();
            
            // Check if any mandatory field is empty
            if(username.isEmpty() || name.isEmpty() || password.isEmpty() || answer.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else{
                String query = "insert into account values('"+username+"' ,'"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
                try{
                    DBConnection DBConn = new DBConnection();
                    DBConn.stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");

                    setVisible(false);
                    new Login();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
