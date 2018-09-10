/**
 * 
 */
package service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connection.Connect_Base;

/**
 * @author Windows 10
 *
 */
public class ServiceDAO {
	Connection con = (Connection) Connect_Base.getInstance();
	 
	public boolean inscrireUtilisateur(Service s)
	{
		 try
	     {
	         String req = "INSERT INTO `okapanm_db`.`Service` (`nomService`,`categorieService`)"
	                 + " VALUES ('" + s.getNomService()+ "', '" + s.getCategorieService() + "');";

	         Statement st = (Statement) con.createStatement();

	         int rs = st.executeUpdate(req);

	         if (rs > 0)
	         {
	             return true;
	         }

	     } catch (Exception e1)
	     {
	         // TODO Auto-generated catch block
	         e1.printStackTrace();
	     }

	     return false;
	 }

}
