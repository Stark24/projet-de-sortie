/**
 * 
 */
package article;

import com.BeanException.BeanException;

/**
 * @author Windows 10
 *
 */
public class Article {
private String nomArticle,description,urlImage,categorie;
private double quantite, prix;
public String getDescription() {
	return description;
}
public void setDescription(String description)throws BeanException {
	if(description.isEmpty())
	{
		throw new BeanException("la descritpion doit etre renseignee");
	} else
	{
		this.description = description;	
	}
	
}
public double getQuantite() {
	return quantite;
}
public void setQuantite(double quantite) {
	this.quantite = quantite;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix)  throws BeanException{
	if(prix==0 || prix<0)
	{
		throw new BeanException("Le prix est incorrect");
	}
	else
	{
		this.prix = prix;	
	}
	
}
public String getNomArticle() {
	return nomArticle;
}
public void setNomArticle(String nomArticle) throws BeanException {
	if(nomArticle.isEmpty())
	{
		throw new BeanException("Le nom de l'article ne doit pas etre vide");
	}
	else {
		this.nomArticle = nomArticle;
	}
	
}
public Article()
{
	
}
public Article(String nomArticle,String description,double quantite, double prix, String urlImage,String categorie) {
this.nomArticle=nomArticle;
this.description=description;
this.prix=prix;
this.quantite=quantite;
this.urlImage=urlImage;
this.categorie=categorie;
}

@Override
public String toString()
{
    return "Article{" + "nomArticle=" +nomArticle + ", description=" + description + ", prix=" + prix +  ", quantite=" + quantite +  '}';
}
public String getUrlImage() {
	return urlImage;
}
public void setUrlImage(String urlImage) {
	this.urlImage = urlImage;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
}
