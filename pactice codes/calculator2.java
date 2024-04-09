import java.util.Scanner;

public class calculator2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1,num2,operation,calValue = 0;
        System.out.print("Enter first number:");
        num1 = input.nextInt();
        System.out.print("Enter first number:");
        num2 = input.nextInt();
        System.out.print("Enter choice\n1. Addition (+)\n2. Subtraction (-)\n3. Multiplication (*)\n4. Division (/\n->");
        operation = input.nextInt();
        input.close();
        if(operation == 1){
            calValue = num1 + num2;
        } 
        else if(operation == 2) {
            calValue = num1 - num2;
        }
        else if(operation == 3) {
            calValue = num1 * num2;
        }
        else if(operation == 4) {
            calValue = num1 / num2;
        }
        else {
            System.out.println("Invalid input");
        }
        System.out.println("The result is:" + calValue);
    }
}
