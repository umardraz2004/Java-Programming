class Student {
	private int age;
	private String name;
	private String stdClass;
	public static int stdCount = 0;
	public Student(String name, int age, String stdClass) {
		this.name = name;
		this.age = age;
		this.stdClass = stdClass;
		stdCount++;
	}
	public void DisplayRecord() {
		System.out.print("Student: ");
		System.out.print(name+", ");
		System.out.print(age+", ");
		System.out.println(stdClass);
	}
}

public class staticAndNon {
	public static void main(String[] args) {
		Student s1 = new Student("Ali",19,"BSCS");
		Student s2 = new Student("Basil",20,"BSSE");
		System.out.println("S1 detail");
		s1.DisplayRecord();
		System.out.println("S2 detail");
		s2.DisplayRecord();
		System.out.println("Total number of student:"+Student.stdCount);
		System.out.println("Total number of student:"+s1.stdCount);
		System.out.println("Total number of student:"+s2.stdCount);
		Student s3 = new Student("Ahmad Ali",20,"BBA");
		System.out.println("S3 detail");
		s3.DisplayRecord();
		System.out.println("Total number of student: "+Student.stdCount);
		System.out.println("Total number of student: "+s1.stdCount);
		System.out.println("Total number of student: "+s2.stdCount);
		System.out.println("Total number of student: "+s3.stdCount);
	}
}
