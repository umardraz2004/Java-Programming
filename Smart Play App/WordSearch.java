import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class WordSearch {
    int currentIndex;
    JLabel scoreJLabel;

    WordSearch() {
        // JFrame basic setup
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Word Search");
        jFrame.setSize(600, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        // Add icon to the JFrame
        ImageIcon icon = new ImageIcon("assets/WordSearchIcon.png");
        jFrame.setIconImage(icon.getImage());

        // North Section
        JLabel title = new JLabel("Word Search");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        JPanel northJPanel = new JPanel();
        northJPanel.setBackground(Color.BLACK);
        northJPanel.add(title);

        // Functionality
        String incorrectWord[] = {
            "mohter", "fthaer", "byab", "cldih", "teegnare", "grommotehr", "sutdnet", 
            "tecaehr", "buisenss", "posren", "sleas", "celkr", "wmoan", "amn", "lion", 
            "tigre", "baer", "gdo", "atc", "ckrciet", "brid", "wlof", "tbael", "trcuk", 
            "boko", "pecnil", "iPaD", "cmoputer", "coat", "boto"
        };
        
        String correctWord[] = {"mother", "father", "baby", "child", "teenager",
        "grandmother", "student", "teacher", "business", "person", "sales" , "clerk",
        "woman", "man" ,"lion", "tiger", "bear", "dog", "cat", "cricket", "bird",
        "wolf","table", "truck", "book", "pencil", "iPad", "computer", "coat",
        "boot"};

        // Center Section
        JPanel incorrectJPanel = new JPanel();
        JLabel incorrectWordJLabel = new JLabel(incorrectWord[0]);
        incorrectWordJLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        incorrectJPanel.add(incorrectWordJLabel);

        JPanel inputJPanel = new JPanel();
        JTextField inputJTextFeild = new JTextField(8);
        inputJTextFeild.setFont(new Font("Arial", Font.PLAIN, 28));
        inputJTextFeild.setHorizontalAlignment(JTextField.CENTER);
        inputJPanel.add(inputJTextFeild);

        JPanel situationJPanel = new JPanel();
        JLabel situationJLabel = new JLabel("Guess the Word");
        situationJLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        situationJPanel.add(situationJLabel);

        JPanel submitJPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.decode("#009879"));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 28));

        currentIndex = 0;
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (currentIndex<incorrectWord.length-1) {
                    if (inputJTextFeild.getText().toLowerCase().equals(correctWord[currentIndex])) {
                        currentIndex++;
                        updateScoreLabel();
                        situationJLabel.setText("Correct!!!");
                    }
                    else {
                        situationJLabel.setText("Wrong!!!");
                    }
                    inputJTextFeild.setText("");
                    inputJTextFeild.requestFocusInWindow();
                    incorrectWordJLabel.setText(incorrectWord[currentIndex]);   
                }
                else {
                    submitButton.setEnabled(false);
                    situationJLabel.setText("Wow! All the Levels are Completed");
                }
            }
        });
        submitJPanel.add(submitButton);

        JPanel centerGridLayout = new JPanel(new GridLayout(4, 1));
        centerGridLayout.add(incorrectJPanel);
        centerGridLayout.add(inputJPanel);
        centerGridLayout.add(submitJPanel);
        centerGridLayout.add(situationJPanel);

        // South Section
        JPanel southJPanel = new JPanel(new BorderLayout());
        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Arial",Font.PLAIN,24));
        menuButton.setBackground(Color.decode("#088fa1"));
        menuButton.setForeground(Color.WHITE);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new WelcomeToSmartPlay();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial",Font.PLAIN,24));
        exitButton.setBackground(Color.decode("#d15a04"));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        scoreJLabel = new JLabel("Score: "+currentIndex);
        scoreJLabel.setFont(new Font("Arial",Font.BOLD,24));
        JPanel scoreJPanel = new JPanel();
        scoreJPanel.add(scoreJLabel);

        southJPanel.add(menuButton,BorderLayout.WEST);
        southJPanel.add(scoreJPanel,BorderLayout.CENTER);
        southJPanel.add(exitButton,BorderLayout.EAST);
        southJPanel.setBorder(new EmptyBorder(10,20,10,20));


        // Adding Components in JFrame (Border Layout)
        jFrame.add(northJPanel, BorderLayout.NORTH);
        jFrame.add(centerGridLayout, BorderLayout.CENTER);
        jFrame.add(southJPanel,BorderLayout.SOUTH);

        jFrame.setVisible(true);
    }
    private void updateScoreLabel() {
        scoreJLabel.setText("Score: " + currentIndex);
    }
}