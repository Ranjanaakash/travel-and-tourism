 
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements Runnable, ActionListener{
    Thread thread;
    JButton login, signup;
    Splash(){
    setSize(1920, 1080);
//    setLocation(200, 100);
    login = new JButton("Log In");
    login.setBounds(1330, 30, 70, 25);
    login.addActionListener(this);
    add(login);
    
    signup = new JButton("Sign Up");
    signup.setBounds(1430, 30, 80, 25);
    signup.addActionListener(this);
    add(signup);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);
    
    thread = new Thread(this);
    thread.start();
    setVisible(true);
}
    public void run(){
        try{
            Thread.sleep(7000);
        }catch(Exception e){
            
        }
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            new Login();
        }else if(ae.getSource()==signup){
            new Signup();
        }
    }
    public static void main(String[] args) {
      Splash frame = new Splash();
       
    } 
}
