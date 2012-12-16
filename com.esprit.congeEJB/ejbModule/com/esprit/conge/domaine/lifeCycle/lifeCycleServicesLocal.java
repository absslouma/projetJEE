package com.esprit.conge.domaine.lifeCycle;

import java.util.List;

import javax.ejb.Local;

import com.esprit.conge.entities.*;

@Local
public interface lifeCycleServicesLocal {

	List<Conge> AllConges();
	List<Conge> ListCongesByEmploye(Employe employe);
	List<Conge> ListCongesByAdministrateur(Administrateur administrateur);

	List<Employe> AllEmployes();
	void addCongeByEmploye(Conge conge, Employe employe);
	
}
