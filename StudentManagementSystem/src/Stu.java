import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
	
	String name;
	int rollNo;
	String grade;
	
	public Student(String name, int rollNo, String grade)
	{
		this.name=name;
		this.rollNo=rollNo;
		this.grade=grade;
	}

	public String getName() {
		return name;
	}


	public int getRollNo() {
		return rollNo;
	}


	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", grade=" + grade + "]";
	}

}

class StudentManagementSystem {
	
	private List<Student> students;
	
	public StudentManagementSystem()
	{
		students = new ArrayList<>();
		
	}
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public void removeStudent(int rollNo)
	{
		students.removeIf(student -> student.getRollNo()==rollNo);
	}
	
	public Student searchStudent(int rollNo)
	{
		for(Student student : students)
		{
			if(student.getRollNo()==rollNo)
			{
				return student;
			}
		}
		return null;
	}
	
	public void displayAllStudents()
	{
		for(Student student : students)
		{
			System.out.println(student);
		}
	}
}

public class Stu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManagementSystem system = new StudentManagementSystem();
		
		while(true)
		{
			System.out.println("1. Add student");
			System.out.println("2. Remove student");
			System.out.println("3. search student");
			System.out.println("4. Display all students");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice");
			int ch = scan.nextInt();
					
			switch(ch)
			{
			case 1: 
				System.out.println("Enter name");
				scan.nextLine();
				String name=scan.nextLine();
						
				System.out.println("Enter rollNo");
				int rollNo=scan.nextInt();
				
				System.out.println("Enter grade");
				scan.nextLine();
				String grade=scan.nextLine();
				
				Student student = new Student(name, rollNo, grade);
				system.addStudent(student);
				break;
				
			case 2:
				System.out.println("Enter rollNo to remove:");
				int rollNoToRemove=scan.nextInt();
				system.removeStudent(rollNoToRemove);
				break;
				
			case 3:
				System.out.println("Enter roll no to search:");
				int rollNoToSearch=scan.nextInt();
				Student foundStudent = system.searchStudent(rollNoToSearch);
				if(foundStudent != null)
				{
					System.out.println("Student found:" +foundStudent);
				}
				else
				{
					System.out.println("Student not found....");
				}
				break;
				
			case 4:
				system.displayAllStudents();
				break;
				
			case 5:
				System.out.println("Exit....");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice.");
			}
		}
		
	}

}
