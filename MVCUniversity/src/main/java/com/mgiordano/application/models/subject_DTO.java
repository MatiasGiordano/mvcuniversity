package com.mgiordano.application.models;


import java.sql.Time;

public class subject_DTO {
	private String name;
	private Time schedule;
	private String day;
	private Integer duration;
	private Integer professor_id;
	private Integer max_students;

	public subject_DTO() {
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
	public void setMax_students(Integer  max_students) {
		this.max_students = max_students;
	}
	
	
	

}

