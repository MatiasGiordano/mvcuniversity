package com.mgiordano.application.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id" )
	private int  id;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "[file]" )
	private String file;
	
	@Column(name = "dni" )
	private long dni;
	
	@Column(name = "is_admin" )
	private boolean is_admin;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<inscription> inscriptions;
	
	
	public Set<inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public boolean isIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	public user() {

	}

	public user(int id, String name, String file, long dni, boolean is_admin, Set<inscription> inscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.file = file;
		this.dni = dni;
		this.is_admin = is_admin;
		this.inscriptions = inscriptions;
	}
	@Override //Sobreescribe la definición de un método ya agregado
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", file=" + file + ", dni=" + dni + ", is_admin=" + is_admin + "]";
	}
	
}
