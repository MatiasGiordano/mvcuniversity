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
@Table(name="professors")
public class professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id" )
	private int id;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "last_name" )
	private String last_name;
	
	@Column(name = "dni" )
	private long dni;
	
	@Column(name = "is_active" )
	private boolean is_active;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private Set<subject> subject;
	
	public Set<subject> getSubject() {
		return subject;
	} 
	public void setSubject(Set<subject> subject) {
		this.subject = subject;
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
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public professor() {

	}
	public professor(int id, String name, String last_name, long dni, boolean is_active,
			Set<subject> subject) {

		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.dni = dni;
		this.is_active = is_active;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "professor [id=" + id + ", name=" + name + ", last_name=" + last_name + ", dni=" + dni + ", is_active="
				+ is_active + ", subject=" + subject + "]";
	}
	
	
}
