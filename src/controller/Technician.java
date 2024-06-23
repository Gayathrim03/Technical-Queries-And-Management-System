package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import model.TechnicianDao;
import view.TechnicianMenu;

public class Technician {
    private int tech_id;
    private String technician_name;
    private String email_id;
    private String password;
    
   
	public Technician(int tech_id, String technician_name, String email_id, String password) {
		this.tech_id = tech_id;
		this.technician_name = technician_name;
		this.email_id = email_id;
		this.password = password;
	}


	public Technician() {
		// TODO Auto-generated constructor stub
	}


	public int getTech_id() {
		return tech_id;
	}


	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}


	public String getTechnician_name() {
		return technician_name;
	}


	public void setTechnician_name(String technician_name) {
		this.technician_name = technician_name;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Technician techLogin(Technician t1) throws SQLException {
		TechnicianDao tdao = new TechnicianDao();
		Technician dbt = tdao.checkTechLogin(t1);
//		TechnicianMenu tm = new TechnicianMenu();
		if(dbt!=null && t1.getPassword().equals(dbt.getPassword())) {
//			System.out.println(dbt.getPassword());
//			System.out.println(t1.getPassword());
			return dbt;
			
		}
		else {	
//			System.out.println(dbt.getPassword());
//			System.out.println(t1.getPassword());
			return null;
		}
	}


	public static ArrayList<Query> showComp(Technician t2) throws SQLException {
		ArrayList<Query> aaq =TechnicianDao.showComplaintByStudents();
		return aaq;
	}


	public static Complaint upComp(Complaint c) throws SQLException {
		Complaint tt =TechnicianDao.updateComplaintStatus(c);
		return tt;
	}
	
	
	
}
