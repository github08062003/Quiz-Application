package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    
    JButton rules, back;
    JTextField tfname;
    Login()  {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 580, 480);
        add(image);
        
        JLabel heading = new JLabel("Creative Minds");
        heading.setBounds(730, 60, 280, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(800, 140, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(725, 180, 280, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(tfname);
        
        rules= new JButton("Rules");
        rules.setBounds(720, 250, 100, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back= new JButton("Back");
        back.setBounds(900, 250, 100, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(1200, 500);
        setLocation(80,130);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource()==back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
        
    
    }
}
