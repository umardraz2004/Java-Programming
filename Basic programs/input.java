import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.println("Enter first value:");
        num1 = input.nextInt();
        System.out.println("Enter second value:");
        num2 = input.nextInt();
        System.out.println("The values you entered are " + num1 + " and " + num2);
    }
}
