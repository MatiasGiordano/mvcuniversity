package com.mgiordano.application.services;

import com.mgiordano.application.models.user;
import com.mgiordano.application.repositories.IUser_repository;
import com.mgiordano.application.repositories.user_repository;

public class user_service implements IUser_service{
	private IUser_repository user_repo = new user_repository();

	@Override
	public user add_user(user usr) {
		if(usr!=null){
			return user_repo.Add(usr);
		}
		return usr;
	}

	@Override
	public Boolean exist_user(Long id) {
		if(id>0){
			return user_repo.Exist(id);
		}
		return false;
	}

	@Override
	public user modify_user(user usr, Long id) {
		if((usr != null) && (user_repo.Exist(id))){
			user_repo.Modify(usr, id);
		}return usr;
	}

	@Override
	public user delete_user(Long id) {
		if(user_repo.Exist(id)) {
			return user_repo.Delete(id);
		}return null;
	}

	@Override
	public user login_user(Long dni, String file, boolean admin) {
		return user_repo.Login(dni, file, admin);
	}

}
