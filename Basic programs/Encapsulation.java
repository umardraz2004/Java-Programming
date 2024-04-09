class Student {
    private String Name;
    private int Id;

    public Student() {
        Name = "";
        Id = 0;
    }

    public void setdata(String Name, int Id) {
        this.Name = Name;
        this.Id = Id;
        System.out.println("Data setted!");
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public void display() {
        System.out.println("Name of Student is :" + Name);
        System.out.println("Student id is :" + Id);
    }

}

public class Encapsulation {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setdata("Umar Draz",108);
        System.out.println("\nGet data method");
        System.out.println("Student name is:" + s1.getName());
        System.out.println("Student id is:" + s1.getId());
        System.out.println("\nDisplay method");
        s1.display();
    }
}