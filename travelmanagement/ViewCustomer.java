 
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class ViewCustomer extends JFrame implements ActionListener{
    JButton back;
    ViewCustomer(String username){
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(30, 50, 150, 25);
        add(usrname);
        
        JLabel labelusrname = new JLabel();
        labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        JLabel usrid = new JLabel("ID");
        usrid.setBounds(30, 110, 150, 25);
        add(usrid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);
        
         JLabel number = new JLabel("ID Number");
        number.setBounds(30, 170, 150, 25);
        add(number);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30, 230, 150, 25);
        add(name);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);
        
        JLabel usrgender = new JLabel("Gender");
        usrgender.setBounds(30, 290, 150, 25);
        add(usrgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);
        
        JLabel usrcountry = new JLabel("Country");
        usrcountry.setBounds(500, 50, 150, 25);
        add(usrcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);
        
        JLabel usraddress = new JLabel("Address");
        usraddress.setBounds(500, 110, 150, 25);
        add(usraddress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);
        
        JLabel usrphone = new JLabel("Phone");
        usrphone.setBounds(500, 170, 150, 25);
        add(usrphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);
        
        JLabel usremail = new JLabel("Email");
        usremail.setBounds(500, 230, 150, 25);
        add(usremail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 230, 150, 25);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 400, 600, 200);
        add(image);
        
        try{
            DBConnection conn = new DBConnection();
            String query = "select * from customer where username='"+username+"'";
            ResultSet rs = conn.stmt.executeQuery(query);
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
          
       new ViewCustomer("");
    }
}
