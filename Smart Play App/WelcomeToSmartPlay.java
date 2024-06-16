import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeToSmartPlay extends JFrame {
    ImageIcon logo;
    JLabel mainHeading;
    JButton startSelection;
    JButton quickStart;
    JButton help;

    WelcomeToSmartPlay() {
        setTitle("Welcome to Smart play");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        logo = new ImageIcon("assets/SmartPlayIcon.png");
        setIconImage(logo.getImage());

        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(Color.BLACK);
        mainHeading = new JLabel("Smart Play");
        mainHeading.setFont(new Font("Arial Black", Font.PLAIN, 32));
        mainHeading.setForeground(Color.WHITE);
        headingPanel.add(mainHeading);
        add(headingPanel, BorderLayout.NORTH);

        JPanel body = new JPanel();
        body.setLayout(new GridLayout(3,1));

        JPanel startSelectionPanel = new JPanel();
        startSelectionPanel.setLayout(new BoxLayout(startSelectionPanel, BoxLayout.Y_AXIS));
        startSelectionPanel.add(Box.createVerticalGlue());
        startSelection = new JButton("Start Selection");
        startSelection.setFocusable(false);
        startSelection.setPreferredSize(new Dimension(60,30));
        startSelection.setBackground(Color.decode("#009879"));
        startSelection.setForeground(Color.WHITE);
        startSelection.setBorder(BorderFactory.createEmptyBorder(15,5,15,5));
        startSelection.setAlignmentX(CENTER_ALIGNMENT);
        startSelection.setFont(new Font("Arial Black",Font.PLAIN,18));
        startSelection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SelectGame();
            }
        });
        startSelectionPanel.add(startSelection);

        JPanel quickStartPanel = new JPanel();
        quickStart = new JButton("Quick Start");
        quickStartPanel.setBorder(BorderFactory.createEmptyBorder(16,0,0,0));
        quickStart.setFocusable(false);
        quickStart.setPreferredSize(new Dimension(125,30));
        quickStart.setBackground(Color.decode("#088fa1"));
        quickStart.setForeground(Color.white);
        quickStart.setBorder(BorderFactory.createEmptyBorder(15,5,15,5));
        quickStart.setFont(new Font("Arial Black",Font.PLAIN,18));
        quickStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomNumber = random.nextInt(4);
                System.out.println("Random: "+randomNumber);
                dispose();
                if (randomNumber == 0) {
                    new TicTacToe();
                }
                else if (randomNumber == 1) {
                    new WordSearch();
                }
                else if (randomNumber == 2) {
                    new GuessTheNumber();
                }
                else{
                    new RockPaperScissor();
                }
            }
        });
        quickStartPanel.add(quickStart);

        JPanel helpPanel = new JPanel();
        help = new JButton("Help");
        help.setFocusable(false);
        help.setPreferredSize(new Dimension(115,30));
        help.setBackground(Color.decode("#0C0080"));
        help.setForeground(Color.WHITE);
        help.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));
        help.setFont(new Font("Arial Black",Font.PLAIN,18));
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Help();
            }
        });
        helpPanel.add(help);

        body.add(startSelectionPanel);
        body.add(quickStartPanel);
        body.add(helpPanel);
        add(body, BorderLayout.CENTER);

        this.setVisible(true);
    }
}