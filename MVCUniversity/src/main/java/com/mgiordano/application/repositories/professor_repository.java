package com.mgiordano.application.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mgiordano.application.models.professor;

public class professor_repository implements IProfessor_repository{
	private EntityManagerFactory emf;
	private EntityManager manager;

	public professor_repository() {
		this.emf=Persistence.createEntityManagerFactory("MVCDBConfiguration");
		this.manager= emf.createEntityManager();
	}

	@Override
	public professor Add(professor prf) {
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(prf);
			this.manager.getTransaction().commit();
			return prf;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		}

	@Override
	public Boolean Exist(Long id) {
		Boolean result= false;
		try {
			this.manager.getTransaction().begin();
			if(this.manager.find(professor.class, id) !=null) {
				result=true;}
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return result;
	}

	@Override
	public professor Delete(Long id) {
		professor prf= new professor();
		try {
			this.manager.getTransaction().begin();
			prf=(professor)this.manager.find(professor.class, id);
			this.manager.remove(prf);
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return prf;
	}

	@Override
	public professor Modify(professor prf, Long id) {
		professor prf_modify = new professor();
		try {
			this.manager.getTransaction().begin();
			prf_modify = this.manager.find(professor.class, id);
			prf_modify = prf;
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return prf_modify;
	}
	
}
