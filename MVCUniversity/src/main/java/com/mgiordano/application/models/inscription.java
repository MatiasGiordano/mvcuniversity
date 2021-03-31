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
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
	private subject subject;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
	private user user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public subject getSubject() {
		return subject;
	}

	public void setSubject(subject subject) {
		this.subject = subject;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public inscription() {
		
	}
	
	public inscription(int id, subject subject, user user) {
		this.id = id;
		this.subject = subject;
		this.user = user;
	}

	@Override
	public String toString() {
		return "inscription [id=" + id + ", subject=" + subject + ", user=" + user + "]";
	}
	

	
}
