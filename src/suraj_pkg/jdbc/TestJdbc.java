package suraj_pkg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("connection to database: "+jdbcUrl);
			Connection myconn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Successful Connection "+myconn);
		}catch(Exception e) {
			e.printStackTrace();			
		}

	}

}
