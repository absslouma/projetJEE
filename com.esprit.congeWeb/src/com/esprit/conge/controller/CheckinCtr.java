package com.esprit.conge.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;

import com.esprit.conge.domaine.management.ManagementServicesLocal;
import com.esprit.conge.entities.Administrateur;
import com.esprit.conge.entities.Employe;

@ManagedBean
@SessionScoped
public class CheckinCtr {

	private Administrateur administrateur = new Administrateur();
	private Employe employe = new Employe();
	private String myLogin;
	private String myPwd;
	private String type;

	@EJB
	private ManagementServicesLocal managementServicesLocal;

	public String doCheckin() {
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().containsKey("Administrateur"))
			return type = "Administrateur";
		else if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().containsKey("Employe"))
			return type = "Employe";
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrateur"));
		
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		type = request.getParameter("type");
		System.out.println(type);
		Object object = managementServicesLocal.checkin(myLogin, myPwd, type);
		if (object == null)
			return "KO";
		if (type == "Employe")
			employe = (Employe) object;
		else if (type == "Administrateur")
			administrateur = (Administrateur) object;
		if (employe != null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("Administrateur", administrateur);
			return type;
		} else if (administrateur != null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("employe", employe);
			return type;
		} else {
			return "KO";
		}

	}

	public String doCheckout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "logout";
	}

	public String getMyLogin() {
		return myLogin;
	}

	public void setMyLogin(String myLogin) {
		this.myLogin = myLogin;
	}

	public String getMyPwd() {
		return myPwd;
	}

	public void setMyPwd(String myPwd) {
		this.myPwd = myPwd;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
