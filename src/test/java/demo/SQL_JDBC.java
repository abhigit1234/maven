package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SQL_JDBC {
	
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","system","admin");
		Statement st = con.createStatement();
	
		String sql = "insert into  selenium values(10,'laxmidevi',63,'london','america','25-nov-1960',99999)";
		st.executeQuery(sql);
		
/*		String sql = "select name,age,dob from selenium";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
		String name = rs.getString("name");
		String age = rs.getString("age");
		String dob = rs.getString("dob");
		System.out.print(name+" ");
		System.out.print(age+" ");
		System.out.println(dob);
		}
*/
		con.close();
		System.out.println("success");
	}
	
}