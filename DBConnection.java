package myjdbc;

import java.sql.*;
import java.util.Scanner;

public class DBConnection {


 public static void main(String[] args) {
   System.out.println("Start in main  ");
   int x =0;
   String name="Rahul";
   String id="02TCS";
   String design="Sof Er";
   int salary =4000;
	try {
	   System.out.println("start in try Block ");
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   System.out.println("step1 Load the Driver class  ");
	   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	   System.out.println("step2 Get the Connection  "+conn);		
	   Statement stmt = conn.createStatement();
	   System.out.println("Step3 get object of stmt ");
	   //x =stmt.executeUpdate("create table employee2pm(name varchar(255) ,eid varchar(255),Design varchar(255),salary number)");
	   //System.out.println("The Table is Created Succesfully  "+x);
	  /* String insqry= "insert into employee2pm values('Ajay','05TCS','Sof .ER',20000)";
	   System.out.println("Insert Qry  "+insqry);
	   x = stmt.executeUpdate(insqry);
	   System.out.println("The  one records is insert  Succesfully  "+x);
	   insqry= "insert into employee2pm values('"+name+"','"+id+"','"+design+"',"+salary+")";
	   System.out.println("Insert Qry  "+insqry);
	  
	   x = stmt.executeUpdate(insqry);
	   System.out.println("The  one records is insert  Succesfully  "+x);
	   
	   Scanner sc = new Scanner(System.in);
	   System.out.print("How many want store Emp. records ");
	   int range = sc.nextInt();
	   for(int i =1;i <= range;i++) {
		   System.out.print("Enter a name of Empoyee ");
		   name = sc.next();
		   System.out.print("Enter a id of Empoyee (ex 02IMB) ");
		   id = sc.next();
		   System.out.print("Enter a designation of Empoyee ");
		   design = sc.next();
		   System.out.print("Enter a Salary of Empoyee ");
		   salary = sc.nextInt();
		   insqry= "insert into employee2pm values('"+name+"','"+id+"','"+design+"',"+salary+")";
		   System.out.println("Insert Qry  "+insqry);
		   x = stmt.executeUpdate(insqry);
		   System.out.println("The  one records is insert  Succesfully  "+x);
		   
	   }*/
	   ResultSet rs=  stmt.executeQuery("select * from employee2pm");
	   System.out.println("Step4 get the object of Result set ");
	   System.out.println("Name \t E_ID\t Design \t salary ");
	   while(rs.next()) {
		   System.out.print(rs.getString(1));
		   System.out.print("\t"+rs.getString(2));
		   System.out.print("\t"+rs.getString(3));
		   System.out.println("\t\t"+rs.getString(4));
	   }
	   
	   System.out.println("End of try Block ");
	   
	} 
	catch (ClassNotFoundException e) {
		System.err.println("Driver. class not found");
	   e.printStackTrace();
	} catch (SQLException e) {
		System.err.println("SQL Exc..."); 
		e.printStackTrace();
	}
	System.out.println("End of main Method ");
	}

}