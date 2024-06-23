package controller;

import java.sql.SQLException;
import java.util.ArrayList;

//import java.sql.SQLException;

import model.AdminDao;
import view.AdminMenu;

public class Admin {
   private int admin_id;
   private String username;
   private String Department;
   private String email_id;
   private String Password;
   private String qstatus;
   private int qid;
   
   public Admin() {
	   
   }
   
   public Admin(int id,String username,String Department,String mail_id,String password,String qstatus,int qid){
	   this.admin_id = id;
	   this.username = username;
	   this.Department = Department;
	   this.email_id = mail_id;
	   this.Password = password;
	   this.qstatus = qstatus;
	   this.qid = qid;
   }
   
			   public String getQstatus() {
			return qstatus;
		}
		
		public void setQstatus(String qstatus) {
			this.qstatus = qstatus;
		}
		
		public int getQid() {
			return qid;
		}
		
		public void setQid(int qid) {
			this.qid = qid;
		}

	public int getAdmin_id() {
		return admin_id;
	    }
		
		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getDepartment() {
			return Department;
		}
		
		public void setDepartment(String department) {
			Department = department;
		}
		
		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		
		public String getPassword() {
			return Password;
		}
		
		public void setPassword(String password) {
			Password = password;
		}

		public Admin adminlogin(Admin a1) throws SQLException {
			AdminDao adao = new AdminDao();
			Admin dd = adao.checkAdminLogin(a1);
			if(dd!=null && a1.getPassword().equals(dd.getPassword())){
				return dd;			}
			else {
				return null;
			}
		}

		public static ArrayList<Query> showAllComplaints(Admin flag) throws SQLException {
			ArrayList<Query> al1 =AdminDao.DbshowAllComplaints(flag);
			return al1;
		}

		public static boolean status(Query q) throws SQLException {
			boolean b = AdminDao.DbUpdateStatus(q);
//			if(b1==true) {
//				System.out.println("-----------------------------------------------------------");
//				System.out.println("	      Query status updated successfully!!!!"            );
//				System.out.println("-----------------------------------------------------------");
//			}
//			else {
//				System.out.println("-----------------------------------------------------------");
//				System.out.println("	      No query with the specified ID found.!!!!"        );
//				System.out.println("-----------------------------------------------------------");
//			}
//			return q;
			return b;
		}
        
		
}
