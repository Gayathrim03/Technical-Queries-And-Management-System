package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Complaint;
import controller.Query;
import controller.Technician;

public class TechnicianMenu {
       static Scanner sc = new Scanner(System.in);
	public static void technicianDisplay(Technician t2) throws SQLException {
		boolean b = true;
		while(b==true) {
		System.out.println("\n\n"
				+ "______________________________________________________________\n"
				+ "|                                                            |\n"
				+ "| Please Select Correct Option                               |\n"
				+ "|   1 - Show Complaints by students approved by admin        |\n"
				+ "|   2 - Update Complaint Status                              |\n"
				+ "|   3 - LogOut                                               |\n"
				+ "|____________________________________________________________|\n");
		
	int choice = sc.nextInt();
    switch(choice) {
    case 1:
    	ArrayList<Query> aqt = Technician.showComp(t2);
    	System.out.println("+--------------------------------------------------------------------------------------");
        System.out.println("| Query ID |      Query                                                               |");
        System.out.println("+--------------------------------------------------------------------------------------");

        for (Query query : aqt) {
            System.out.printf("| %-9d| %-73s|\n", query.getQid(), query.getQstatus());
        }

        System.out.println("--------------------------------------------------------------------------------------");
        break;
    case 2:
    	Complaint c = new Complaint();
    	System.out.println("Enter query id");
    	int qid = sc.nextInt();
    	System.out.println("Enter Query Status");
    	String qstatus = sc.next();
    	c.setQid(qid);
    	c.setQstatus(qstatus);
    	Complaint cc =Technician.upComp(c);
    	if(cc!=null) {
    		System.out.println("--------------------------------------------------------------");
            System.out.println("      Query Status Successfully Uploaded!!!                   ");
            System.out.println("--------------------------------------------------------------");
    	}
    	break;
    case 3:
    	System.out.println("LogOut Successfullyy!!");
    	b=false;
    	break;
    }
}
}
}
