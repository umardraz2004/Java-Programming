import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Help {
    Help() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Help");
        ImageIcon icon = new ImageIcon("assets/HelpIcon.png");
        jFrame.setIconImage(icon.getImage());
        jFrame.setSize(500,400);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                jFrame.dispose();
                new WelcomeToSmartPlay();
            }
        });

        String helpText = "<html>" +
                "<h1>Welcome to Smart Play!</h1>" +
                "<p>This app offers a fun and engaging experience with four exciting games you can play anytime, anywhere. Here’s a quick guide to get you started:</p>" +
                "<h2>Games Available:</h2>" +
                "<ul>" +
                "<li><b>Tic-Tac-Toe</b></li>" +
                "<li><b>Word Search</b></li>" +
                "<li><b>Guess the Number</b></li>" +
                "<li><b>Rock Paper Scissor</b></li>" +
                "</ul>" +
                "<h2>How to Play Each Game:</h2>" +
                "<h3>1. Tic-Tac-Toe</h3>" +
                "<p>Tic-Tac-Toe is a classic game where two players take turns marking in a 3x3 grid cells with their respective symbols (X or O). The goal is to be the first to get three of your symbols in horizontally, vertically, diagonally or anti-diagonally.</p>" +
                "<h4>How to Play:</h4>" +
                "<ul>" +
                "<li>Select \"Tic-Tac-Toe\" from the main menu.</li>" +
                "<li>1st player will be PlayerX and other player will be PlayerO.</li>" +
                "<li>Tap on any empty cell in the grid to place your symbol.</li>" +
                "<li>The score of both players will be shown in Score Board in each level.</li>" +
                "<li>Alternate turns with your opponent until someone wins or the grid is full.</li>" +
                "</ul>" +
                "<h3>2. Word Search</h3>" +
                "<p>In Word Search, the shuffled word is written and you have to find the correct word and write it in the input feild and hit the submit button for next level.</p>" +
                "<h4>How to Play:</h4>" +
                "<ul>" +
                "<li>Select \"Word Search\" from the main menu.</li>" +
                "<li>Find the word from shuffled word.</li>" +
                "<li>Submit correct word and go to the next Level.</li>" +
                "<li>Score will be added after correct submission.</li>" +
                "</ul>" +
                "<h3>3. Guess the Number</h3>" +
                "<p>Guess the Number is a simple guessing game where you try to guess a randomly selected number within a given range.</p>" +
                "<h4>How to Play:</h4>" +
                "<ul>" +
                "<li>Select \"Guess the Number\" from the main menu.</li>" +
                "<li>Start a difficulty level from range 1-100 and range will be increased by 25 with each level.</li>" +
                "<li>Enter your guess and receive feedback on whether your guess is too high, too low, or correct.</li>" +
                "<li>Continue guessing until you find the correct number.</li>" +
                "</ul>" +
                "<h3>4. Rock Paper Scissor</h3>" +
                "<p>Rock Paper Scissor is a hand game, played between you and computer.</p>" +
                "<h4>How to Play:</h4>" +
                "<ul>" +
                "<li>Select \"Rock Paper Scissor\" from the main menu.</li>" +
                "<li>Choose your move: Rock, Paper, or Scissor.</li>" +
                "<li>The app will randomly choose its move.</li>" +
                "<li>The winner is determined based on the rules:</li>" +
                "<ul>" +
                "<li>Rock crushes Scissors.</li>" +
                "<li>Scissors cuts Paper.</li>" +
                "<li>Paper covers Rock.</li>" +
                "</ul>" +
                "<li>Play as many rounds as you like!</li>" +
                "<h3>Enjoy playing Smart Play!</h3>" +
                "</html>";

        JEditorPane editorPane = new JEditorPane("text/html", helpText);
        editorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPane);
        jFrame.add(scrollPane, BorderLayout.CENTER);

        jFrame.setVisible(true);
    }
}