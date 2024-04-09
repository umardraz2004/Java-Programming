import java.util.Scanner;

public class barChart {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[5];
        for(int i = 0; i<5; i++) {
            System.out.print("Enter number:");
            num[i] = input.nextInt();
        }
        input.close();
        for(int j=0; j<5; j++) {
            for(int k=0; k<num[j];k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
