import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumber extends JFrame implements ActionListener {
    JLabel mainHeading;
    JLabel check;
    JLabel attemptLabel;
    JLabel scoreLabel;
    JTextField inputValue;
    JButton submit;
    JButton Restart;
    JButton exit;
    JButton menu;
    int level = 1;
    int attempts = 0;
    int score = 100;
    int totalScore = 0;
    int totalWordGuess = 0;
    int numberToGuess;
    int min = 1;
    int max = 100;

    GuessTheNumber() {
        ImageIcon icon = new ImageIcon("assets/GuessTheNumberIcon.png");
        setIconImage(icon.getImage());
        // Generating a random number
        generateRandomNumber();
        JOptionPane.showMessageDialog(this, "Level " + level + " Number Range 1-100");
        // Creating Frame
        setTitle("Guess the Number Game");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Heading styling plus adding in North of Border Layout
        JPanel headingPanel = new JPanel();
        mainHeading = new JLabel("Guess the Number");
        mainHeading.setForeground(Color.white);
        mainHeading.setFont(new Font("Arial Black", Font.PLAIN, 30));
        headingPanel.add(mainHeading);
        // headingPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        headingPanel.setBackground(Color.black);
        add(headingPanel, BorderLayout.NORTH);

        // Center first user interaction is added
        JPanel userInteractionContainer = new JPanel();
        inputValue = new JTextField(20);
        submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBackground(Color.decode("#7BD100"));
        submit.setForeground(Color.WHITE);
        submit.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        Restart = new JButton("Restart");
        Restart.setBackground(Color.decode("#0C0080"));
        Restart.setForeground(Color.WHITE);
        Restart.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        Restart.setFocusable(false);

        JPanel inputOfUser = new JPanel();
        inputOfUser.setLayout(new BorderLayout());
        inputOfUser.add(inputValue, BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        buttons.add(submit);
        buttons.add(Restart);

        userInteractionContainer.setLayout(new GridLayout(2, 1));
        userInteractionContainer.add(inputOfUser);
        userInteractionContainer.add(buttons);
        userInteractionContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        // Result
        attemptLabel = new JLabel("Attempts: 0");
        attemptLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
        scoreLabel = new JLabel("Score: 100");
        scoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
        check = new JLabel("Result come here");
        check.setFont(new Font("Arial Black", Font.PLAIN, 15));

        JPanel Results = new JPanel();
        Results.setLayout(new GridLayout(3, 1));
        JPanel attemptPanel = new JPanel();
        attemptPanel.add(attemptLabel);
        attemptPanel.setBackground(Color.decode("#C0C0C0"));

        Results.add(attemptPanel);
        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);
        scorePanel.setBackground(Color.decode("#C0C0C0"));

        Results.add(scorePanel);
        JPanel checkPanel = new JPanel();
        checkPanel.add(check);
        checkPanel.setBackground(Color.decode("#C0C0C0"));

        Results.add(checkPanel);
        Results.setBackground(Color.decode("#C0C0C0"));
        Results.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel body = new JPanel();
        body.setLayout(new GridLayout(1, 2));
        body.add(userInteractionContainer);
        body.add(Results);
        body.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        add(body, BorderLayout.CENTER);

        exit = new JButton("EXIT");
        exit.setFocusable(false);
        exit.setBackground(Color.decode("#d15a04"));
        exit.setForeground(Color.white);
        exit.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        menu = new JButton("Main Menu");
        menu.setFocusable(false);
        menu.setBackground(Color.decode("#088fa1"));
        menu.setForeground(Color.white);
        menu.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeToSmartPlay();
            }
        });

        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.add(exit, BorderLayout.EAST);
        footer.add(menu, BorderLayout.WEST);
        footer.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(footer, BorderLayout.SOUTH);

        submit.addActionListener(this);
        exit.addActionListener(this);
        Restart.addActionListener(this);
        
        this.setVisible(true);
    }

    public void generateRandomNumber() {
        Random random = new Random();
        numberToGuess = random.nextInt(max) + min;
        System.out.println(numberToGuess);
        attempts = 0;
        score = 100;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                int value = Integer.parseInt(inputValue.getText());
                if (value > max || value < min) {
                    check.setText("Out of range");
                    inputValue.setText("");
                    JOptionPane.showMessageDialog(this, "Enter value in range!");
                } else {
                    if (score == 0) {
                        if (level > 5) {
                            JOptionPane.showMessageDialog(this, "Congrats you completed the game!");
                            JOptionPane.showMessageDialog(this,
                                    "Total Words you guessed: " + totalWordGuess + "\nTotal Score: " + totalScore);
                            dispose();
                            new SelectGame();
                        } else {
                            check.setText("Score reached zero!");
                            JOptionPane.showMessageDialog(this, "You Failed to guess the value");
                            totalScore += score;
                            level++;
                            max += 25;
                            attemptLabel.setText("Attempts: " + attempts);
                            JOptionPane.showMessageDialog(this, "Level " + level + " Range " + min + "-" + max);
                            inputValue.setText("");
                            setDefaultValues();
                            generateRandomNumber();
                        }
                    } else {
                        if (value > numberToGuess) {
                            attempts++;
                            score -= 5;
                            attemptLabel.setText("Attempts: " + attempts);
                            scoreLabel.setText("Score: " + score);
                            check.setText("Too High!");
                        } else if (value < numberToGuess) {
                            attempts++;
                            score -= 5;
                            attemptLabel.setText("Attempts: " + attempts);
                            scoreLabel.setText("Score: " + score);
                            check.setText("Too Low!");
                        } else {
                            attempts++;
                            totalScore += score;
                            totalWordGuess++;
                            level++;
                            max += 25;
                            attemptLabel.setText("Attempts: " + attempts);
                            if (level > 5) {
                                totalScore += score;
                                totalWordGuess++;
                                JOptionPane.showMessageDialog(this, "Congrats you completed the game!");
                                JOptionPane.showMessageDialog(this,
                                        "Total Words you guessed: " + (totalWordGuess-1) + "\nTotal Score: " + (totalScore-100));
                                dispose();
                                new SelectGame();
                            } else {
                                check.setText("Value guessed");
                                JOptionPane.showMessageDialog(this, "Congrats you guessed the value");
                                JOptionPane.showMessageDialog(this, "Level " + level + " Range " + min + "-" + max);
                                inputValue.setText("");
                                setDefaultValues();
                                generateRandomNumber();
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                check.setText("Invalid input!");
                JOptionPane.showMessageDialog(this, "Enter integer number!");
                inputValue.setText("");
            }
        }
        if (e.getSource() == exit) {
            JOptionPane.showMessageDialog(this,
                    "Total Words you guessed: " + totalWordGuess + "\nTotal Score: " + totalScore);
            System.exit(0);
        }
        if (e.getSource() == Restart) {
            level = 1;
            totalScore = 0;
            totalWordGuess = 0;
            max = 100;
            generateRandomNumber();
            inputValue.setText("");
        }
    }

    public void setDefaultValues() {
        attemptLabel.setText("Attempts: 0");
        scoreLabel.setText("Score: 100");
        check.setText("Result come here");
    }
}