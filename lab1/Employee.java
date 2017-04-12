public class Employee {
String name;
int salary;


public void (String name, int salary)
{
	this.name=name;
	this.salary=salary;
	}

public void setData(String name, int salary)
{
	this.name=name;
	this.salary=salary;
}

public void display()
{
	System.out.println(name);
	System.out.println(salary);
}


public static void main(String[] args) {
	Employee s1=new Employee();
	s1.setData("Prahlad", 5000);
	
}
}
	
