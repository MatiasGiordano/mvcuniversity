package com.mgiordano.application.repositories;

import javax.persistence.*;
import com.mgiordano.application.models.user;

public class user_repository implements IUser_repository{
	private EntityManagerFactory emf;
	private EntityManager manager;

	@Override
	public user Add(user usr) {
		try {
			this.manager.getTransaction().begin();   
			this.manager.merge(usr);                 
			this.manager.getTransaction().commit();
			
			return usr;
			
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
			return null;
		}
	}
	
	public user_repository() {
		this.emf=Persistence.createEntityManagerFactory("MVCDBConfiguration");
		this.manager=emf.createEntityManager();
		
	}

	@Override
	public user Login(Long dni, String file, boolean admin) {
		Integer is_admin=(admin)?1:0;     //operador ternario para convertir true/false a 1/0 (SQL)
		user usr; 
		file = (file!="")?file:"'\'";
		try {
			this.manager.getTransaction().begin();
			usr= (user)this.manager.createQuery("from user u where ((u.is_admin="+is_admin.toString()+") and (u.dni="+dni.toString()+")) or ((u.is_admin="+is_admin.toString()+") and (u.dni="+dni.toString()+") and (u.file="+file+"))").getSingleResult();
			this.manager.getTransaction().commit();
			return usr;
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public user Modify(user usr, Long id) {
		
		user usr_modify = new user();
		try {
		this.manager.getTransaction().begin();
		usr_modify=this.manager.find(user.class, id);
		usr_modify = usr ;
		this.manager.getTransaction().commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return usr_modify;
	}
		
	@Override
	public Boolean Exist(Long id) {
		Boolean result= false;
		try {
			this.manager.getTransaction().begin();
			if(this.manager.find(user.class, id) !=null) {
				result=true;}
			this.manager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return result;
	}

	@Override
	public user Delete(Long id) {
		user usr= new user();
		try {
			this.manager.getTransaction().begin();
			usr= (user)this.manager.find(user.class, id);
			this.manager.remove(usr);
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}return usr;
	}
	
}
