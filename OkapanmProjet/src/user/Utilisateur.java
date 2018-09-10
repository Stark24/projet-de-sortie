package user;

import com.BeanException.BeanException;

public class Utilisateur {
private String nom,prenom,sexe,adresse,telephone,email,rue,ville, mdp,pseudo,urlImage;

public String getNom() {
	return nom;
}

public void setNom(String nom) throws BeanException
{
	if(nom.length() > 45 || nom.length()<3 || nom.isEmpty())
	{
		throw new BeanException("le nom est incorrect");
	}
	else
	{
		this.nom = nom;
	}
	
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) throws BeanException {
	if(prenom.length()>45 || prenom.length()<3|| prenom.isEmpty())
	{
		throw new BeanException("le prenom est incorrect");
	}
	else {
		this.prenom = prenom;
	}
	
}

public String getSexe() {
	return sexe;
}

public void setSexe(String sexe) {
	this.sexe = sexe;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) throws BeanException {
	if(adresse.length()>45 || adresse.length()<10 || adresse.isEmpty())
	{
		throw new BeanException("l'adresse est incorrect");
	}
	else
	{
		this.adresse = adresse;
	}
	
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) throws BeanException{
	if(telephone.length()<8 || telephone.isEmpty())
	{
		throw new BeanException("le numero  est incorrect");
	}
	this.telephone = telephone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getRue() {
	return rue;
}

public void setRue(String rue) throws BeanException {
	if(rue.isEmpty()|| rue.length()<1)
	{
		throw new BeanException("le nom de rue  est incorrect");
	}
	this.rue = rue;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) throws BeanException
{
	if(ville.length()<3 || ville.isEmpty())
	{
		throw new BeanException("la ville est incorrect");
	}
	else {
		this.ville = ville;
	}
	
}
public Utilisateur()
{
	
}
public Utilisateur(String nom,String prenom,String sexe,String adresse,String telephone,String email,String rue,String ville,String mdp,String pseudo,String urlImage)
{
	 this.nom=nom;
	 this.prenom=prenom;
	 this.sexe=sexe;
	 this.adresse=adresse;
	 this.telephone=telephone;
	 this.email=email;
	 this.rue=rue;
	 this.ville=ville;
	 this.mdp=mdp;
	 this.pseudo=pseudo;
	 this.urlImage=urlImage;
	 
	
}

@Override
public String toString()
{
    return "Utilisateur{" + "nom=" + nom + ", prenom=" +prenom + ", sexe=" + sexe + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email + ", rue=" + rue + ", ville=" + ville +'}';
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) throws BeanException  {
	
	
	if(mdp.length()>8 || mdp.isEmpty())
	{
		throw new BeanException("le mot de passe est incorrect");
	}
	else {
		this.mdp = mdp;
	}
	
}

public String getPseudo() {
	return pseudo;
}

public void setPseudo(String pseudo) throws BeanException {
	
	if(pseudo.length()>3 || pseudo.isEmpty())
	{
		throw new BeanException("le pseudo est incorrect");
	}
	else {
		this.pseudo = pseudo;
	}
	
}

public String getUrlImage() {
	return urlImage;
}

public void setUrlImage(String urlImage) {
	this.urlImage = urlImage;
}

}
