import javax.swing.JOptionPane;
public class prime {

	public static void main(String[] args) {
		String userInput;
		int num;
		boolean prime = true;
		userInput = JOptionPane.showInputDialog("Enter any Number");
		num = Integer.parseInt(userInput);
		for(int i = 3; i<=num/2; i++) {
			if(num % i == 0) {
				prime = false;
				break;
			}
		}
		if(prime)
			System.out.println(num + " is prime number");
		else
			System.out.println(num + " is not prime number");
		
	}
}