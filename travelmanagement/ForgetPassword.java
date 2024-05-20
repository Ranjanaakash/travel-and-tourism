 
package travelmanagement;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.awt.Image;
import javax.swing.*;
 
public class ForgetPassword extends JFrame implements ActionListener{
    JTextField txtUsername, txtname, txtquestion, txtsecurityans, txtpassword;
    JButton search, retrieve, back;
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.red);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(40, 20, 100, 25);
        usrname.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(usrname);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(220, 20, 150, 25);
        txtUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtUsername);
        
        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lname = new JLabel("Name");
        lname.setBounds(40, 60, 100, 25);
        lname.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lname);
        
        txtname = new JTextField();
        txtname.setBounds(220, 60, 150, 25);
        txtname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtname);
        
        JLabel question = new JLabel("Security Question");
        question.setBounds(40, 100, 150, 25);
        question.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(question);
        
        txtquestion = new JTextField();
        txtquestion.setBounds(220, 100, 150, 25);
        txtquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtquestion);
        
        JLabel securityans = new JLabel("Answer");
        securityans.setBounds(40, 140, 150, 25);
        securityans.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(securityans);
        
        txtsecurityans = new JTextField();
        txtsecurityans.setBounds(220, 140, 150, 25);
        txtsecurityans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtsecurityans);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel usrpassword = new JLabel("Your Password");
        usrpassword.setBounds(40, 180, 150, 25);
        usrpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(usrpassword);
        
        txtpassword = new JTextField();
        txtpassword.setBounds(220, 180, 150, 25);
        txtpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(txtpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+txtUsername.getText()+"'";
                DBConnection conn = new DBConnection();
                ResultSet rs = conn.stmt.executeQuery(query);
                while(rs.next()){
                    txtname.setText(rs.getString("name"));
                    txtquestion.setText(rs.getString("Question"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+txtsecurityans.getText()+"' AND username = '"+txtUsername.getText()+"'";
                DBConnection conn = new DBConnection();
                ResultSet rs = conn.stmt.executeQuery(query);
                while(rs.next()){
                    txtpassword.setText(rs.getString("password"));
                   // txtquestion.setText(rs.getString("Question"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
