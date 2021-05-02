package com.mgiordano.application.services;



import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.user;
import com.mgiordano.application.repositories.IInscription_repository;
import com.mgiordano.application.repositories.IUser_repository;
import com.mgiordano.application.repositories.inscription_repository;
import com.mgiordano.application.repositories.user_repository;


public class user_service implements IUser_service{
	private IUser_repository user_repo = new user_repository();
	private IInscription_repository inscription_repo = new inscription_repository();

	@Override
	public user add_user(user usr) throws RuntimeException{
		try {
			if(usr!=null){
				return user_repo.Add(usr);
			}
			return usr;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Boolean exist_user(Long id) throws RuntimeException{
		try {
			Boolean result= false;
			if(id>0){
				if(user_repo.Exist(id)!=null) {
					result = true;
				}
				return result;		
			}return false;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public user modify_user(user usr, Long id) throws RuntimeException {
		try {
			if((usr != null) && (exist_user(id))){
				user_repo.Modify(usr, id);
				}return usr;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public user delete_user(Long id) throws RuntimeException{
		try {
			if(exist_user(id)) {
				return user_repo.Delete(id);
			}return null;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public user login_user(Long dni, String file, boolean admin) throws RuntimeException{
		try {
			Integer is_admin=(admin)?1:0;
			file = (file!="")?file:"'\'";
			return user_repo.Login(dni, file, is_admin);
		}catch(RuntimeException e){
				throw new RuntimeException(e);
			}

	}

	@Override
	public inscription add_inscription(inscription insc) throws RuntimeException{
		try {
			return inscription_repo.Add(insc);
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public user get_user(int id) throws RuntimeException{
		try {
			return user_repo.Get(id);
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

}
