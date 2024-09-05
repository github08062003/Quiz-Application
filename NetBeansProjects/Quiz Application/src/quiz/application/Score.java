package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score) {
        setBounds(100, 20, 1000, 800); 
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH); 
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(300, 50, 600, 300); 
        add(image);

        JLabel heading = new JLabel("Thank you, " + name + " for playing Creative Minds!");
        heading.setBounds(450, 400, 300, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(heading);

        JLabel lblscore = new JLabel("Your score is: " + score);
        lblscore.setBounds(500, 450, 200, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblscore.setForeground(Color.BLUE);
        add(lblscore);

        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(525, 550, 150, 40);
        playAgain.setBackground(new Color(30, 144, 255));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);
    
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 75); // Example score
    }
}
