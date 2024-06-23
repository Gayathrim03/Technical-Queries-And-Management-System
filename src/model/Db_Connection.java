package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_Connection {


		private static Connection con ;


		private Db_Connection() {
			String url = "jdbc:mysql://localhost:3306/bms";
			String user ="root";
			String pass = "MLGT@3019";
			try {
				con = DriverManager.getConnection(url,user,pass);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			if(con==null) {
				new Db_Connection();
				return con;
			}
			return con;
		}
		static void closecon() {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

