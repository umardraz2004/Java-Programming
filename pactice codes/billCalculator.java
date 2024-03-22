import java.util.Scanner;

public class billCalculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        float product1 = 2.98f, product2 = 4.50f, product3 = 9.98f, product4 = 4.49f, product5 = 6.87f;
        int productNumber;
        double retailPrice, totalRetailPrice = 0;
        while (true) {
            System.out.println("Enter product number between 1-5 and 0 to exit");
            productNumber = userInput.nextInt();
            if(productNumber == 0) {
                break;
            }
            switch (productNumber) {
                case 1:
                    retailPrice = 2.98;
                    break;
                case 2:
                    retailPrice = 4.50;
                    break;
                case 3:
                    retailPrice = 9.98;
                    break;
                case 4:
                    retailPrice = 4.49;
                    break;
                case 5:
                    retailPrice = 6.87;
                    break;
                default:
                System.out.println("Invalid product number!");
                    continue;
            }
            System.out.print("Enter sold quantity: ");
            int quantitySold = userInput.nextInt();
            totalRetailPrice += retailPrice * quantitySold;
        }
        System.out.print("Total retail price is: " + totalRetailPrice);
        userInput.close();
    }
}
