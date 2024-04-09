import java.util.Scanner;

public class Student {
    private int Roll_no;
    private String name;
    private int CS_grad;
    private int Cal_grad;
    private float gpa;
    public void IN_Data() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Roll Number: ");
        Roll_no = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        
        System.out.print("Enter CS Graduation Year: ");
        CS_grad = scanner.nextInt();
        
        System.out.print("Enter Cal Graduation Year: ");
        Cal_grad = scanner.nextInt();
        System.out.print("Enter GPA: ");
        gpa = scanner.nextFloat();
        
        scanner.close();
    }
    public void CAL_GPA() {
        System.out.println("GPA of Student: " + gpa);
    }
    
    public static void main(String[] args) {
        Student Stud_Obj = new Student(); 
        Stud_Obj.IN_Data(); 
        Stud_Obj.CAL_GPA(); 
    }
}
