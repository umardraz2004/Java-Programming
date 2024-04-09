import java.util.Scanner;

public class digitSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num ;
        int temp ,sum=0;
        System.out.print("Enter a number:");
        num = input.nextLine();
        input.close();
        for(int i=0;i<num.length();i++){
            temp = Character.getNumericValue(num.charAt(i));
            sum += temp;
        }
        System.out.println("The sum is:" + sum);
    }
}
