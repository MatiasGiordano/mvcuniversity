package com.mgiordano.application.services;

import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.user;

public interface IUser_service {
	public user add_user(user usr);
	public Boolean exist_user(Long id);
	public user modify_user(user usr, Long id);
	public user delete_user(Long id);
	public user login_user(Long dni, String file, boolean admin);
	public inscription add_inscription(inscription insc);
	public user get_user(int id);
}
