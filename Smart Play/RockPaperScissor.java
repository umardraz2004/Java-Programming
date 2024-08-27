import java.util.*;
import javax.swing.JOptionPane;

public class RockPaperScissor {
    public RockPaperScissor() {

        JOptionPane.showMessageDialog(null, " -------- WELCOME TO ROCK PAPER SCISSORS GAME --------- ");
        
        String[] moves = { "Rock", "Paper", "Scissors" };
        String computer_move = moves[new Random().nextInt(moves.length)];
        boolean condition = true;
        int comp = 0, player = 0;
        int tie = 0;
        while (condition) {

            String player_move = null;
            try {

                player_move = (String) JOptionPane.showInputDialog("Oponent have choosen it's move \n       --- It's your turn now --- \n[1]. Rock \n[2]. Paper \n[3]. Scissors \n[4]. Quit \nSelect your move: ");
                
                if (player_move.equalsIgnoreCase("Rock") || player_move.equalsIgnoreCase("Paper") || player_move.equalsIgnoreCase("Scissors")) {
                    JOptionPane.showMessageDialog(null, "Oponent chooses : " + computer_move + "\nYou chooses : " + player_move);
                } else if (player_move.equalsIgnoreCase("Quit")) {
                    condition = false;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid entry! \nPlease enter available moves from list ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                e.printStackTrace();
            }

            if (player_move.equalsIgnoreCase(computer_move)) {
                JOptionPane.showMessageDialog(null, "It becomes draw in this Stage\n_________________________");
                tie++;
            }

            switch (player_move) {
                case "Rock":
                case "rock":
                    if (computer_move.equalsIgnoreCase("Paper")) {
                        JOptionPane.showMessageDialog(null, "Oponent wins this Stage \n_________________________");
                        comp++;
                    } else if (computer_move.equalsIgnoreCase("Scissors")) {
                        JOptionPane.showMessageDialog(null, "You win this Stage \n_________________________ ");
                        player++;
                    }
                    break;

                case "Paper":
                case "paper":
                    if (computer_move.equalsIgnoreCase("Rock")) {
                        JOptionPane.showMessageDialog(null, "You win this Stage \n_________________________ ");
                        player++;
                    } else if (computer_move.equalsIgnoreCase("Scissors")) {
                        JOptionPane.showMessageDialog(null, "Oponent wins this Stage \n_________________________ ");
                        comp++;
                    }
                    break;

                case "Scissors":
                case "scissors":
                    if (computer_move.equalsIgnoreCase("Rock")) {
                        JOptionPane.showMessageDialog(null, "Oponent wins this Stage \n_________________________");
                        comp++;
                    } else if (computer_move.equalsIgnoreCase("Paper")) {
                        JOptionPane.showMessageDialog(null, "You wins this Stage \n_________________________ ");
                        player++;
                    }
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "----- || OVERALL RESULT OF GAME || ------ \n  Computer wins " + comp + " Stages \n  You wins " + player + " Stages \n  Tie in " + tie + " Stages\n");

        if (comp > player) {
            JOptionPane.showMessageDialog(null, " ------ Oponent wins this Game, better luck next time! ----- ");
        } else if (player > comp) {
            JOptionPane.showMessageDialog(null, " ------- Congratulations! you wins this Game!! ------- ");
        } else {
            JOptionPane.showMessageDialog(null, " ------- It's tie in Game ------- ");
        }

        JOptionPane.showMessageDialog(null, "Thanks for playing this Game. Hopefully it would be enjoyable for you.");

        // Redirect to the menu after quitting
        new WelcomeToSmartPlay(); // Assuming you have a WelcomeToSmartPlay class for the main menu
    }
}
