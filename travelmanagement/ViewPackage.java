 
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

 
public class ViewPackage extends JFrame implements ActionListener{
     JButton back;
    ViewPackage(String username){
        setBounds(450, 180, 870, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("View Package Details");
        text.setFont(new Font("Sans_Serif", Font.BOLD, 25));
        text.setBounds(60, 0, 300, 30);
        add(text);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(30, 50, 150, 25);
        add(usrname);
        
        JLabel labelusrname = new JLabel();
        labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        JLabel usrpackage = new JLabel("Package");
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
        
        JLabel usrid = new JLabel("ID");
        usrid.setBounds(30, 170, 150, 25);
        add(usrid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);
        
        JLabel usridnumber = new JLabel("ID Number");
        usridnumber.setBounds(30, 210, 150, 25);
        add(usridnumber);
        
        JLabel labelidnumber = new JLabel();
        labelidnumber.setBounds(220, 210, 150, 25);
        add(labelidnumber);
        
        JLabel usrphone = new JLabel("Phone");
        usrphone.setBounds(30, 250, 150, 25);
        add(usrphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);
        
        JLabel usrprice = new JLabel("Price");
        usrprice.setBounds(30, 290, 150, 25);
        add(usrprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);
        
         
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130, 360, 100, 25);
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
            String query = "select * from bookpackage where username='"+username+"'";
            ResultSet rs = conn.stmt.executeQuery(query);
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelidnumber.setText(rs.getString("idnumber"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                 
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
        new ViewPackage("Bhole");
    }
}
