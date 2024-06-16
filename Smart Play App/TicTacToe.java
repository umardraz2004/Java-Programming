import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

class TicTacToe {
    int width = 1300;
    int height = 860;
    JFrame frame = new JFrame();
    JPanel headJPanel = new JPanel();
    JLabel headJLabel = new JLabel();

    JPanel boardPanel = new JPanel();
    JPanel gridPanel = new JPanel();
    JPanel scorPanel = new JPanel();

    JButton resetButton = new JButton();
    JButton exitButton = new JButton();
    JButton menuButton = new JButton();
    JButton[][] board = new JButton[3][3];

    JLabel scoreBoard = new JLabel();
    JLabel Xlabel = new JLabel();
    JLabel Olabel = new JLabel();

    String playerX = "X";
    String playerO = "O";
    int turns = 0;
    boolean gameOver = false;

    int Xturns = 0;
    int Oturns = 0;

    String currentPlayer = playerX;

    public TicTacToe() {
        try {
            frame.setTitle("Tic-Tac-Toe");
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());
            ImageIcon icon = new ImageIcon("assets/TicTacToeIcon.png");
            frame.setIconImage(icon.getImage());

            headJLabel.setText("Tic Tac Toe");
            headJLabel.setHorizontalTextPosition(JLabel.CENTER);
            headJLabel.setForeground(Color.WHITE);
            headJLabel.setFont(new Font("Sans Serif", Font.BOLD, 32));

            headJPanel.setBackground(Color.BLACK);
            headJPanel.setPreferredSize(new Dimension(100, 50));
            headJPanel.add(headJLabel);

            frame.add(headJPanel, BorderLayout.NORTH);
            boardPanel.setLayout(null);

            gridPanel.setLayout(new GridLayout(3, 3, 10, 10));
            gridPanel.setBounds(50, 80, 590, 600);

            scorPanel.setLayout(null);
            scorPanel.setBounds(800, 200, 450, 300);
            scorPanel.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
            scorPanel.setBorder(BorderFactory.createEtchedBorder());
            scorPanel.setBackground(Color.LIGHT_GRAY);

            scoreBoard.setText("Score Board");
            scoreBoard.setBounds(130, 10, 400, 50);
            scoreBoard.setHorizontalTextPosition(JLabel.CENTER);
            scoreBoard.setForeground(Color.BLACK);
            scoreBoard.setFont(new Font("Sans Serif", Font.BOLD, 35));

            Xlabel.setText("Player X : ---");
            Xlabel.setForeground(Color.BLACK);
            Xlabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
            Xlabel.setBounds(20, 70, 400, 80);

            Olabel.setText("Player O : ---");
            Olabel.setForeground(Color.BLACK);
            Olabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
            Olabel.setBounds(20, 170, 400, 80);

            scorPanel.add(scoreBoard);
            scorPanel.add(Xlabel);
            scorPanel.add(Olabel);

            // menu button
            menuButton.setText("MENU");
            menuButton.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            menuButton.setForeground(Color.WHITE);
            menuButton.setFont(new Font("Sans Serif", Font.BOLD, 30));
            menuButton.setBackground(Color.decode("#088fa1"));
            menuButton.setBounds(940, 700, 180, 60);
            menuButton.setFocusable(false);
            menuButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new WelcomeToSmartPlay();
                }
            });

            // reset button
            resetButton.setText("RESET");
            resetButton.setForeground(Color.white);
            resetButton.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            resetButton.setFont(new Font("Sans Serif", Font.BOLD, 23));
            resetButton.setBackground(Color.decode("#0944db"));
            resetButton.setBounds(840, 600, 180, 70);
            resetButton.setFocusable(false);

            // exit button
            exitButton.setText("EXIT");
            exitButton.setForeground(Color.white);
            exitButton.setBackground(Color.decode("#d15a04"));
            exitButton.setBorder(new EtchedBorder(EtchedBorder.RAISED));
            exitButton.setFont(new Font("Sans Serif", Font.BOLD, 23));
            exitButton.setFocusable(false);
            exitButton.setBounds(1040, 600, 180, 70);

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    JButton cellButton = new JButton();
                    board[r][c] = cellButton;
                    gridPanel.add(cellButton);

                    cellButton.setBackground(Color.decode("#525252"));
                    cellButton.setFocusable(false);
                    cellButton.setFont(new Font("Sans Serif", Font.BOLD, 55));
                    cellButton.setForeground(Color.WHITE);

                    cellButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                if (gameOver) {
                                    return;
                                }
                                JButton tile = (JButton) e.getSource();
                                if (tile.getText().equals("")) {
                                    tile.setText(currentPlayer);
                                    turns++;
                                    winnerSelection();

                                    if (!gameOver) {
                                        currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                        headJLabel.setText(currentPlayer + "'s turn");
                                    }
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            }

            resetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    try {
                        turns = 0;
                        if (a.getSource() == resetButton) {
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    board[i][j].setText("");
                                    board[i][j].setForeground(Color.WHITE);
                                    board[i][j].setBackground(Color.DARK_GRAY);
                                    headJLabel.setText(currentPlayer + "'s turn");
                                    gameOver = false;
                                }
                            }
                        }
                        winnerSelection();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (e.getSource() == exitButton) {
                            System.exit(0);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            boardPanel.add(resetButton);
            boardPanel.add(exitButton);

            boardPanel.add(gridPanel);
            boardPanel.add(scorPanel);
            boardPanel.add(menuButton);
            frame.add(boardPanel);
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void winnerSelection() {
        try {
            // horizontally checking
            for (int r = 0; r < 3; r++) {
                if (board[r][0].getText().equals("")) {
                    continue;
                }

                if (board[r][0].getText().equals(board[r][1].getText()) && board[r][1].getText().equals(board[r][2].getText())) {
                    if (board[r][0].getText().equals("X") && board[r][1].getText().equals("X") && board[r][2].getText().equals("X")) {
                        Xturns++;
                    } else if (board[r][0].getText().equals("O") && board[r][1].getText().equals("O") && board[r][2].getText().equals("O")) {
                        Oturns++;
                    }

                    for (int i = 0; i < 3; i++) {
                        setWinner(board[r][i]);
                    }
                    gameOver = true;
                    return;
                }
            }

            // vertically checking
            for (int c = 0; c < 3; c++) {
                if (board[0][c].getText().equals("")) {
                    continue;
                }

                if (board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText())) {
                    if (board[0][c].getText().equals("X") && board[1][c].getText().equals("X") && board[2][c].getText().equals("X")) {
                        Xturns++;
                    } else if (board[0][c].getText().equals("O") && board[1][c].getText().equals("O") && board[2][c].getText().equals("O")) {
                        Oturns++;
                    }

                    for (int i = 0; i < 3; i++) {
                        setWinner(board[i][c]);
                    }
                    gameOver = true;
                    return;
                }
            }

            // diagonally
            if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && !board[0][0].getText().equals("")) {
                if (board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")) {
                    Xturns++;
                } else if (board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")) {
                    Oturns++;
                }

                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][i]);
                }
                gameOver = true;
                return;
            }

            // anti-diagonally
            if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && !board[0][2].getText().equals("")) {
                if (board[0][2].getText().equals("X") && board[1][1].getText().equals("X") && board[2][0].getText().equals("X")) {
                    Xturns++;
                } else if (board[0][2].getText().equals("O") && board[1][1].getText().equals("O") && board[2][0].getText().equals("O")) {
                    Oturns++;
                }

                setWinner(board[0][2]);
                setWinner(board[1][1]);
                setWinner(board[2][0]);
                gameOver = true;
                return;
            }

            // Tie checking
            if (turns == 9) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        setTie(board[r][c]);
                    }
                }
                gameOver = true;
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void setWinner(JButton button) {
        try {
            button.setForeground(Color.decode("#069145"));
            Xlabel.setText("PlayerX :    " + Xturns);
            Olabel.setText("PlayerO :    " + Oturns);
            button.setBackground(Color.LIGHT_GRAY);
            headJLabel.setText("Player " + currentPlayer + " is winner");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void setTie(JButton button) {
        try {
            Xlabel.setText("PlayerX :    " + Xturns);
            Olabel.setText("PlayerO :    " + Oturns);
            button.setForeground(Color.RED);
            headJLabel.setText("It's becomes Tie!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
