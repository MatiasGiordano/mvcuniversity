package com.mgiordano.application.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inscriptions")
public class inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id" )
	private Integer id;
	
	@Column(name = "subject_id" )
	private Integer subject_id;
	
	@Column(name = "user_id" )
	private Integer user_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
	private user user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_subject")
	private subject subject;

	
	//Constructors
	public inscription() {
		
	}

	public inscription(Integer id, Integer subject_id, Integer user_id, user user, subject subject) {
		
		this.id = id;
		this.subject_id = subject_id;
		this.user_id = user_id;
		this.user = user;
		this.subject = subject;
	}
	
	//Getters, Setters, toString

	public Integer getId() {
		return id;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public subject getSubject() {
		return subject;
	}

	public void setSubject(subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Inscription1 [id=" + id + ", subject_id=" + subject_id + ", user_id=" + user_id + ", user=" + user
				+ ", subject=" + subject + "]";
	}

}
