package controller;

public class Query {
    private int qid;
    private String query;
    private String qstatus;
    private String StudentRollno;
    private String StudentName;
    private String StudentBatch;
    private String Department;
	public Query(int qid, String query, String qstatus, String studentRollno, String studentName, String studentBatch,
			String department) {
		this.qid = qid;
		this.query = query;
		this.qstatus = qstatus;
		StudentRollno = studentRollno;
		StudentName = studentName;
		StudentBatch = studentBatch;
		Department = department;
	}
		public Query() {
		// TODO Auto-generated constructor stub
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
		public String getQstatus() {
			return qstatus;
		}
		public void setQstatus(String qstatus) {
			this.qstatus = qstatus;
		}
		public String getStudentRollno() {
			return StudentRollno;
		}
		public void setStudentRollno(String studentRollno) {
			StudentRollno = studentRollno;
		}
		public String getStudentName() {
			return StudentName;
		}
		public void setStudentName(String studentName) {
			StudentName = studentName;
		}
		public String getStudentBatch() {
			return StudentBatch;
		}
		public void setStudentBatch(String studentBatch) {
			StudentBatch = studentBatch;
		}
		public String getDepartment() {
			return Department;
		}
		public void setDepartment(String department) {
			Department = department;
		}
  


	
}
