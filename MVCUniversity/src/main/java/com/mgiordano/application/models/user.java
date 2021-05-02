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

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "users")
public class user {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@NotNull(message= "El campo no puede ser nulo")
	@Size(min=5, message="El campo debe tener al menos 5 caracteres")
	@Column(name = "name")
	private String name;
	
	@Size(min=7, max=7, message="El campo debe tener 7 caracteres, Ej: nnn-nnn")
	@Column(name = "[file]" )
	private String file;
	
	@NotNull(message= "El campo no puede ser nulo")
	@Size(min=6, message="El campo debe tener al menos 6 caracteres")
	@Column(name = "dni" )
	private Long dni;
	
	@NotNull(message= "El campo no puede ser nulo")
	@Column(name = "is_admin" )
	private Boolean is_admin;
	
	@OneToMany(mappedBy= "user",  cascade = CascadeType.ALL)
	private Set<inscription> inscriptions;

	
	//Constructors
	
	public user() {
		
	}

	public user(Integer id, String name, String file, Long dni, Boolean is_admin, Set<inscription> inscriptions) {
		
		this.id = id;
		this.name = name;
		this.file = file;
		this.dni = dni;
		this.is_admin = is_admin;
		this.inscriptions = inscriptions;
	}

	//Getters, Setters, toString
	
	public Integer getId() {
		return id;
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


	public Long getDni() {
		return dni;
	}


	public void setDni(Long dni) {
		this.dni = dni;
	}


	public Boolean getIs_admin() {
		return is_admin;
	}


	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}


	public Set<inscription> getInscriptions() {
		return inscriptions;
	}


	public void setInscriptions(Set<inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	
	@Override
	public String toString() {
		return "User1 [id=" + id + ", name=" + name + ", file=" + file + ", dni=" + dni + ", is_admin=" + is_admin
				+ "]";
	}	
	
	
}
