public class Polymorphism {
	
	String name;
	int age;
	String email;
	
	public void setData(String name, int age, String email)
	{
		this.name=name;
		this.age=age;
		this.email=email;
	}
	
	public void display()
	{
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
	}
	
	public static void main(String[] args) {
		Polymorphism s1=new Polymorphism();
		s1.setData("Prahlad", 21, "aaB@abc.xyz");
		s1.display();
		Polymorphism s2=new Polymorphism();
		s2.setData("AAAA", 99,"Baa@abc.xyz");
		s2.display();
	}
}