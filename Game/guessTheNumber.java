import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class guessTheNumber extends JFrame implements ActionListener {
    JLabel mainHeading;
    JLabel check;
    JLabel attemptLabel;
    JLabel scoreLabel;
    JTextField inputValue;
    JButton submit;
    JButton reset;
    JButton exit;
    int attempts = 0;
    int score = 100;
    int numberToGuess;

    guessTheNumber() {
        //Generating a random number
        generateRandomNumber();
        //Creating Frame 
        setTitle("Guess the Number Game");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //Main Heading styling plus adding in North of Border Layout
        JPanel headingPanel = new JPanel();
        mainHeading = new JLabel("Guess the Number");
        mainHeading.setFont(new Font("Arial Black",Font.PLAIN, 30));
        headingPanel.add(mainHeading);
        headingPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        add(headingPanel, BorderLayout.NORTH);

        //Center first user interaction is added
        JPanel userInteractionContainer = new JPanel();
        inputValue = new JTextField(20);
        submit = new JButton("Submit");
        submit.setFocusable(false);
        reset = new JButton("Reset");
        reset.setFocusable(false);

        JPanel inputOfUser = new JPanel();
        inputOfUser.setLayout(new BorderLayout());
        inputOfUser.add(inputValue,BorderLayout.SOUTH);

        JPanel buttons = new JPanel();
        buttons.add(submit);
        buttons.add(reset);

        userInteractionContainer.setLayout(new GridLayout(2,1));
        userInteractionContainer.add(inputOfUser);
        userInteractionContainer.add(buttons);
        userInteractionContainer.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));

        //Result
        attemptLabel = new JLabel("Attempts: 0");
        attemptLabel.setFont(new Font("Arial Black",Font.PLAIN, 15));
        scoreLabel = new JLabel("Score: 100");
        scoreLabel.setFont(new Font("Arial Black",Font.PLAIN, 15));
        check = new JLabel("Result come here");
        check.setFont(new Font("Arial Black",Font.PLAIN, 15));

        JPanel Results = new JPanel();
        Results.setLayout(new GridLayout(3,1));
        JPanel attemptPanel = new JPanel();
        attemptPanel.add(attemptLabel);
        Results.add(attemptPanel);
        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);
        Results.add(scorePanel);
        JPanel checkPanel = new JPanel();
        checkPanel.add(check);
        Results.add(checkPanel);
        // Results.setBorder(BorderFactory.createLineBorder(Color.lightGray, 4));

        JPanel body = new JPanel();
        body.setLayout(new GridLayout(1,2));
        body.add(userInteractionContainer);
        body.add(Results);
        add(body,BorderLayout.CENTER);

        exit = new JButton("EXIT");
        exit.setFocusable(false);
        JPanel exitBtn = new JPanel();
        exitBtn.add(exit);
        exitBtn.setBorder(BorderFactory.createEmptyBorder(20,0,10,0));
        add(exitBtn,BorderLayout.SOUTH);

        submit.addActionListener(this);
        exit.addActionListener(this);
        reset.addActionListener(this);
    }
    
    public void generateRandomNumber(){
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
        score = 100;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            try{
                int value = Integer.parseInt(inputValue.getText());
                if(value > 100 || value < 0) {
                    check.setText("Out of range");
                    inputValue.setText("");
                }
                else{
                    if(value > numberToGuess) {
                        attempts++;
                        score -= 5;
                        attemptLabel.setText("Attempts: " + attempts);
                        scoreLabel.setText("Score: " + score);
                        check.setText("Too High!");
                    }
                    else if(value < numberToGuess) {
                        attempts++;
                        score -= 5;
                        attemptLabel.setText("Attempts: " + attempts);
                        scoreLabel.setText("Score: " + score);
                        check.setText("Too Low!");
                    }
                    else{
                        attempts++;
                        attemptLabel.setText("Attempts: " + attempts);
                        check.setText("Congrats you guessed");
                        inputValue.setText("");
                        generateRandomNumber();
                    }
                }
            }
            catch(NumberFormatException ex) {
                check.setText("Invalid input!");
                inputValue.setText("");
            }
        }
        if(e.getSource() == exit) {
            System.exit(0);
        }
        if(e.getSource() == reset) {
            generateRandomNumber();
            attemptLabel.setText("Attempts: 0");
            scoreLabel.setText("Score: 100");
            check.setText("Result come here");
            inputValue.setText("");
        }
    }

    public static void main(String[] args) {
        guessTheNumber Game = new guessTheNumber();
        Game.setVisible(true);
    }
}