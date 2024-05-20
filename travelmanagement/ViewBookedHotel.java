 
package travelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 
public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    ViewBookedHotel(String username){
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("View Booked Hotel Details");
        text.setFont(new Font("Sans_Serif", Font.BOLD, 25));
        text.setBounds(60, 0, 400, 30);
        add(text);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(30, 50, 150, 25);
        add(usrname);
        
        JLabel labelusrname = new JLabel();
        labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        JLabel usrpackage = new JLabel("Hotel Nmae");
        usrpackage.setBounds(30, 90, 150, 25);
        add(usrpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);
        
        JLabel usrperson = new JLabel("Total Persons");
        usrperson.setBounds(30, 130, 150, 25);
        add(usrperson);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);
        
        JLabel usrdays = new JLabel("Total Days");
        usrdays.setBounds(30, 170, 150, 25);
        add(usrdays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
        
        JLabel usrac = new JLabel("AC/Non-AC");
        usrac.setBounds(30, 210, 150, 25);
        add(usrac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);
        
        JLabel usrfood = new JLabel("Food Included");
        usrfood.setBounds(30, 250, 150, 25);
        add(usrfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);
        
        JLabel usrid = new JLabel("ID");
        usrid.setBounds(30, 290, 150, 25);
        add(usrid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);
        
        JLabel usridnumber = new JLabel("ID Number");
        usridnumber.setBounds(30, 330, 150, 25);
        add(usridnumber);
        
        JLabel labelidnumber = new JLabel();
        labelidnumber.setBounds(220, 330, 150, 25);
        add(labelidnumber);
        
        JLabel usrphone = new JLabel("Phone");
        usrphone.setBounds(30, 370, 150, 25);
        add(usrphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);
        
        JLabel usrprice = new JLabel("Total Cost");
        usrprice.setBounds(30, 410, 150, 25);
        add(usrprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);
        
         
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 350, 400);
        add(image);
        
        try{
            DBConnection conn = new DBConnection();
            String query = "select * from bookhotel where username='"+username+"'";
            ResultSet rs = conn.stmt.executeQuery(query);
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelidnumber.setText(rs.getString("idnumber"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
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
        new ViewBookedHotel("Bhole");
    }
}