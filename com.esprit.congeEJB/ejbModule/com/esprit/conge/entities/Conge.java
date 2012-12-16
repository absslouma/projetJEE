package com.esprit.conge.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Conges
 *
 */
@Entity

public class Conge implements Serializable {

	   
	private int idConges;
	private Employe employe;
	private Administrateur administrateur;
	private Date dateDebut;
	private Date dateFin;
	private static final long serialVersionUID = 1L;

	public Conge() {
		super();
	}   

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdConges() {
		return this.idConges;
	}

	public void setIdConges(int idConges) {
		this.idConges = idConges;
	}   
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@ManyToOne
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Conge [employe=" + employe + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

	@ManyToOne
	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
   
}
