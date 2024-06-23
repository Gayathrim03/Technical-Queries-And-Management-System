package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.Admin;
import controller.Student;
import controller.Technician;
public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
//          boolean m = true;
          System.out.println("==========================================================\n"
        		  +    "       Welcome To Technical Queries Management System     \n"
        		  +    "==========================================================\n");
//		while(m) {
        System.out.println("Press 1 for Login");
        System.out.println("Press 2 to know about this portal");
        System.out.println("Press 3 to LogOut");
        int choice = sc.nextInt();
        
        switch(choice) {
        	case 1:
        		login();
        		break;
        	case 2:
        		regulation();
        		break;
        	case 3:
//        		m = false;
        		System.out.println("LogOut Successfully!!!");
        		break;
        }
	}
//	}
	
	public static void regulation() {
		System.out.println("\n\n"
				+ "___________________________________________________________________________________\n"
				+ "|                                                                                  |\n"
				+ "|     *It is used to update queries that happening in college like wifi problem    |\n"
				+ "|     fan problem,powercut problem all technical issues .                          |\n"                        
				+ "|      *There is a team that they can see your queries and rectify and respond to  |\n"
				+ "|      that query to that particular query raised student through the portal.      |\n"
				+ "|     *Advantage of the portal is there is no time delay for a problem so that ,we |\n"
				+ "|      can have a trust ,that the problem can be solved.                            |\n"
				+ "|Rules:                                                                            |\n"
				+ "|   1 - Student should login using your college mail_id                            |\n"
				+ "|   2 - Please avoid unwanted queries                                              |\n"
				+ "|   3 - Your HOD also see your query so if any query is unwanted he will           |\n"
				+ "|       taken action                                                               |\n"
				+ "|__________________________________________________________________________________|\n");
	}
		
	static Admin a = new Admin();
	static Student s = new Student();
	static Technician t = new Technician();

	public static void login() throws SQLException {
	    System.out.println("Enter your email_id");
	    String mail = sc.next();
	    System.out.println("Enter your Password :");
	    String password = sc.next();
	    System.out.println("Enter role (Admin/Student/Technician)");
	    String role = sc.next();

	            if(role.equalsIgnoreCase("Admin")) {
	            Admin a1 = new Admin();
	            a1.setEmail_id(mail);
	            a1.setPassword(password);
	            Admin flag = a.adminlogin(a1);
	            if(flag!=null) {
	            	System.out.println("Login Successfully");
	                AdminMenu.adminDisplay(flag);
	            }
	            else {
	            	System.out.println("Invalid Username and Password");
				  }
				}
	            else if(role.equalsIgnoreCase("Student")) {
	            Student s1 = new Student();
	            s1.setEmail_id(mail);
	            s1.setPassword(password);
	            Student s3 = s.studentLogin(s1);
//	            System.out.println(s3.getEmail_id());
	            if (s3 != null) {
	                System.out.println("Login Successfully");
	                StudentMenu.studentDisplay(s3);
	            } else {
	                System.out.println("Invalid Username and Password");
	            }
	            }
	           else if(role.equalsIgnoreCase("Technician")){
	            Technician t1 = new Technician();
	            t1.setEmail_id(mail);
	            t1.setPassword(password);
	            Technician t2 = t.techLogin(t1);
	            if (t2 != null) {
	                System.out.println("Login Successfully");
	                TechnicianMenu.technicianDisplay(t2);
	            } else {
	                System.out.println("Invalid Username and Password");
	            }
	         }
	    }
	}
