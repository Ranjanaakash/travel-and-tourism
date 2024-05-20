 
package travelmanagement;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookHotel extends JFrame implements ActionListener{
    Choice CHotel, CAC, CFood;
    JTextField txtpersons, txtdays;
    JLabel text, usrname, usrid, labelusrname, usrdays,usrchoice, usrpackage,usrperson, usrfood, labelid, usrnumber, labelnumber, usrphone, labelphone, usrtotal, labelprice;
    String username;
    JButton Checkprice, BookPackage, Back;
    BookHotel(String username){
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        text = new JLabel("Book Hotel");
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
        
        usrpackage = new JLabel("Select Hotel");
        usrpackage.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrpackage.setBounds(40, 110, 150, 20);
        add(usrpackage);
        
        CHotel = new Choice();
        CHotel.setBounds(250, 110, 200, 20);
        add(CHotel);
        
        try{
            DBConnection conn = new DBConnection();
            ResultSet rs = conn.stmt.executeQuery("select * from hotel");
            while(rs.next()){
                CHotel.add(rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        usrperson = new JLabel("Total Persons");
        usrperson.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrperson.setBounds(40, 150, 150, 25);
        add(usrperson);
        
        txtpersons = new JTextField("1");
        txtpersons.setBounds(250, 150, 200, 25);
        add(txtpersons);
        
        usrdays = new JLabel("No. Of Days");
        usrdays.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrdays.setBounds(40, 190, 150, 25);
        add(usrdays);
        
        txtdays = new JTextField("1");
        txtdays.setBounds(250, 190, 200, 25);
        add(txtdays);
        
        usrchoice = new JLabel("AC/ Non-AC");
        usrchoice.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrchoice.setBounds(40, 230, 150, 25);
        add(usrchoice);
        
        CAC = new Choice();
        CAC.add("AC");
        CAC.add("Non-AC");
        CAC.setBounds(250, 230, 200, 20);
        add(CAC);
        
        usrfood = new JLabel("Food Included");
        usrfood.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrfood.setBounds(40, 270, 150, 20);
        add(usrfood);
        
         CFood = new Choice();
         CFood.add("Yes");
         CFood.add("No");
        CFood.setBounds(250, 270, 200, 20);
        add(CFood);
        
         usrid = new JLabel("ID");
        usrid.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrid.setBounds(40, 310, 150, 20);
        add(usrid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 310, 150, 20);
        add(labelid);
        
        usrnumber = new JLabel("ID Number");
        usrnumber.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrnumber.setBounds(40, 350, 150, 20);
        add(usrnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 20);
        add(labelnumber);
        
        usrphone = new JLabel("Phone");
        usrphone.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrphone.setBounds(40, 390, 150, 20);
        add(usrphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);
        
        usrtotal = new JLabel("Total Price");
        usrtotal.setFont(new Font("Sans_Serif", Font.PLAIN, 20));
        usrtotal.setBounds(40, 430, 150, 20);
        add(usrtotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 20);
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
        Checkprice.setBounds(60, 470, 120, 20);
        Checkprice.addActionListener(this);
        add(Checkprice);
        
        BookPackage = new JButton("Book Hotel");
        BookPackage.setBackground(Color.black);
        BookPackage.setForeground(Color.white);
        BookPackage.setBounds(200, 470, 120, 20);
        BookPackage.addActionListener(this);
        add(BookPackage);
        
        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.setBounds(340, 470, 120, 20);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Checkprice){
            try{
            DBConnection conn = new DBConnection();
            ResultSet rs = conn.stmt.executeQuery("select * from hotel where name = '"+CHotel.getSelectedItem()+"'");
            
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                int food = Integer.parseInt(rs.getString("food"));
                
                int persons = Integer.parseInt(txtpersons.getText());
                int days = Integer.parseInt(txtdays.getText());
                
                String roomselect = CAC.getSelectedItem();
                String foodselect = CFood.getSelectedItem();
                
                if(persons*days > 0){
                    int total = 0;
                    total+= roomselect.equals("AC") ? ac : 0;
                    total+= foodselect.equals("Yes") ? food : 0;
                    total+= cost;
                    total = total * persons * days;
                    labelprice.setText("Rs"+total);
                }else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }

            }
             }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==BookPackage){
            try{
               DBConnection conn =  new DBConnection();
               conn.stmt.executeUpdate("insert into bookhotel values('"+labelusrname.getText()+"', '"+CHotel.getSelectedItem()+"', '"+txtpersons.getText()+"','"+txtdays.getText()+"', '"+CAC.getSelectedItem()+"', '"+CFood.getSelectedItem()+"', '"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
               JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
               setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
           setVisible(false); 
        }
    }
    public static void main(String[] args) {
         
        new BookHotel(" ");
    }
}
