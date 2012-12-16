package com.esprit.conge.domaine.management;

import javax.ejb.Remote;

import com.esprit.conge.entities.*;

@Remote
public interface ManagementServicesRemote {

	Employe addEmploye(Employe employe);
	boolean deleteEmploye(Employe employe);
	Employe editEmploye(Employe employe);
	
	Conge addConge(Conge conge);
	boolean deleteConge(Conge conge);
	Conge editConge(Conge conge);
	Object checkin(String login, String password, String type);
}
