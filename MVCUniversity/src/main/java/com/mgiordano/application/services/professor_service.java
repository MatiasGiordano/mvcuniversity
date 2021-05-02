package com.mgiordano.application.services;

import java.util.List;
import com.mgiordano.application.models.professor;
import com.mgiordano.application.repositories.IProfessor_repository;
import com.mgiordano.application.repositories.professor_repository;


public class professor_service implements IProfessor_service{
	private IProfessor_repository professor_repo = new professor_repository();

	@Override
	public professor add_professor(professor prf) throws RuntimeException{
		try {
			if(prf !=null) {
				return professor_repo.Add(prf);
			}return prf;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean exist_professor(Long id) throws RuntimeException{
		try {
			Boolean result= false; 
			if(id>0) {
				if(professor_repo.Exist(id)!= null) {
					result= true;
				}
			}return result;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public professor delete_professor(Long id) throws RuntimeException{
		try {	
			if(exist_professor(id)) {
				return professor_repo.Delete(id);
			}return null;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor modify_professor(professor prf, Long id) throws RuntimeException{
		try {
			if((prf!=null)&&(exist_professor(id))) {
				return professor_repo.Modify(prf, id);
			}return prf;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<professor> get_professors() throws RuntimeException{
		try {
			return professor_repo.GetProfessors();
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public professor get_professor(Integer id) throws RuntimeException{
		try {
			return professor_repo.GetProfessor(id);
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

}
