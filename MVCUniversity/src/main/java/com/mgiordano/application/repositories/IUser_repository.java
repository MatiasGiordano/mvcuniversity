package com.mgiordano.application.repositories;

import com.mgiordano.application.models.user;

public interface IUser_repository {
	public user Add(user usr);
	
	public user Login(Long dni, String file, boolean admin);
	
	public Boolean Exist(Long id);
	
	public user Modify(user usr, Long id);
	
	public user Delete(Long id);

	public user Get(int id);
	

}
