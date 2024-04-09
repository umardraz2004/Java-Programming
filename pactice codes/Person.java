public class Person {
    private String name;
    private int age;
    private char gender;
    private String occupation;
    private boolean canCook;

    // Default constructor
    public Person() {
        this.name = null;
        this.age = 0;
        this.gender = 'm'; // Default to male
        this.occupation = "student";
        this.canCook = false; // Default to no
    }

    // Parameterized constructor
    public Person(String name, int age, char gender, String occupation, boolean canCook) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.canCook = canCook;
    }

    // Copy constructor
    public Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
        this.gender = otherPerson.gender;
        this.occupation = otherPerson.occupation;
        this.canCook = otherPerson.canCook;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return gender == 'm';
    }

    public boolean isFemale() {
        return gender == 'f';
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean canCook() {
        return canCook;
    }

    public static void main(String[] args) {
        // Create objects using different constructors
        Person person1 = new Person();
        Person person2 = new Person("John", 25, 'm', "Engineer", true);
        Person person3 = new Person(person2); // Using copy constructor

        // Accessing methods of each object and printing results
        System.out.println("Person 1:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Male: " + person1.isMale());
        System.out.println("Female: " + person1.isFemale());
        System.out.println("Occupation: " + person1.getOccupation());
        System.out.println("Can cook: " + person1.canCook());

        System.out.println("\nPerson 2:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Male: " + person2.isMale());
        System.out.println("Female: " + person2.isFemale());
        System.out.println("Occupation: " + person2.getOccupation());
        System.out.println("Can cook: " + person2.canCook());

        System.out.println("\nPerson 3 (copy of Person 2):");
        System.out.println("Name: " + person3.getName());
        System.out.println("Age: " + person3.getAge());
        System.out.println("Male: " + person3.isMale());
        System.out.println("Female: " + person3.isFemale());
        System.out.println("Occupation: " + person3.getOccupation());
        System.out.println("Can cook: " + person3.canCook());
    }
}
