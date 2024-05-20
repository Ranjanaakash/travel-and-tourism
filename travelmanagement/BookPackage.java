 
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
 
public class BookPackage extends JFrame implements ActionListener{
    Choice CPackage;
    JTextField txtpersons;
    JLabel text, usrname, labelusrname, usrpackage,usrperson, usrid, labelid, usrnumber, labelnumber, usrphone, labelphone, usrtotal, labelprice;
    String username;
    JButton Checkprice, BookPackage, Back;
    BookPackage(String username){
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        text = new JLabel("Book Package");
        text.setBounds(35, 10, 250, 25);
        text.setFont(new Font("Sans_Serif", Font.BOLD, 30));
        add(text);
        
        usrname = new JLabel("Username");
        usrname.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrname.setBounds(40, 70, 100, 20);
        add(usrname);
        
        labelusrname = new JLabel();
        labelusrname.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        labelusrname.setBounds(250, 70, 100, 20);
        add(labelusrname);
        
        usrpackage = new JLabel("Select Package");
        usrpackage.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrpackage.setBounds(40, 110, 150, 20);
        add(usrpackage);
        
        CPackage = new Choice();
        CPackage.add("Gold Package");
        CPackage.add("Silver Package");
        CPackage.add("Bronze Package");
        CPackage.setBounds(250, 110, 200, 20);
        add(CPackage);
        
        usrperson = new JLabel("Total Persons");
        usrperson.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrperson.setBounds(40, 150, 150, 25);
        add(usrperson);
        
        txtpersons = new JTextField("1");
        txtpersons.setBounds(250, 150, 200, 25);
        add(txtpersons);
        
        usrid = new JLabel("ID");
        usrid.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrid.setBounds(40, 190, 150, 20);
        add(usrid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);
        
        usrnumber = new JLabel("ID Number");
        usrnumber.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrnumber.setBounds(40, 230, 150, 20);
        add(usrnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 20);
        add(labelnumber);
        
        usrphone = new JLabel("Phone");
        usrphone.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrphone.setBounds(40, 270, 150, 20);
        add(usrphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        add(labelphone);
        
        usrtotal = new JLabel("Total Price");
        usrtotal.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrtotal.setBounds(40, 310, 150, 20);
        add(usrtotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 150, 20);
        add(labelprice);
        
        try{
            DBConnection conn = new DBConnection();
            String query = "select * from customer where username='"+username+"'";
            ResultSet rs = conn.stmt.executeQuery(query);
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("idnumber"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Checkprice = new JButton("Check Price");
        Checkprice.setBackground(Color.black);
        Checkprice.setForeground(Color.white);
        Checkprice.setBounds(60, 380, 120, 20);
        Checkprice.addActionListener(this);
        add(Checkprice);
        
        BookPackage = new JButton("Book Package");
        BookPackage.setBackground(Color.black);
        BookPackage.setForeground(Color.white);
        BookPackage.setBounds(200, 380, 120, 20);
        BookPackage.addActionListener(this);
        add(BookPackage);
        
        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setBounds(340, 380, 120, 20);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Checkprice){
            String Package = CPackage.getSelectedItem();
            int cost = 0;
            if(Package.equals("Gold Package")){
            cost+= 12000;
        }else if(Package.equals("Silver Package")){
            cost+= 15000;
        }else{
            cost+= 18000;
        }
            
            int person = Integer.parseInt(txtpersons.getText());
            cost*= person;
            labelprice.setText("Rs"+cost);
        }else if(ae.getSource()==BookPackage){
            try{
               DBConnection conn =  new DBConnection();
               conn.stmt.executeUpdate("insert into bookpackage values('"+labelusrname.getText()+"', '"+CPackage.getSelectedItem()+"', '"+txtpersons.getText()+"', '"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
               JOptionPane.showMessageDialog(null, "Package Booked Successfully");
               setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
           setVisible(false); 
        }
    }
    public static void main(String[] args) {
        new BookPackage("Bhole");
    }
}
