
package travelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class DashBoard extends JFrame implements ActionListener{
    String username;
    JButton AddPersonal, ViewPersonal, UpdatePersonal, CheckPackage, BookPackage, ViewBookHotel,BookHotel, ViewHotel, ViewPackage, DeletePersonal,
            About, Notepad, Calculator, Payments, Destination;
       DashBoard(String username){
           this.username = username;
         //setBounds(0, 0, 1600, 1000);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setLayout(null);
         
         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBackground(new Color(0, 0, 102));
         p1.setBounds(0, 0, 1600, 65);
         add(p1);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
         Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel icon = new JLabel(i3);
         icon.setBounds(5, WIDTH, 70, 70);
         p1.add(icon);
         
         JLabel heading = new JLabel("Dashboard");
         heading.setBounds(80, 10, 300, 40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Tahoma", Font.BOLD, 30));
          p1.add(heading);
          
          
          JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBackground(new Color(0, 0, 102));
         p2.setBounds(0, 65, 300, 900);
         add(p2);
         
         AddPersonal = new JButton("Add Personal Details");
         AddPersonal.setBounds(0, 0, 300, 50);
         AddPersonal.setBackground(new Color(0, 0, 102));
         AddPersonal.setForeground(Color.white);
         AddPersonal.setFont(new Font("Tahoma", Font.PLAIN, 20));
         AddPersonal.setMargin(new Insets(0, 0, 0, 60));
         AddPersonal.addActionListener(this);
         p2.add(AddPersonal);
         
         UpdatePersonal = new JButton("Update Personal Details");
         UpdatePersonal.setBounds(0, 50, 300, 50);
         UpdatePersonal.setBackground(new Color(0, 0, 102));
         UpdatePersonal.setForeground(Color.white);
         UpdatePersonal.setFont(new Font("Tahoma", Font.PLAIN, 20));
         UpdatePersonal.setMargin(new Insets(0, 0, 0, 30));
         UpdatePersonal.addActionListener(this);
         p2.add(UpdatePersonal);
         
         ViewPersonal = new JButton("View Details");
         ViewPersonal.setBounds(0, 100, 300, 50);
         ViewPersonal.setBackground(new Color(0, 0, 102));
         ViewPersonal.setForeground(Color.white);
         ViewPersonal.setFont(new Font("Tahoma", Font.PLAIN, 20));
         ViewPersonal.setMargin(new Insets(0, 0, 0, 130));
         ViewPersonal.addActionListener(this);
         p2.add(ViewPersonal);
         
         DeletePersonal = new JButton("Delete Personal Details");
         DeletePersonal.setBounds(0, 150, 300, 50);
         DeletePersonal.setBackground(new Color(0, 0, 102));
         DeletePersonal.setForeground(Color.white);
         DeletePersonal.setFont(new Font("Tahoma", Font.PLAIN, 20));
         DeletePersonal.setMargin(new Insets(0, 0, 0, 40));
         DeletePersonal.addActionListener(this);
         p2.add(DeletePersonal);
        
         CheckPackage = new JButton("Check Package");
         CheckPackage.setBounds(0, 200, 300, 50);
         CheckPackage.setBackground(new Color(0, 0, 102));
         CheckPackage.setForeground(Color.white);
         CheckPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
         CheckPackage.setMargin(new Insets(0, 0, 0, 110));
         CheckPackage.addActionListener(this);
         p2.add(CheckPackage);
         
         BookPackage = new JButton("Book Package");
         BookPackage.setBounds(0, 250, 300, 50);
         BookPackage.setBackground(new Color(0, 0, 102));
         BookPackage.setForeground(Color.white);
         BookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
         BookPackage.setMargin(new Insets(0, 0, 0, 120));
         BookPackage.addActionListener(this);
         p2.add(BookPackage);
         
         ViewPackage = new JButton("View Package");
         ViewPackage.setBounds(0, 300, 300, 50);
         ViewPackage.setBackground(new Color(0, 0, 102));
         ViewPackage.setForeground(Color.white);
         ViewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
         ViewPackage.setMargin(new Insets(0, 0, 0, 120));
         ViewPackage.addActionListener(this);
         p2.add(ViewPackage);
         
         ViewHotel = new JButton("View Hotels");
         ViewHotel.setBounds(0, 350, 300, 50);
         ViewHotel.setBackground(new Color(0, 0, 102));
         ViewHotel.setForeground(Color.white);
         ViewHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
         ViewHotel.setMargin(new Insets(0, 0, 0, 130));
         ViewHotel.addActionListener(this);
         p2.add(ViewHotel);
         
         BookHotel = new JButton("Book Hotel");
         BookHotel.setBounds(0, 400, 300, 50);
         BookHotel.setBackground(new Color(0, 0, 102));
         BookHotel.setForeground(Color.white);
         BookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
         BookHotel.setMargin(new Insets(0, 0, 0, 140));
         BookHotel.addActionListener(this);
         p2.add(BookHotel);
         
         ViewBookHotel = new JButton("View Booked Hotel");
         ViewBookHotel.setBounds(0, 450, 300, 50);
         ViewBookHotel.setBackground(new Color(0, 0, 102));
         ViewBookHotel.setForeground(Color.white);
         ViewBookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
         ViewBookHotel.setMargin(new Insets(0, 0, 0, 70));
         ViewBookHotel.addActionListener(this);
         p2.add(ViewBookHotel);
         
         Destination = new JButton("Destinations");
         Destination.setBounds(0, 500, 300, 50);
         Destination.setBackground(new Color(0, 0, 102));
         Destination.setForeground(Color.white);
         Destination.setFont(new Font("Tahoma", Font.PLAIN, 20));
         Destination.setMargin(new Insets(0, 0, 0, 125));
         Destination.addActionListener(this);
         p2.add(Destination);
         
         Payments = new JButton("Payments");
         Payments.setBounds(0, 550, 300, 50);
         Payments.setBackground(new Color(0, 0, 102));
         Payments.setForeground(Color.white);
         Payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
         Payments.setMargin(new Insets(0, 0, 0, 155));
         Payments.addActionListener(this);
         p2.add(Payments);
         
         Calculator = new JButton("Calculator");
         Calculator.setBounds(0, 600, 300, 50);
         Calculator.setBackground(new Color(0, 0, 102));
         Calculator.setForeground(Color.white);
         Calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
         Calculator.setMargin(new Insets(0, 0, 0, 145));
         Calculator.addActionListener(this);
         p2.add(Calculator);
         
         Notepad = new JButton("Notepad");
         Notepad.setBounds(0, 650, 300, 50);
         Notepad.setBackground(new Color(0, 0, 102));
         Notepad.setForeground(Color.white);
         Notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
         Notepad.setMargin(new Insets(0, 0, 0, 155));
         Notepad.addActionListener(this);
         p2.add(Notepad);
         
         About = new JButton("About");
         About.setBounds(0, 700, 300, 50);
         About.setBackground(new Color(0, 0, 102));
         About.setForeground(Color.white);
         About.setFont(new Font("Tahoma", Font.PLAIN, 20));
         About.setMargin(new Insets(0, 0, 0, 175));
         About.addActionListener(this);
         p2.add(About);
         
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         JLabel image = new JLabel(i6);
         image.setBounds(0, 0, 1650, 1000);
         add(image);
         
         JLabel text = new JLabel("Travel and Tourism");
         text.setBounds(400, 70,1000,70);
         text.setForeground(Color.RED);
         text.setFont(new Font("SANS_SERIF", Font.TRUETYPE_FONT, 50));
         image.add(text);
         
         
         setVisible(true);
     }
       
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==AddPersonal){
               new AddCustomer(username);
           }else if(ae.getSource()==ViewPersonal){
               new ViewCustomer(username);
           }else if(ae.getSource()==UpdatePersonal){
               new UpdateCustomer(username);
           }else if(ae.getSource() == CheckPackage){
               new CheckPackage();
           }else if(ae.getSource()==BookPackage){
               new BookPackage(username);
           }else if(ae.getSource()== ViewPackage){
               new ViewPackage(username);
           }else if(ae.getSource()==ViewHotel){
               new ViewHotel();
           }else if(ae.getSource()==Destination){
               new Destination();
           }else if(ae.getSource()==BookHotel){
               new BookHotel(username);
           }else if(ae.getSource() == ViewBookHotel){
               new ViewBookedHotel(username);
           }else if(ae.getSource()== Payments){
               new Payment();
           }else if(ae.getSource() == Calculator){
               try{
                   Runtime.getRuntime().exec("calc.exe");
               }catch(Exception e){
                   e.printStackTrace();
               }
           }else if(ae.getSource() == Notepad){
               try{
               Runtime.getRuntime().exec("notepad.exe");
               }catch(Exception e){
                   e.printStackTrace();
               }
           }else if(ae.getSource() == About){
               new About();
           }
           else if(ae.getSource()==DeletePersonal){
               new DeleteDetails(username);
           }
       }
    public static void main(String[] args) {
         new DashBoard("");
    }
   
}
