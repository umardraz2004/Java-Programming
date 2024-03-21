import java.util.Scanner;

public class switchStatment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1,num2,cal;
        char opt;
        System.out.println("Enter first value:");
        num1 = input.nextInt();
        System.out.println("Enter second value:");
        num2 = input.nextInt();
        System.out.println("Enter operation you want to perform from these (+.-.*,/,%):");
        opt = input.next().charAt(0);
        switch (opt) {
            case '+':
                cal = num1 + num2;
                System.out.println("The sum of values is:" + cal);
                break;
            case '-':
                cal = num1 - num2;
                System.out.println("The sub of values is:" + cal);
                break;
            case '*':
                cal = num1 * num2;
                System.out.println("The mul of values is:" + cal);
                break;
            case '/':
                cal = num1 / num2;
                System.out.println("The div of values is:" + cal);
                break;
            case '%':
                cal = num1 % num2;
                System.out.println("The mod of values is:" + cal);
                break;
            default:
            System.out.println("Invalid operation");
                break;
        }
    }
}
