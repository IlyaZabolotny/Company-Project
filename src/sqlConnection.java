import java.sql.*;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilya
 */
public class sqlConnection {
    Connection conn=null;
    public static Connection dbConnector()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC"
,"test","123");
		return conn;
	}catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
}
}
