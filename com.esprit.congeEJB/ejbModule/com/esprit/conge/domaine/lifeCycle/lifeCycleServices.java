package com.esprit.conge.domaine.lifeCycle;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.esprit.conge.entities.*;

/**
 * Session Bean implementation class lifeCycleServices
 */
@Stateless
public class lifeCycleServices implements lifeCycleServicesRemote, lifeCycleServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

    public lifeCycleServices() {
    }

	@Override
	public List<Conge> AllConges() {
		return entityManager.createQuery("Select c from Conge c").getResultList();
		
	}

	@Override
	public List<Conge> ListCongesByEmploye(Employe employe) {
		return entityManager.createQuery("Select c from Conge c where c.employe=:param1").setParameter("param1", employe).getResultList();
	}

	@Override
	public List<Conge> ListCongesByAdministrateur(Administrateur administrateur) {
		return entityManager.createQuery("Select c from Conge c where c.administrateur=:param1").setParameter("param1", administrateur).getResultList();
	}

	@Override
	public List<Employe> AllEmployes() {
		return entityManager.createQuery("Select c from Employe c").getResultList();
	}

	@Override
	public void addCongeByEmploye(Conge conge, Employe employe) {
		conge.setEmploye(employe);
		entityManager.persist(conge);
		
	}

}
