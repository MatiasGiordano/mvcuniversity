package com.mgiordano.application.repositories;

import java.util.List;

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
	public professor Add(professor prf) throws RuntimeException{
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(prf);
			this.manager.getTransaction().commit();
			return prf;
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor Exist(Long id) throws RuntimeException{
		professor prf= new professor();
		try {
			this.manager.getTransaction().begin();
			prf = this.manager.find(professor.class, id);
			this.manager.getTransaction().commit();
			return prf;
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor Delete(Long id) throws RuntimeException{
		professor prf= new professor();
		try {
			this.manager.getTransaction().begin();
			prf=(professor)this.manager.find(professor.class, id);
			this.manager.remove(prf);
			this.manager.getTransaction().commit();
			return prf;
		}catch(Exception e) {			
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor Modify(professor prf, Long id)  throws RuntimeException{
		professor prf_modify = new professor();
		try {
			this.manager.getTransaction().begin();
			prf_modify = this.manager.find(professor.class, id);
			prf_modify = prf;	
			this.manager.getTransaction().commit();
			return prf_modify;
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			 throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<professor> GetProfessors()  throws RuntimeException{
		List<professor> result;
		try {
			this.manager.getTransaction().begin();
			result= this.manager.createQuery("FROM professor").getResultList();
			this.manager.getTransaction().commit();
			return result;
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor GetProfessor(Integer id)  throws RuntimeException{
		professor prf=null;
		try {
			this.manager.getTransaction().begin();
			prf=this.manager.find(professor.class, id);
			this.manager.getTransaction().commit();
			return prf;
		}catch(Exception e) {	
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}	
	}
	
	
}
