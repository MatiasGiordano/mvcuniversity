package com.mgiordano.application.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="professors")
public class professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	
	@Size(min=3, message="El campo debe tener al menos 3 caracteres")
	@Column(name = "name")
	private String name;
	
	
	@Size(min=3, message="El campo debe tener al menos 3 caracteres")
	@Column(name= "last_name")
	private String last_name;
	
	
	@Size(min=6, message="El campo debe tener al menos 6 caracteres")
	@Column(name = "dni")
	private Long dni;
	
	
	@NotNull(message= "El campo no puede ser nulo")
	@Column(name = "is_active" )
	private Boolean is_active;

	@OneToMany(mappedBy="professor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<subject> subjects;

	//Constructors
	
	public professor() {
	
	}
	
	public professor(Integer id, String name, String last_name, Long dni, Boolean is_active, Set<subject> subjects) {
		
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.dni = dni;
		this.is_active = is_active;
		this.subjects = subjects;
	}

	
	//Getter, Setters, toString

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public Long getDni() {
		return dni;
	}
	
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	public Boolean getIs_active() {
		return is_active;
	}
	
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	public Set<subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Professor1 [id=" + id + ", name=" + name + ", last_name=" + last_name + ", dni=" + dni + ", is_active="
				+ is_active + ", subjects=" + subjects + "]";
	}


}
