package com.mgiordano.application.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mgiordano.application.models.inscription;


public class inscription_repository implements IInscription_repository {
	private EntityManagerFactory emf;
	private EntityManager manager;

	public inscription_repository() {
		this.emf=Persistence.createEntityManagerFactory("MVCDBConfiguration");
		this.manager= emf.createEntityManager();
	}

	@Override
	public inscription Add(inscription insc) {
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(insc);
			this.manager.getTransaction().commit();
			return insc;
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
			if(this.manager.find(inscription.class, id) !=null) {
				result=true;}
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return result;
	}

	@Override
	public inscription Delete(Long id) {
		inscription insc= new inscription();
		try {
			this.manager.getTransaction().begin();
			insc=(inscription)this.manager.find(inscription.class, id);
			this.manager.remove(insc);
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return insc;
	}

}
