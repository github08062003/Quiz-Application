package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, lifeline, submit;
    ButtonGroup groupoptions;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1200, 800);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        Image img = i1.getImage();
        Image newImg = img.getScaledInstance(1200, 150, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(newImg);

        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1200, 150);
        add(image);

        qno = new JLabel();
        qno.setBounds(20, 160, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(qno);

        question = new JLabel();
        question.setBounds(80, 160, 1100, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        
        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(80, 200, 1000, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(80, 240, 1000, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(80, 280, 1000, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(80, 320, 1000, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(950, 370, 150, 35);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(950, 420, 150, 35);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(950, 470, 150, 35);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        repaint();

        ans_given = 1;

        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        } 
        
        count++;
        if (count < questions.length) { // Ensure count is within bounds
            start(count);
        } else {
            // Handle end of quiz, e.g., show results
            JOptionPane.showMessageDialog(this, "Quiz completed!");
            // You might want to reset or close the quiz here
        }
    } else if (ae.getSource() == lifeline) {
        // Handle lifeline action
    } else if (ae.getSource() == submit) {
        // Handle submit action
    }
}

public void paint(Graphics g) {
    super.paint(g);
    
    String time = "Time left- " + timer + " seconds";
    g.setColor(Color.RED);
    g.setFont(new Font("Tahoma", Font.BOLD, 18));
  
    if (timer > 0) {
        g.drawString(time, 1000, 200);
    } else {
        g.drawString("Time's Up!!", 1000, 200);
    }
    timer--; 
    
    try {
        Thread.sleep(1000);
        repaint();
    } catch (Exception e) {
        e.printStackTrace();
    }
   
    if (ans_given == 1) {
        ans_given = 0;
        timer = 15;
    } else if (timer < 0) {
        timer = 15;
        
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        } 
        
        count++;
        if (count < questions.length) { // Ensure count is within bounds
            start(count);
        } else {
            // Handle end of quiz, e.g., show results
            JOptionPane.showMessageDialog(this, "Quiz completed!");
            // You might want to reset or close the quiz here
        }
    }
}

    
    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
