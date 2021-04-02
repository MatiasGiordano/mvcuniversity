package com.mgiordano.application.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mgiordano.application.models.subject;

public class subject_repository implements ISubject_repository{
	private EntityManagerFactory emf;
	private EntityManager manager;
	
	public subject_repository() {
		this.emf=Persistence.createEntityManagerFactory("MVCDBConfiguration");
		this.manager= emf.createEntityManager();
}
	@Override
	public subject Add(subject sbj) {
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(sbj);
			this.manager.getTransaction().commit();
			return sbj;
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
			return null;
		}
	}
	@Override
	public Boolean Exist(Long id) {
		Boolean result= false;
		try {
			this.manager.getTransaction().begin();
			if(this.manager.find(subject.class, id) !=null) {
				result=true;}
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return result;
	}
	@Override
	public subject Delete(Long id) {
		subject sbj= new subject();
		try {
			this.manager.getTransaction().begin();
			sbj=(subject)this.manager.find(subject.class, id);
			this.manager.remove(sbj);
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return sbj;
	}
	@Override
	public subject Modify(subject sbj, Long id) {
		subject sbj_modify = new subject();
		try {
			this.manager.getTransaction().begin();
			sbj_modify = this.manager.find(subject.class, id);
			sbj_modify = sbj;
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return sbj_modify;
	}
	
	@SuppressWarnings("unchecked")   //borra los warnings que no pueden ser chequeados en modo diseño
	@Override
	public List<subject> GetSubjects() {
		List<subject> result;
		try {
			this.manager.getTransaction().begin();
			result= this.manager.createQuery("FROM subject").getResultList();
			this.manager.getTransaction().commit();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return null;
	}

		}
	


