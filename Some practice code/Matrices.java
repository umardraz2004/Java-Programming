import java.util.Arrays;
import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Matrices obj = new Matrices();
        Scanner userInput = new Scanner(System.in);
        int row, column;
        System.out.print("Enter size of matrix (form 0 x 0): ");
        row = userInput.nextInt();
        String symbol = userInput.next();
        column = userInput.nextInt();
        int[][] Matrix = new int[row][column];

        // Getting values
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter value: ");
                Matrix[i][j] = userInput.nextInt();
            }
        }
        obj.display(row, column, Matrix);

        // Matrix row sort
        System.out.println();
        System.out.println("Matrix row sort");
        for (int i = 0; i < row; i++) {
            Arrays.sort(Matrix[i]);
        }
        obj.display(row, column, Matrix);

        // Matrix column sort
        System.out.println();
        System.out.println("Matrix column sort");
        for (int i = 0; i < column; i++) {
            int[] tempArray = new int[row];
            for (int j = 0; j < row; j++) {
                tempArray[j] = Matrix[j][i];
            }
            Arrays.sort(tempArray);
            for (int k = 0; k < row; k++) {
                Matrix[k][i] = tempArray[k];
            }
        }
        obj.display(row, column, Matrix);

        // Matrix row sum
        System.out.println();
        System.out.println("Sum of row elements");
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < column; j++) {
                sum += Matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + " sum is " + sum);
        }

        // Matrix column sum
        System.out.println();
        System.out.println("Sum of column elements");
        for (int j = 0; j < column; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += Matrix[i][j];
            }
            System.out.println("Column " + (j + 1) + " sum is " + sum);
        }

        // Matrix sum
        System.out.println();
        System.out.println("Sum of all matrix elements");
        int sum = 0;
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                sum += Matrix[i][j];
            }
        }
        System.out.println("Sum is " + sum);

        // Matrix largest element in row
        System.out.println();
        System.out.println("Largest elements in each row");
        for (int i = 0; i < row; i++) {
            int max = 0;
            for (int j = 0; j < column; j++) {
                if (Matrix[i][j] > max)
                    max = Matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + " value is " + max);
        }

        // Matrix largest element in column
        System.out.println();
        System.out.println("Largest elements in each Column");
        for (int j = 0; j < column; j++) {
            int max = 0;
            for (int i = 0; i < row; i++) {
                if (Matrix[j][i] > max) {
                    max = Matrix[j][i];
                }
            }
            System.out.println("Column " + (j + 1) + " Value is " + max);
        }

    // Largest element in whole matrix
    // Matrix sum
    System.out.println();System.out.println("Max value of all matrix elements");

    int max = 0;
    for(int j = 0;j<column;j++)
    {
        for (int i = 0; i < row; i++) {
            if (Matrix[i][j] > max) {
                max = Matrix[i][j];
            }
        }
    }
    System.out.println("Max value is "+max);
    }

    // Display function
    void display(int row, int column, int matrix[][]) {
        System.out.println("Matrix display");
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
