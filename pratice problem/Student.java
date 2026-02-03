
class Student
{ int id;
	String name;
	int age;
	void displayDetails()
	{	
		String status ="Active";
		System.out.println("id" +id);
		System.out.println("name" +name);
		System.out.println("age" +age);
	}
	
		public static void main(String[]args){
		Student S1 = new Student ();
		S1.displayDetails();
		}
}
	