package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import controller.Admin;
import controller.Query;

public class AdminMenu {
    static Scanner sc =new Scanner(System.in);
    static boolean b = true;
	public static void adminDisplay(Admin flag) throws SQLException {
		while(b==true) {
		System.out.println("\n\n"
				+ "______________________________________________|\n"
				+ "|                                             |\n"
				+ "| Please Select Correct Option                |\n"
				+ "|   1 - Show All Complaints                   |\n"
				+ "|   2 - Add Complaint status                  |\n"
				+ "|   3 - logout                                |\n"
				+ "|_____________________________________________|\n");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
		    ArrayList<Query> al2 = Admin.showAllComplaints(flag);
		    if (al2.isEmpty()) {
		        System.out.println("-----------------------------------------------------------");
		        System.out.println("       There are no queries to display!!!     ");
		        System.out.println("-----------------------------------------------------------");}
		        else {
		        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");
		        System.out.printf("| %-12s | %-20s | %-15s | %-10s | %-10s | %-40s | %-20s |%n",
		                "Student_Rollno", "Student_Name", "Department", "Batch", "Query_Id", "Queries", "Approved_Status");
		        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");

		        for (Query query : al2) {
		            System.out.printf("| %-12s  | %-20s  | %-15s  | %-10s  | %-10s  | %-40s  | %-20s  |%n",
		                    query.getStudentRollno(), query.getStudentName(), query.getDepartment(),
		                    query.getStudentBatch(), query.getQid(), query.getQuery(), query.getQstatus());
		        }
		        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");
		        }
		    break;

		case 2:
		    Query q = new Query();
			System.out.println("Enter Query id");
			int queryid = sc.nextInt();
			System.out.println("Enter status of that query");
			String qstatus = sc.next();
			q.setQid(queryid);
			q.setQstatus(qstatus);
			boolean q1 = Admin.status(q);
//			System.out.println(q1.getQid());
//			System.out.println(q1.getQstatus());
			if(q1==true) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("	      Query status updated successfully!!!!"            );
				System.out.println("-----------------------------------------------------------");
			}
			else {
				System.out.println("-----------------------------------------------------------");
				System.out.println("	      No query with the specified ID found.!!!!"        );
				System.out.println("-----------------------------------------------------------");
			}
			break;
		case 3:
		   b=false;
		   System.out.println("LogOut Succesfully!!");
		   break;
		}
		}
	}
}
