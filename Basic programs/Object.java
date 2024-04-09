class Car {
    private String Name;
    private final String Model;

    public Car(String Name, String Model) {
        this.Name = Name;
        this.Model = Model;
    }

    public void display() {
        System.out.println("Name of Car is " + Name + " Of model " + Model);
    }
}

public class Object {
    public static void main(String[] args) {
        Car myCar = new Car("Sportage", "2023");
        myCar.display();
    }
}