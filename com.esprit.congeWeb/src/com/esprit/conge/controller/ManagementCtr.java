package com.esprit.conge.controller;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.esprit.conge.domaine.management.ManagementServicesLocal;
import com.esprit.conge.entities.Conge;
import com.esprit.conge.entities.Employe;

@ManagedBean
@SessionScoped
public class ManagementCtr {
	private Employe employe = new Employe();
	private Conge conge=new Conge();
	
	@EJB
	private ManagementServicesLocal managementServicesLocal;
	
	public String doAddEmploye() {
		managementServicesLocal.addEmploye(employe);
		return "Emp";
	}

	public String doEditEmploye() {
		managementServicesLocal.editEmploye(employe);
		return "Emp";
	}

	public String doDeleteEmploye() {
		managementServicesLocal.deleteEmploye(employe);
		return "Emp";
	}

	public String doAddConge() {
		managementServicesLocal.addConge(conge);
		return "Cng";
	}

	public String doEditConge() {
		managementServicesLocal.editConge(conge);
		return "Cng";
	}

	public String doDeleteConge() {
		managementServicesLocal.deleteConge(conge);
		return "Cng";
	}

	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public boolean login() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", employe);
		return false;
	}
	
	public boolean logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return true;
	}
	
	public ManagementServicesLocal getManagementServicesLocal() {
		return managementServicesLocal;
	}

	public void setManagementServicesLocal(
			ManagementServicesLocal managementServicesLocal) {
		this.managementServicesLocal = managementServicesLocal;
	}

	public Conge getConge() {
		return conge;
	}

	public void setConge(Conge conge) {
		this.conge = conge;
	}
}
