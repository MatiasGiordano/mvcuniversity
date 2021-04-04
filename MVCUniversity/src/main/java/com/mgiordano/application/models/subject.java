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


@Entity
@Table(name="subjects")
public class subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id" )
	private int id;

	@Column(name = "name" )	
	private String name;
	
	@Column(name = "schedule" )
	private Time schedule;
	
	@Column(name = "duration" )
	private Integer duration;
	
	@Column(name = "day" )
	private String day;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
	private professor professor;
	
	@Column(name="professor_id")
	private int professor_id;
	
	@Column(name = "max_students" )
	private Integer max_students;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<inscription> inscriptions;

	
	public subject(int id, String name, Time schedule, Integer duration, String day,
			com.mgiordano.application.models.professor professor, Integer max_students, Set<inscription> inscriptions) {

		this.id = id;
		this.name = name;
		this.schedule = schedule;
		this.duration = duration;
		this.day = day;
		this.professor = professor;
		this.max_students = max_students;
		this.inscriptions = inscriptions;
	}

	public subject() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public professor getProfessor() {
		return professor;
	}
	public void setProfessor(professor professor) {
		this.professor = professor;
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
	public Set<inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Set<inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public String toString() {
		return "subject [id=" + id + ", name=" + name + ", schedule=" + schedule + ", duration=" + duration + ", day="
				+ day + ", professor=" + professor + ", max_students=" + max_students + ", inscriptions=" + inscriptions
				+ "]";
	}


	
	
	
}
