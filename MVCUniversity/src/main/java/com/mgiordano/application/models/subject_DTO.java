package com.mgiordano.application.models;

import java.sql.Date;

public class subject_DTO {
	private String name;
	private Date schedule;
	private int duration;
	private String professor;
	private int max_students;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getSchedule() {
		return schedule;
	}
	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getMax_students() {
		return max_students;
	}
	public void setMax_students(int max_students) {
		this.max_students = max_students;
	}




}

