 
package travelmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton pay, back;
    Payment(){
        setBounds(500, 200, 500, 800);
        setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 600);
        add(image);
        
        JLabel transction = new JLabel("Transaction id *");
        transction.setFont(new Font("Tahoma", Font.BOLD, 15));
        transction.setBounds(170, 500, 80, 40);
        add(transction);
        
        JTextField txttranscation = new JTextField();
        txttranscation.setBounds(260, 500, 150, 40);
        txttranscation.setBorder(BorderFactory.createEmptyBorder());
        add(txttranscation);
        
        
        pay = new JButton("Pay");
        pay.setBounds(170, 550, 80, 40);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(260, 550, 80, 40);
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            setVisible(false);
            new Paytm();
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Payment();
        
    }
}
