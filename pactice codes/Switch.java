import java.util.Scanner;
public class Switch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		String name;
		String age;
		System.out.println("What you want to do?");
		System.out.println("1. Print your name");
		System.out.println("2. Print your age");
		System.out.println("3. Exit");
		choice = Integer.parseInt(input.nextLine());
		switch(choice) {
			case 1:
			System.out.print("Enter you name: ");
			name = input.nextLine();
			System.out.println("Welcome "+name);
			input.close();
			break;
			case 2:
			System.out.print("Enter you age: ");
			age = input.nextLine();
			System.out.println("You are "+age);
			input.close();
			break;
			case 3:
			System.exit(0);
		}
	}
}