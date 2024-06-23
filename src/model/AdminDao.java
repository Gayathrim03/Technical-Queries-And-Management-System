package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.Admin;
import controller.Query;
public class AdminDao {

    public Admin checkAdminLogin(Admin a1) throws SQLException {
    	Connection con = Db_Connection.getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT Mail_id, Password ,Department FROM admin_details WHERE Mail_id = ?");
             statement.setString(1, a1.getEmail_id());
             ResultSet rs = statement.executeQuery();
             Admin dd=new Admin();
                while(rs.next()) {
                    String dbpass = rs.getString("Password");
                    String sdep = rs.getString("Department");
                    dd.setPassword(dbpass);
                    dd.setDepartment(sdep);
                    return dd;
                }
                return dd;
            }


    public static ArrayList<Query> DbshowAllComplaints(Admin a1) throws SQLException {
        ArrayList<Query> al = new ArrayList<>();
        Connection con = Db_Connection.getConnection();
        System.out.print(a1.getDepartment());
        if(a1.getDepartment()!=null) {
        PreparedStatement statement = con.prepareStatement("SELECT q.Student_Rollno, s.student_Name, s.Department, s.Batch, q.query_id, q.queries, q.approved_status_from_admin " +
                "FROM query_table q INNER JOIN student_details s ON q.Student_Rollno = s.Student_Rollno WHERE s.Department=?");
        statement.setString(1, a1.getDepartment());
        ResultSet rs = statement.executeQuery();
        
        // Print table headers
//        System.out.printf("%-15s %-25s %-15s %-10s %-10s %-30s %-20s%n", "Student_Rollno", "Student_Name", "Department", "Batch", "Query_Id", "Queries", "Approved_Status");
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        
        while (rs.next()) {
            String sroll = rs.getString("Student_Rollno");
            String sname = rs.getString("Student_Name");
            String sdep = rs.getString("Department");
            String sbatch = rs.getString("Batch");
            int qid = rs.getInt("query_id");
            String squery = rs.getString("queries");
            String sstatus = rs.getString("approved_status_from_admin");
            
            Query q = new Query();
            q.setStudentRollno(sroll);
            q.setStudentName(sname);
            q.setDepartment(sdep);
            q.setStudentBatch(sbatch);
            q.setQid(qid);
            q.setQuery(squery);
            q.setQstatus(sstatus);
            al.add(q);
//            System.out.printf("%-15s %-25s %-15s %-10s %-10s %-30s %-20s%n", sroll, sname, sdep, sbatch, qid, squery, sstatus);
        }
        }
        else if(a1.getDepartment()=="NULL"){
        	PreparedStatement statement = con.prepareStatement("SELECT * FROM query_table");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // Retrieve details from the query_table
                String sroll = rs.getString("Student_Rollno");
                String sname = rs.getString("Student_Name");
                String sdep = rs.getString("Department");
                String sbatch = rs.getString("Batch");
                int qid = rs.getInt("query_id");
                String squery = rs.getString("queries");
                String sstatus = rs.getString("approved_status_from_admin");

                // Create Query object and add to ArrayList
                Query q = new Query();
                q.setStudentRollno(sroll);
                q.setStudentName(sname);
                q.setDepartment(sdep);
                q.setStudentBatch(sbatch);
                q.setQid(qid);
                q.setQuery(squery);
                q.setQstatus(sstatus);
                al.add(q);
            }
        }
        return al;
        }

    public static boolean DbUpdateStatus(Query q) throws SQLException {
        boolean b = false;
        Connection con = Db_Connection.getConnection();
        String query = "UPDATE query_table SET approved_status_from_admin=? WHERE query_id=?";
        PreparedStatement statement = con.prepareStatement(query);
//        System.out.println(q.getQid());
//        System.out.println(q.getQstatus());
        statement.setString(1, q.getQstatus());
        statement.setInt(2, q.getQid()); 
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }




}
