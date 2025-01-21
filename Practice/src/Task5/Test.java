package Task5;
import java.util.*;
public class Test {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the sentence:");
	String s= sc.nextLine();
	char[] charArray= s.toCharArray();
	String[] words=s.split(" ");
	for(int i=0; i<=words.length;i++)
	{
		for(int j=i+1; j<words.length;j++)
		{
			if(words[i].equals(words[j]))
			{
			System.out.println("Duplicate Elements:" + words[i]);	
			}
		}
	}
	
	
}
}
