package com.esprit.conge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.esprit.conge.domaine.lifeCycle.lifeCycleServicesLocal;
import com.esprit.conge.entities.Administrateur;
import com.esprit.conge.entities.Conge;
import com.esprit.conge.entities.Employe;

@ManagedBean
@SessionScoped
public class LifeCycleCtr {

	
	private Conge conge= new Conge();
	private List<Conge> conges= new ArrayList<Conge>();
	
	private Employe employe = new Employe();
	private List<Employe> employes= new ArrayList<Employe>();
	
	
	@EJB
	private lifeCycleServicesLocal lifeCycleServicesLocal;


	public Conge getConge() {
		return conge;
	}


	public void setConge(Conge conge) {
		this.conge = conge;
	}

	public String doAddCongeByEmploye(){
		employe = (Employe) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("employe");
		lifeCycleServicesLocal.addCongeByEmploye(conge,employe);
		return "listCongeEmp";
	}
	
	public String doGetCongesByEmploye(){
		employe = (Employe) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("employe");
		lifeCycleServicesLocal.ListCongesByEmploye(employe);
		return "listCongeEmp";
	}

	public String doGetCongesByAdmin(){
		Administrateur administrateur = (Administrateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("administrateur");
		lifeCycleServicesLocal.ListCongesByAdministrateur(administrateur);
		return "listCongeAdmin";
	}
	
	
	public List<Conge> getConges() {
		conges = lifeCycleServicesLocal.AllConges();
		return conges;
	}


	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public List<Employe> getEmployes() {
		employes = lifeCycleServicesLocal.AllEmployes();
		return employes;
	}


	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
}
