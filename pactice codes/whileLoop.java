import java.util.Scanner;
public class whileLoop {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int min = 0;
		int max = 0;
		int num;
		int count = 0;
		int sum = 0;
		System.out.print("Enter any number or 0 to quit : ");
		num = Integer.parseInt(input.nextLine());
		min = max = num;
		while(true) {
			if(num == 0) {break;}
			sum+=num;
			count++;
			if(num > max) { max = num;}
			if(num < min) { min = num;}
			System.out.print("Enter any number or 0 to quit : ");
			num = Integer.parseInt(input.nextLine());
		}
        input.close();
		System.out.println("Sum = "+sum);
		System.out.println("Average = "+sum/count);
		System.out.println("Minimum = "+min);
		System.out.println("Maximum = "+max);
	}
}