class Individual {
    private String Name ;
    private int CNIC  ;

    public Individual() {
        Name = "";
        CNIC = 0;
    }

    public Individual(String Name,int CNIC) {
        this.Name = Name;
        this.CNIC = CNIC;
    }

    public void display() {
        System.out.println("Name: " + Name + "\nCNIC " + CNIC  );
    }
}

class Student extends Individual {
    private int classNumber;
    
    public Student(String Name, int CNIC ,int classNumber ){
        super(Name,CNIC);
        this.classNumber = classNumber;
    }

    public void display() {
        super.display();
        System.out.println("Student Class is " + classNumber);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Student s1 = new Student("Umar", 108, 5);
        s1.display();
    }
}
