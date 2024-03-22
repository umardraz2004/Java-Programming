import java.util.Arrays;
import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Matrices obj = new Matrices();
        Scanner userInput = new Scanner(System.in);
        int row, column;
        System.out.print("Enter size of matrix (form 0 x 0): ");
        row = userInput.nextInt();
        String op = userInput.next();
        column = userInput.nextInt();
        int[][] Matrix = new int[row][column];
        // Getting values
        obj.inputMatrixValues(row, column, Matrix, userInput);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Sort rows");
            System.out.println("2. Sort columns");
            System.out.println("3. Calculate row sums");
            System.out.println("4. Calculate column sums");
            System.out.println("5. Calculate sum of all matrix elements");
            System.out.println("6. Find largest element in each row");
            System.out.println("7. Find largest element in each column");
            System.out.println("8. Find largest element in the whole matrix");
            System.out.println("9. Exit");

            int choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    obj.sortRows(row, column, Matrix);
                    obj.display(row, column, Matrix);
                    break;
                case 2:
                    obj.sortColumns(row, column, Matrix);
                    obj.display(row, column, Matrix);
                    break;
                case 3:
                    obj.calculateAndDisplayRowSums(row, column, Matrix);
                    break;
                case 4:
                    obj.calculateAndDisplayColumnSums(row, column, Matrix);
                    break;
                case 5:
                    obj.calculateAndDisplayMatrixSum(row, column, Matrix);
                    break;
                case 6:
                    obj.findAndDisplayLargestInRows(row, column, Matrix);
                    break;
                case 7:
                    obj.findAndDisplayLargestInColumns(row, column, Matrix);
                    break;
                case 8:
                    obj.findAndDisplayMaxValue(row, column, Matrix);
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    // Function to input values into the matrix
    void inputMatrixValues(int row, int column, int matrix[][], Scanner userInput) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter value: ");
                matrix[i][j] = userInput.nextInt();
            }
        }
    }

    // Function to sort rows of the matrix
    void sortRows(int row, int column, int matrix[][]) {
        for (int i = 0; i < row; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    // Function to sort columns of the matrix
    void sortColumns(int row, int column, int matrix[][]) {
        for (int i = 0; i < column; i++) {
            int[] tempArray = new int[row];
            for (int j = 0; j < row; j++) {
                tempArray[j] = matrix[j][i];
            }
            Arrays.sort(tempArray);
            for (int k = 0; k < row; k++) {
                matrix[k][i] = tempArray[k];
            }
        }
    }

    // Function to calculate and display row sums
    void calculateAndDisplayRowSums(int row, int column, int matrix[][]) {
        System.out.println("\nSum of row elements");
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + " sum is " + sum);
        }
    }

    // Function to calculate and display column sums
    void calculateAndDisplayColumnSums(int row, int column, int matrix[][]) {
        System.out.println("\nSum of column elements");
        for (int j = 0; j < column; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += matrix[i][j];
            }
            System.out.println("Column " + (j + 1) + " sum is " + sum);
        }
    }

    // Function to calculate and display sum of all matrix elements
    void calculateAndDisplayMatrixSum(int row, int column, int matrix[][]) {
        System.out.println("\nSum of all matrix elements");
        int sum = 0;
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Sum is " + sum);
    }

    // Function to find and display largest element in each row
    void findAndDisplayLargestInRows(int row, int column, int matrix[][]) {
        System.out.println("\nLargest elements in each row");
        for (int i = 0; i < row; i++) {
            int max = 0;
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + " value is " + max);
        }
    }

    // Function to find and display largest element in each column
    void findAndDisplayLargestInColumns(int row, int column, int matrix[][]) {
        System.out.println("\nLargest elements in each Column");
        for (int j = 0; j < column; j++) {
            int max = 0;
            for (int i = 0; i < row; i++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            System.out.println("Column " + (j + 1) + " Value is " + max);
        }
    }

    // Function to find and display largest element in the whole matrix
    void findAndDisplayMaxValue(int row, int column, int matrix[][]) {
        System.out.println("\nMax value of all matrix elements");
        int max = 0;
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max value is " + max);
    }

    // Function to display the matrix
    void display(int row, int column, int matrix[][]) {
        System.out.println("\nMatrix display");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}