package com.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.service.Requirements;
import java.sql.CallableStatement;

public class Data implements Requirements{

	@Override
	public void createTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall(("{call createTable()}"));
		cs.execute();
		
		System.out.println("Table created.");
	}

	@Override
	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		CallableStatement cs=con.prepareCall("{call insertData(?,?,?,?,?,?,?)}");
		System.out.println("Enter the no of Players List to add:");
		int player=sc.nextInt();
		for(int i=1; i<=player; i++)
		{
		System.out.println("Enter rankId:");
		int rank=sc.nextInt();
		System.out.println("Enter Name:");
		String name= sc.next();
		System.out.println("Enter Country:");
		String country=sc.next();
		System.out.println("Enter Sport:");
		String sport=sc.next();
		System.out.println("Enter No.Of Records:");
		int records=sc.nextInt();
		System.out.println("Enter No.Of Trophies:");
		int trophies=sc.nextInt();
		System.out.println("Enter Total Income:");
		double income=sc.nextDouble();
		
		cs.setInt(1,rank);
		cs.setString(2,name);
		cs.setString(3,country);
		cs.setString(4,sport);
		cs.setInt(5,records);
		cs.setInt(6,trophies);
		cs.setDouble(7,income);
		cs.execute();
		}
		System.out.println("Inserted Data");
	}

	@Override
	public void viewSingleData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the player to view:");
		int view= sc.nextInt();
		CallableStatement cs= con.prepareCall("{call viewSingleData(?)}");
		
		cs.setInt(1, view);
		ResultSet rs= cs.executeQuery();
		System.out.println("Data viewed successfully.");
		
		while(rs.next())
		{
			System.out.println(rs.getInt("rankId"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("country"));
			System.out.println(rs.getString("sport"));
			System.out.println(rs.getInt("noOfRecords"));
			System.out.println(rs.getInt("noOfTrophies"));
			System.out.println(rs.getInt("TotalIncome"));
		}
		
		
	}
		
	

	@Override
	public void viewAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs= con.prepareCall("{call viewAllData()}");
		ResultSet rs= cs.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("rankId"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("country"));
			System.out.println(rs.getString("sport"));
			System.out.println(rs.getInt("noOfRecords"));
			System.out.println(rs.getInt("noOfTrophies"));
			System.out.println(rs.getInt("TotalIncome"));
		}
		
	}

	@Override
	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the player to update:");
		int no= sc.nextInt();
		System.out.println("Which field would you like to updtae:");
		System.out.println("1. Name");
        System.out.println("2. Country");
        System.out.println("3. Sport");
        System.out.println("4. noOfRecords");
        System.out.println("5. noOfTrophies");
        System.out.println("6. Total Income");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        
        switch(ch)
        {
        case 1:
        {
        	System.out.println("Enter New Name:");
        	String name= sc.next();
        	CallableStatement cs= con.prepareCall("{call updateName(?,?)}");
    		cs.setInt(1, no);
    		cs.setString(2, name);
    		cs.execute();
    		System.out.println("Name updated successfully");
    	     break;
        }
        case 2:
        {
        	System.out.println("Enter New Country:");
        	String country= sc.next();
        	CallableStatement cs= con.prepareCall("{call updateCountry(?,?)}");
    		cs.setInt(1, no);
    		cs.setString(2, country);
    		cs.execute();
    		System.out.println("Country updated successfully");
    	     break;	
        }
        case 3:
        {
        	System.out.println("Enter New Sport:");
        	String sport= sc.next();
        	CallableStatement cs= con.prepareCall("{call updateSport(?,?)}");
    		cs.setInt(1, no);
    		cs.setString(2, sport);
    		cs.execute();
    		System.out.println("Sport updated successfully");
    	     break;		
        }
        case 4:
        {
        	System.out.println("Enter New Records:");
        	int records= sc.nextInt();
        	CallableStatement cs= con.prepareCall("{call updatenoOfRecords(?,?)}");
    		cs.setInt(1, no);
    		cs.setInt(2, records);
    		cs.execute();
    		System.out.println("Records updated successfully");
    		break;
        }
        case 5:
        {
        	System.out.println("Enter New Trophies:");
        	int trophy= sc.nextInt();
        	CallableStatement cs= con.prepareCall("{call updatenoOfTrophies(?,?)}");
    		cs.setInt(1, no);
    		cs.setInt(2, trophy);
    		cs.execute();
    		System.out.println("Trophies updated successfully");
    		break;
        }
        case 6:
        {
        	System.out.println("Enter New Income:");
        	double income= sc.nextDouble();
        	CallableStatement cs= con.prepareCall("{call updateIncome(?,?)}");
    		cs.setInt(1, no);
    		cs.setDouble(2, income);
    		cs.execute();
    		System.out.println("Income updated successfully");
    		break;
        }
        	
        }
		
	}

	@Override
	public void deleteSingleData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the player to delete:");
		int delete= sc.nextInt();
		CallableStatement cs= con.prepareCall("{call deleteSingleData(?)}");
		cs.setInt(1, delete);
		int rs= cs.executeUpdate();
		System.out.println("Data deleted");
		
	}

	@Override
	public void deleteAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall("{call deleteAllData()}");
		int rs= cs.executeUpdate();
	   System.out.println("All data deleted");
		
	}

	@Override
	public void deleteTable() throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs= con.prepareCall("{call deleteTable()}");
		int rs=cs.executeUpdate();
		System.out.println("Table deleted successfully.");
	}

}
