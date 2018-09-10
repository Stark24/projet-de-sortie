package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Enregistrement
 */
@WebServlet("/Enregistrement")
public class Enregistrement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/EnregistrerE.jsp";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String CHAMP_TELEPHONE = "telephone";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_HORAIRE = "horaire";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
   
    public Enregistrement() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		String nom= request.getParameter(CHAMP_NOM);
		String adresse= request.getParameter(CHAMP_ADRESSE);
		String telephone= request.getParameter(CHAMP_TELEPHONE);
		String email = request.getParameter( CHAMP_EMAIL );
		String horaire= request.getParameter(CHAMP_HORAIRE);
		
		try {
			validationEmail(email );
			} catch (Exception e) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
			}
		try {
			validationNom( nom );
			} catch (Exception e) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
			}
		try {
			validationAdresse( adresse );
			} catch (Exception e) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
			}
		try {
			validationTelephone( telephone );
			} catch (Exception e) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
			}
		try {
			validationHoraire(horaire );
			} catch (Exception e) {
			erreurs.put( CHAMP_EMAIL, e.getMessage() );
			}
		if( erreurs.isEmpty() ){
			resultat = "Succès de l'inscription.";
			} else {
			resultat = "Échec de l'inscription.";
			}
		request.setAttribute( ATT_ERREURS, erreurs );
		request.setAttribute( ATT_RESULTAT, resultat );
		this.getServletContext().getRequestDispatcher( VUE ).forward(
				request, response );
	}


	private void validationHoraire(String horaire) throws Exception {
		if ( horaire != null && horaire.trim().length() < 3 ) {
			throw new Exception( "Le champ horaire ne doit pas etre vide" );
			}
		
	}


	private void validationTelephone(String telephone) throws Exception {
		if ( telephone != null && telephone.trim().length() != 0 ) {
			if ( !telephone.matches("^509[342][0-9]{7}$" ) ) {
			throw new Exception( "Merci de choisir un numero  valide." );
			}
			} else {
			throw new Exception( "Merci de saisir un numero de Telephone." );
			}
		
	}


	private void validationAdresse(String adresse) throws Exception{
		if ( adresse != null && adresse.trim().length() < 10 ) {
			throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
			}
		
	}


	private void validationNom(String nom) throws Exception {
		if ( nom != null && nom.trim().length() < 3 ) {
			throw new Exception( "Le nom de l'Entreprise doit contenir au moins 3 caractères." );
			}
		
	}


	private void validationEmail(String email) throws Exception {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
			throw new Exception( "Merci de saisir une adresse mail valide." );
			}
			} else {
			throw new Exception( "Merci de saisir une adresse mail." );
			}
		
	}
	

}

