package com.mgiordano.application.models;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="subjects")
public class subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id" )
	private Integer id;

	@NotNull(message= "El campo no puede ser nulo")
	@Size(min=10, message="El nombre de la materia debe tener al menos 10 caracteres")
	@Column(name = "name" )	
	private String name;
	
	@NotNull(message= "El campo no puede ser nulo")
	@Column(name = "schedule" )
	private Time schedule;	
	
	@NotNull(message= "El campo no puede ser nulo")
	@Size(min=5, message="El campo debe tener al menos 5 caracteres")
	@Column(name = "day" )
	private String day;

	@NotNull(message= "El campo no puede ser nulo")
	@Min(value=60, message="La duración mínima de una clase debe ser de 60 min")
	@Column(name = "duration" )
	private Integer duration;
	
	@Column(name = "professor_id" )
	private Integer professor_id;
	
	@NotNull(message= "El campo no puede ser nulo")
	@Min(value=30, message="La cantidad mínima de cupos debe ser mayor de 29")
	@Column(name = "max_students" )
	private Integer max_students;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_professor")
	private professor professor;

	@OneToMany(mappedBy= "subject",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<inscription> inscriptions;
	
	
	
	//Constructors
	
	public subject() {
		
	}
	
	public subject(Integer id, String name, Time schedule, String day, Integer duration,
			Integer max_students, professor professor, Set<inscription> inscriptions) {
		
		this.id = id;
		this.name = name;
		this.schedule = schedule;
		this.day = day;
		this.duration = duration;

		this.max_students = max_students;
		this.professor = professor;
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

	public Time getSchedule() {
		return schedule;
	}

	public void setSchedule(Time schedule) {
		this.schedule = schedule;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Integer professor_id) {
		this.professor_id = professor_id;
	}

	public Integer getMax_students() {
		return max_students;
	}

	public void setMax_students(Integer max_students) {
		this.max_students = max_students;
	}

	public professor getProfessor() {
		return professor;
	}

	public void setProfessor(professor professor) {
		this.professor = professor;
	}
	
	public Set<inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(Set<inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	
	@Override
	public String toString() {
		return "Subject1 [id=" + id + ", name=" + name + ", schedule=" + schedule + ", day=" + day + ", duration="
				+ duration + ", max_students=" + max_students + ", professor="
				+ professor + "]";
	}

}
