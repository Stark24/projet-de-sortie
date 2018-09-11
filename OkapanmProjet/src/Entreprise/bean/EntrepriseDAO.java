/**
 * 
 */
package Entreprise.bean;

import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connection.Connect_Base;



/**
 * @author Windows 10
 *
 */
// classe pour les methodes manipulant les entreprises
public class EntrepriseDAO {
	Connection con = (Connection) Connect_Base.getInstance();
 
	// methode pour enregistrer les entreprises
	public boolean enregisterEntreprise(Entreprise e)
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
	
	// methode pour mettre a jour une entreprise
	
	 public boolean update(Entreprise e)
	    {
	        try
	        {
	            String req = "UPDATE `okapanm_db`.`Entreprise` "
	                    + "SET `nomEntreprise`='" + e.getNomEntreprise() + "', "
	                    + "`Adresse`='" + e.getAdresse() + "', "
	                    + "`telephone`='" + e.getTelephone() + "', "
	                    + "`email`='" + e.getEmail() + "', "
	                    + "`horaire`='" + e.getHoraire() + "' "
	                    + "WHERE `nomEntreprise`='" + e.getNomEntreprise() + "';";

	            java.sql.Statement st = con.createStatement();

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
	 
	 // methode pour afficher toutes les entreprises
	 
	 
	 public Vector<Entreprise> findAll()
	    {
	        String req = "SELECT * " + " FROM entreprise ";

	        Vector<Entreprise> vect = null;

	        try
	        {
	            java.sql.Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(req);

	            while (rs.next())
	            {

	                if (vect == null)
	                {
	                    vect = new Vector<>();
	                }

	                Entreprise e = new Entreprise(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

	                vect.add(e);
	            }

	            return vect;
	        } catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return null;
	    }
}
