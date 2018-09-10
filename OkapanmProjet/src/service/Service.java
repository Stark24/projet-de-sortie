/**
 * 
 */
package service;

/**
 * @author Windows 10
 *
 */
public class Service {
private String nomService,categorieService;

public String getNomService() {
	return nomService;
}

public void setNomService(String nomService) {
	this.nomService = nomService;
}

public String getCategorieService() {
	return categorieService;
}

public void setCategorieService(String categorieService) {
	this.categorieService = categorieService;
}
public Service() {
	
}
public Service(String nomService,String categorieService) {
this.nomService=nomService;	
this.categorieService=categorieService;
}
@Override
public String toString()
{
    return "Service{" + "nomService=" + nomService + ", categorieService=" +categorieService + '}';
}
}
