
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusrname, lblname;
    JComboBox comboid;
    JTextField txtnumber, txtaddress, txtcountry, txtemail, txtphone;
    JRadioButton rmale, rfemale;
    JButton add, back;
    AddCustomer(String username){
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel usrname = new JLabel("Username");
        usrname.setBounds(30, 50, 150, 25);
        add(usrname);
        
         labelusrname = new JLabel();
         labelusrname.setBounds(220, 50, 150, 25);
        add(labelusrname);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        comboid = new JComboBox(new String[] {"Aadhar Card", "Passport", "Pan Card", "Driving Liscence"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel number = new JLabel("ID Number");
        number.setBounds(30, 130, 150, 25);
        add(number);
        
        txtnumber = new JTextField();
        txtnumber.setBounds(220, 130, 150, 25);
        add(txtnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30, 170, 150, 25);
        add(name);
        
         lblname = new JLabel();
        lblname.setBounds(220, 170, 150, 25);
        add(lblname);
        
        JLabel usrgender = new JLabel("Gender");
        usrgender.setBounds(30, 210, 150, 25);
        add(usrgender);
        
          rmale = new JRadioButton("Male");
          rmale.setBounds(220, 210, 70, 25);
          rmale.setBackground(Color.WHITE);
          add(rmale);
          
          rfemale = new JRadioButton("Female");
          rfemale.setBounds(300, 210, 70, 25);
          rfemale.setBackground(Color.WHITE);
          add(rfemale);
          
          ButtonGroup bg = new ButtonGroup();
          bg.add(rmale);
          bg.add(rfemale);
          
        JLabel usrcountry = new JLabel("Country");
        usrcountry.setBounds(30, 250, 150, 25);
        add(usrcountry);
        
        txtcountry = new JTextField();
        txtcountry.setBounds(220, 250, 150, 25);
        add(txtcountry);
        
        JLabel usraddress = new JLabel("Address");
        usraddress.setBounds(30, 290, 150, 25);
        add(usraddress);
        
        txtaddress = new JTextField();
        txtaddress.setBounds(220, 290, 150, 25);
        add(txtaddress);
        
        JLabel usremail = new JLabel("Email");
        usremail.setBounds(30, 330, 150, 25);
        add(usremail);
        
        txtemail = new JTextField();
        txtemail.setBounds(220, 330, 150, 25);
        add(txtemail);
        
        JLabel usrphone = new JLabel("Phone");
        usrphone.setBounds(30, 370, 150, 25);
        add(usrphone);
        
        txtphone = new JTextField();
        txtphone.setBounds(220, 370, 150, 25);
        add(txtphone);
        
        add = new JButton("Add");
        add.setBackground(Color.blue);
        add.setForeground(Color.white);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back= new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try{
            DBConnection conn = new DBConnection();
            ResultSet rs = conn.stmt.executeQuery("select * from account where username = '"+username+"'");//Work Here
            while(rs.next()){
                labelusrname.setText(rs.getString("username"));
                lblname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username = labelusrname.getText();
            System.out.println(username);
            String id = (String) comboid.getSelectedItem();
            String idnumber = txtnumber.getText();
            String name = lblname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = txtcountry.getText();
            String address = txtaddress.getText();
            String phone = txtphone.getText();
            String email = txtemail.getText();
            
            try{
            DBConnection conn = new DBConnection();
            String query = "insert into customer values('"+username+"','"+id+"','"+idnumber+"','"+name+"', '"+gender+"', "
                    + "'"+country+"', '"+address+"', '"+phone+"','"+email+"')";
            conn.stmt.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("Bhole");
    }
}
