package controller;

import java.sql.SQLException;

import model.StudentDao;
import view.StudentMenu;

public class Student {
    private String student_rollno;
    private String student_name;
    private String Department;
    private String Batch;
    private String Email_id;
    private String Password;
    private String query;
    private int qid;
    private String qstatus;
    
	public Student(String student_rollno, int qid ,String qstatus,String student_name, String department, String batch, String email_id,String password,String query) {
		this.student_rollno = student_rollno;
		this.student_name = student_name;
		this.Department = department;
		this.Batch = batch;
		this.Email_id = email_id;
		this.Password = password;
		this.query = query;
		this.qid=qid;
		this.qstatus = qstatus;
	}
	
	
	public String getQstatus() {
		return qstatus;
	}


	public String setQstatus(String qstatus) {
		return qstatus;
	}


	public int getQid() {
		return qid;
	}


	public void setQid(int qid) {
		this.qid = qid;
	}


	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}


	public Student() {
		
	}


	public String getStudent_rollno() {
		return student_rollno;
	}
	public void setStudent_rollno(String student_rollno) {
		this.student_rollno = student_rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getBatch() {
		return Batch;
	}
	public void setBatch(String batch) {
		Batch = batch;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


	public Student studentLogin(Student s1) throws SQLException {
		StudentDao sdao = new StudentDao();
		Student dbs = sdao.checkStudentLogin(s1);
		StudentMenu sm = new StudentMenu();
		if(dbs!=null && s1.getPassword().equals(dbs.getPassword())) {
//			System.out.println(dbs.getPassword());
//			System.out.println(s1.getPassword());
			return dbs;
		}
		else {
//			System.out.println(dbs.getPassword());
//			System.out.println(s1.getPassword());
			return null;
		}
	}


	public static Student regComp(Student s3) throws SQLException {
		Student rc= StudentDao.DBRegisterComplaint(s3);
        return rc;
	}

	public static Query showCompSts(Query qq) throws SQLException {
	    Query qg =StudentDao.showComplaintStatus(qq);
//	    System.out.println(qg.getQid());
//	    System.out.println(qq.getQstatus());
		return qg;
	    
	}

}
