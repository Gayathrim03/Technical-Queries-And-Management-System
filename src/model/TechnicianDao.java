package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Complaint;
import controller.Query;
import controller.Technician;

public class TechnicianDao {

	public Technician checkTechLogin(Technician t1) throws SQLException {
		Connection con = Db_Connection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT Email_Id, Password FROM technician_details WHERE Email_Id = ?");
		ps.setString(1,t1.getEmail_id());
		ResultSet rs = ps.executeQuery();
		Technician dbt = new Technician();
		while(rs.next()) {
			String tpass = rs.getString("Password");
			dbt.setPassword(tpass);
			return dbt;
		}
		return dbt;
	}

	public static ArrayList<Query> showComplaintByStudents() throws SQLException {
		Connection con = Db_Connection.getConnection();
		ArrayList<Query> aq = new ArrayList<>();
		String query="SELECT query_id,queries FROM query_table WHERE approved_status_from_admin='approved'";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			Query qs = new Query();
			int qid = rs.getInt("query_id");
			String qsts = rs.getString("queries");
			qs.setQid(qid);
			qs.setQstatus(qsts);
			aq.add(qs);
		}
		return aq;
	}

	public static Complaint updateComplaintStatus(Complaint c) throws SQLException {
		Connection con = Db_Connection.getConnection();
		String query="INSERT INTO complaint_status (query_id, query_status) VALUES(?,?)";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, c.getQid());
		statement.setString(2, c.getQstatus());
		int rs = statement.executeUpdate();
//		System.out.println(c.getQid());
//		System.out.println(c.getQstatus());
		return c;
	}

}
