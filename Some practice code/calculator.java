import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int num1, num2;
        float eval;
        String op;
        System.out.println("Enter expression:");
        num1 = userInput.nextInt();
        op = userInput.next();
        num2 = userInput.nextInt();
        userInput.close();
        if(op.equals("+")) {
            eval = num1 + num2;
            System.out.println(num1 + op + num2 + " = " + eval);
        } 
        else if(op.equals("-")) {
            eval = num1 - num2;
            System.out.println(num1 + op + num2 + " = " + eval);
        }
        else if(op.equals("*")) {
            eval = num1 * num2;
            System.out.println(num1 + op + num2 + " = " + eval);
        }
        else if(op.equals("/")) {
            eval = (float)num1 / num2;
            System.out.println(num1 + op + num2 + " = " + eval);
        }
        else {
            System.out.println("Invalid");
        }
    }
}