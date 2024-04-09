import java.util.Scanner;
class Pizza {
	static Scanner consoleInput = new Scanner(System.in);
	int size; 
	int price;
	int thickness;
	String topping;
	void SetSize() {
		System.out.print("Enter size of pizza: ");
		size = Integer.parseInt(consoleInput.nextLine()); 
	}
	void SetThickness() {
		System.out.print("Enter thickness of pizza: ");
		thickness = Integer.parseInt(consoleInput.nextLine()); 
	}
	void SetTopping() {
		System.out.print("Enter toppings of pizza: ");
		topping = consoleInput.nextLine(); 
	}
	void SetPrize() {
		System.out.print("Enter price of pizza: ");
		price = Integer.parseInt(consoleInput.nextLine()); 
	}
	public Pizza() {
		SetSize();
		SetThickness();
		SetTopping();
		SetPrize();
	}
	public Pizza(int size, int thickness, String topping, int price) {
		this.size = size;
		this.thickness = thickness;
		this.topping = topping;
		this.price = price;
	}
	public Pizza(Pizza obj) {
		size = obj.size;
		thickness = obj.thickness;
		topping = obj.topping;
		price = obj.price;
	}
	public void display() {
		System.out.println("The order pizza detail are:");
		System.out.println("Size: "+size);
		System.out.println("Thickness: "+thickness);
		System.out.println("Toppings: "+topping);
		System.out.println("Price: "+price);
	}
}

public class ConstructorOver {
	public static void main(String[] args) {
		Pizza p1 = new Pizza();
		Pizza p2 = new Pizza(14,2,"chicken",1500);
		Pizza p3 = new Pizza(p2);
		System.out.println("Pizza 1");
		p1.display();
		System.out.println("\n\nPizza 2");
		p2.display();
		System.out.println("\n\nPizza 3");
		p3.display();
	}
}
