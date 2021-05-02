package com.mgiordano.application.repositories;

import javax.persistence.*;
import com.mgiordano.application.models.user;

public class user_repository implements IUser_repository{
	private EntityManagerFactory emf;
	private EntityManager manager;

	public user_repository() {
		this.emf=Persistence.createEntityManagerFactory("MVCDBConfiguration");
		this.manager=emf.createEntityManager();
		
	}
	
	@Override
	public user Add(user usr) throws RuntimeException {
		try {
			this.manager.getTransaction().begin(); 
			this.manager.merge(usr);                 
			this.manager.getTransaction().commit();
			
			return usr;
			
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e); 
		}
	}
	
	@Override
	public user Login(Long dni, String file, Integer is_admin) throws RuntimeException {
		user usr; 
		try {
			this.manager.getTransaction().begin();
			usr= (user)this.manager.createQuery("from user u where ((u.is_admin="+is_admin.toString()+") and (u.dni="+dni.toString()+")) or ((u.is_admin="+is_admin.toString()+") and (u.dni="+dni.toString()+") and (u.file="+file+"))").getSingleResult();
			this.manager.getTransaction().commit();
			return usr;
		}catch(Exception e) {
			
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public user Modify(user usr, Long id) throws RuntimeException{
		
		user usr_modify = new user();
		try {
			this.manager.getTransaction().begin();
			usr_modify=this.manager.find(user.class, id);
			usr_modify = usr ;
			this.manager.getTransaction().commit();
			return usr_modify;
		}catch(Exception e) {
			
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
		
	@Override
	public user Exist(Long id) throws RuntimeException{
		user usr= new user();
		try {
			this.manager.getTransaction().begin();
			usr= this.manager.find(user.class, id);
			this.manager.getTransaction().commit();
			return usr;
			
		}catch (Exception e) {
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public user Delete(Long id) throws RuntimeException{
		user usr= new user();
		try {
			this.manager.getTransaction().begin();
			usr= (user)this.manager.find(user.class, id);
			this.manager.remove(usr);
			this.manager.getTransaction().commit();
			return usr;
			
		}catch(Exception e) {
			
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public user Get(int id) throws RuntimeException{
		user usr=null;
		try {
			this.manager.getTransaction().begin();
			usr=this.manager.find(user.class, id);
			this.manager.getTransaction().commit();
			return usr;
			
		}catch(Exception e) {
		
			this.manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}
	
}
