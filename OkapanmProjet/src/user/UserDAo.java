/**
 * 
 */
package user;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import connection.Connect_Base;

/**
 * @author Windows 10
 *
 */
public class UserDAo {
	
	Connection con = (Connection) Connect_Base.getInstance();
public boolean inscrireUtilisateur(Utilisateur u)
{
	 try
     {
         String req = "INSERT INTO `okapanm_db`.`user` (`nom`, `prenom`, `sexe`, `adresse`, `telephone`, `email`,`rue`, `ville`,`mdp`,`pseudo`,`urlimage`)"
                 + " VALUES ('" + u.getNom() + "', '" + u.getPrenom() + "', '" + u.getSexe() + "', '" + u.getAdresse() + "', '" + u.getTelephone() +  "', '" + u.getEmail() + "', '" + u.getRue() +  "', '" + u.getVille()+  "', '" + u.getMdp() +  "', '" + u.getPseudo() +  "', '" + u.getUrlImage() +"');";

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
