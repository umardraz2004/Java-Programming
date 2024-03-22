public class pattren {
    public static void main(String[] args) {
        int lines = 10;
        for (int i = 1; i <= lines; i++) {            
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Print spaces
            for (int l = 0; l <= 2 * (lines - i); l++) {
                System.out.print(" ");
            }
            // Print stars
            for (int m = 1; m <= i; m++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}