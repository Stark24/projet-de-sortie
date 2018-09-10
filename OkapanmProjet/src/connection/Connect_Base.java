/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect_Base {
	private static String url="jdbc:mysql://localhost:3306/okapanm_db";
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="";
	private static Connection cnx;
	
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			System.out.println("Driver OK");
			cnx=DriverManager.getConnection(url, user, password);
		  System.out.println("Connexion etablie");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnx;
		
	}


	  public static Connection getInstance()
	    {
	        if(cnx==null)
	            new Connect_Base();
	        return cnx;
	            
	        
	    }
}
