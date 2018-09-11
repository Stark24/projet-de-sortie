/**
 * 
 */
package user;

import java.sql.ResultSet;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connection.Connect_Base;

/**
 * @author Windows 10
 *
 */
// classe pour les methodes sur les utilisateurs
public class UserDAo {
	
	Connection con = (Connection) Connect_Base.getInstance();
	
	// la methode pour inscrire les utilisateurs
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
// methode pour mettre a jour les donnees des utilsateurs

public boolean update(Utilisateur u)
{
    try
    {
        String req = "UPDATE `okapanm_db`.`user` "
                + "SET `nom`='" + u.getNom() + "', "
                + "`prenom`='" + u.getPrenom() + "', "
                + "`sexe`='" + u.getSexe() + "' "
                + "`adresse`='" + u.getAdresse() + "', "
                + "`telephone`='" + u.getTelephone() + "', "
                + "`email`='" + u.getEmail() + "' "
                + " `rue`='" + u.getRue() + "', "
                + "`ville`='" + u.getVille() + "', "
                + "`mdp`='" + u.getMdp() + "' "
                + " `pseudo`='" + u.getPseudo() + "', "
                + "`urlImage`='" + u.getUrlImage() + "', "
                + "WHERE `pseudo`='" + u.getPseudo() + "';";

       

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

// methode pour desactiver un utilisateur
public boolean bloquer(String pseudo)
{
    try
    {
        String req = "UPDATE user SET "
                + "etat=0"
                + " WHERE pseudo='" + pseudo + "';";

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

// methode pour afficher touts les utilisateurs
public Vector<Utilisateur> findAll()
{
    String req = "SELECT * " + " FROM user ";

    Vector<Utilisateur> vect = null;

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

            Utilisateur e = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11) );

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

