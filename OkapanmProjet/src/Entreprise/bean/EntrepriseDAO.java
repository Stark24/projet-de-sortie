/**
 * 
 */
package Entreprise.bean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connection.Connect_Base;



/**
 * @author Windows 10
 *
 */
public class EntrepriseDAO {
	Connection con = (Connection) Connect_Base.getInstance();
 
	public boolean inscrireUtilisateur(Entreprise e)
	{
		 try
	     {
	         String req = "INSERT INTO `okapanm_db`.`Entreprise` (`nomEntreprise`, `Adresse`, `telephone`, `email`, `horaire`,`urlImage`)"
	                 + " VALUES ('" + e.getNomEntreprise() + "', '" + e.getAdresse() + "', '" + e.getTelephone() + "', '" + e.getEmail() + "', '" + e.getHoraire() +  "', '" + e.getUrlImage() +"');";

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
