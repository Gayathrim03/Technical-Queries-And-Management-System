package view;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Query;
import controller.Student;

public class StudentMenu {
    static Scanner sc = new Scanner(System.in);
    static boolean b = true;
    public static void studentDisplay(Student s3) throws SQLException {
    	while(b==true) {
        System.out.println("\n\n"
                + "________________________________\n"
                + "|                              |\n"
                + "| Please Select Correct Option |\n"
                + "|   1 - Register A Complaint   |\n"
                + "|   2 - Show Complaint Status  |\n"
                + "|   3 - Exit                   |\n"
                + "|______________________________|\n");
        try {
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Your Complaint:");
                    String query = sc.nextLine();
                    s3.setQuery(query);
                    Student rb =Student.regComp(s3);
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("      Query uploaded Successfully !!!and The Query Id is "+rb.getQid());
                    System.out.println("--------------------------------------------------------------");
                    break;
                case 2:
                    Query qq = new Query();
                	System.out.println("Enter your query id:");
                	int qid = sc.nextInt();
                	qq.setQid(qid);
                	Query qt = Student.showCompSts(qq);
                	if(qt.getQstatus()!=null) {
                		System.out.print(qt.getQstatus());
                	}
                	else {
                		System.out.println("--------------------------------------------------------------");
                        System.out.println("     No query status with the specified ID found");
                        System.out.println("--------------------------------------------------------------");
                	}
                	break;
                case 3:
                    System.out.println("LogOut Succesfully!!!!");
                    b=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.nextLine();
        }
    }
    }
}
