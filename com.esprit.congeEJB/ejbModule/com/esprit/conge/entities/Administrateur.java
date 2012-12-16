package com.esprit.conge.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrateur
 * 
 */
@Entity
public class Administrateur implements Serializable {

	private int idAdministrateur;
	private String nomAdministrateur;
	private String prenomAdministrateur;
	private String login;
	private String password;
	private List<Conge> conges;
	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAdministrateur() {
		return this.idAdministrateur;
	}

	public void setIdAdministrateur(int idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
	}

	public String getNomAdministrateur() {
		return this.nomAdministrateur;
	}

	public void setNomAdministrateur(String nomAdministrateur) {
		this.nomAdministrateur = nomAdministrateur;
	}

	public String getPrenomAdministrateur() {
		return this.prenomAdministrateur;
	}

	public void setPrenomAdministrateur(String prenomAdministrateur) {
		this.prenomAdministrateur = prenomAdministrateur;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrateur [idAdministrateur=" + idAdministrateur
				+ ", nomAdministrateur=" + nomAdministrateur
				+ ", prenomAdministrateur=" + prenomAdministrateur + ", login="
				+ login + ", password=" + password + "]";
	}

	@OneToMany(mappedBy="administrateur")
	public List<Conge> getConges() {
		return conges;
	}

	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}

}
