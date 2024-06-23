package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Query;
import controller.Student;

public class StudentDao {

	public Student checkStudentLogin(Student s1) throws SQLException {
		Connection con = Db_Connection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT Email_Id, Password,Department FROM student_details WHERE Email_Id = ?");
		ps.setString(1, s1.getEmail_id());
		Student dbs = new Student();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String smail = rs.getString("Email_Id");
			String spass = rs.getString("Password");
			String sdep = rs.getString("Department");
			dbs.setPassword(spass);
			dbs.setDepartment(sdep);
			dbs.setEmail_id(smail);
			return dbs;
		}
		return dbs;
	}


	public static Student DBRegisterComplaint(Student s3) throws SQLException {
	    Connection con = Db_Connection.getConnection(); 
	    PreparedStatement selectStatement = con.prepareStatement("SELECT Student_Rollno, Student_Name, Department, Batch FROM student_details WHERE Email_Id=?");
	    selectStatement.setString(1, s3.getEmail_id());
	    ResultSet rs1 = selectStatement.executeQuery();
	    String s = "", s1 = "", s21 = "", s31 = "", s32 = "", s4 = "pending";
	    while (rs1.next()) {
	        s = rs1.getString("Student_Rollno");
	        s1 = rs1.getString("Student_Name");
	        s21 = rs1.getString("Department");
	        s31 = rs1.getString("Batch");

	        s3.setStudent_rollno(s);
	        s3.setStudent_name(s1);
	        s3.setDepartment(s21);
	        s3.setBatch(s31);
	    }

	    String insertQuery = "INSERT INTO query_table (Student_Rollno, queries, approved_status_from_admin) VALUES (?, ?, ?)";
	    PreparedStatement insertStatement = con.prepareStatement(insertQuery);
	    insertStatement.setString(1, s3.getStudent_rollno());
	    insertStatement.setString(2, s3.getQuery());
	    insertStatement.setString(3, s3.setQstatus("Pending")); // Set query status directly as 'pending'
	    insertStatement.executeUpdate(); 
        
	    int queryId = 0;
	    PreparedStatement ps = con.prepareStatement("SELECT query_id FROM query_table WHERE queries=?");
	    ps.setString(1, s3.getQuery());
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        queryId = rs.getInt("query_id");
	        s3.setQid(queryId);
	    }

	    return s3;
	}

	public static Query showComplaintStatus(Query qq) throws SQLException {
	    Connection con = Db_Connection.getConnection(); 
	    PreparedStatement ps = con.prepareStatement("SELECT approved_status_from_admin FROM query_table WHERE query_id=?");
	    ps.setInt(1, qq.getQid());
	    ResultSet rs = ps.executeQuery();
//	    System.out.print(qq.getQid());
	    while (rs.next()) {
	        String status = rs.getString("approved_status_from_admin");
	        qq.setQstatus(status);
	    }
	    return qq;
//		return null;
	}


}
