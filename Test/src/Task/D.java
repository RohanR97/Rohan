package Task;

public class D extends C{
	public B m7()
	{
    m5();
    m6();
	System.out.println(" B ");
	return new B();
	}
	public void m8()
	{
	System.out.println("m-8 method");
	}
	public D()
	{
		
	System.out.println(" D ");
	}
	public D(float a)
	{
		this.m7();
		System.out.println("Float type");
		this.m8();
	}
	}


