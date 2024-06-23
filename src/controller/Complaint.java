package controller;

public class Complaint {
  private int qid;
  private String qstatus;
  
  
		  public Complaint(int qid, String qstatus) {
			  this.qid = qid;
			  this.qstatus = qstatus;
		  }
	    public Complaint() {
			// TODO Auto-generated constructor stub
		}
		public int getQid() {
			return qid;
		}
		
		
		public void setQid(int qid) {
			this.qid = qid;
		}
		
		
		public String getQstatus() {
			return qstatus;
		}
		
		
		public void setQstatus(String qstatus) {
			this.qstatus = qstatus;
		}


}
