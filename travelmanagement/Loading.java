 
package travelmanagement;
import java.awt.*;
import javax.swing.*;
 
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String Username;
    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value<max){
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    new DashBoard(Username);
                }
                Thread.sleep(30);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String Username){
        this.Username = Username;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.MAGENTA);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.MAGENTA);
        loading.setFont(new Font("Raleway", Font.BOLD, 15));
        add(loading);
        
        JLabel username = new JLabel("Welcome"+" "+Username);
        username.setBounds(20, 310, 400, 40);
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Raleway", Font.BOLD, 15));
        add(username);
        
        t.start();
        
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
