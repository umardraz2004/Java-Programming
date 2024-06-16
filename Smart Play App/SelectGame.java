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
import javax.swing.border.EmptyBorder;

public class SelectGame {
    SelectGame() {
        // Basic JFrame setup
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Select Game");
        ImageIcon icon = new ImageIcon("assets/SelectGameIcon.png");
        jFrame.setIconImage(icon.getImage());
        jFrame.setSize(750,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // North Section
        JLabel selectJLabel = new JLabel();
        selectJLabel.setText("Select a Game");
        selectJLabel.setFont(new Font("Arial",Font.BOLD,32));
        selectJLabel.setForeground(Color.WHITE);
        JPanel northJPanel = new JPanel();
        northJPanel.setBackground(Color.BLACK);
        northJPanel.add(selectJLabel);

        // Center Section
        JButton TicTacToeJButton = new JButton("Tic Tac Toe");
        TicTacToeJButton.setFont(new Font("Arial",Font.BOLD,28));
        TicTacToeJButton.setForeground(Color.WHITE);
        TicTacToeJButton.setBackground(Color.decode("#1ABC9C"));
        TicTacToeJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new TicTacToe();
            }
        });

        JButton WordSearchJButton = new JButton("Word Search");
        WordSearchJButton.setFont(new Font("Arial",Font.BOLD,28));
        WordSearchJButton.setForeground(Color.WHITE);
        WordSearchJButton.setBackground(Color.decode("#9B59B6"));
        WordSearchJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new WordSearch();
            }
        });

        JButton GuessTheNumberJButton = new JButton("Guess The Number");
        GuessTheNumberJButton.setFont(new Font("Arial",Font.BOLD,28));
        GuessTheNumberJButton.setForeground(Color.WHITE);
        GuessTheNumberJButton.setBackground(Color.decode("#FF9800"));
        GuessTheNumberJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new GuessTheNumber();
            }
        });

        JButton RockPaperScissorJButton = new JButton("Rock Paper Scissor");
        RockPaperScissorJButton.setFont(new Font("Arial",Font.BOLD,28));
        RockPaperScissorJButton.setForeground(Color.WHITE);
        RockPaperScissorJButton.setBackground(Color.decode("#E91E63"));
        RockPaperScissorJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new RockPaperScissor();
            }
        });

        JPanel centerJPanel = new JPanel(new GridLayout(2,2,10,15));
        centerJPanel.add(TicTacToeJButton);
        centerJPanel.add(WordSearchJButton);
        centerJPanel.add(GuessTheNumberJButton);
        centerJPanel.add(RockPaperScissorJButton);
        centerJPanel.setBorder(new EmptyBorder(50,50,50,50));


        // Adding in JFrame
        jFrame.add(northJPanel,BorderLayout.NORTH);
        jFrame.add(centerJPanel,BorderLayout.CENTER);

        jFrame.setVisible(true);
    }    
}