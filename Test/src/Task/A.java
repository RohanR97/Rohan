package Task;

public class A {
	
	
	public void m1()
	{
		
	System.out.println("m-1 method");
	}
	public void m2()
	{
System.out.println("m-2 method");
	}
	public A()
	{
		this(30);
	System.out.println("A constructor");
	}
	public A(int a)
	{
		this.m2();
		
	System.out.println("A-int");
	}
	}

