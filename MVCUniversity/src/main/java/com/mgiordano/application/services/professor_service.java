package com.mgiordano.application.services;

import java.util.List;

import com.mgiordano.application.models.professor;
import com.mgiordano.application.repositories.IProfessor_repository;
import com.mgiordano.application.repositories.professor_repository;

public class professor_service implements IProfessor_service{
	private IProfessor_repository professor_repo = new professor_repository();

	@Override
	public professor add_professor(professor prf) {
		if(prf !=null) {
			return professor_repo.Add(prf);
		}return prf;
	}

	@Override
	public Boolean exist_professor(Long id) {
		if(id>0) {
			return professor_repo.Exist(id);
		}return false;
	}
	

	@Override
	public professor delete_professor(Long id) {
		if(professor_repo.Exist(id)) {
			return professor_repo.Delete(id);
		}return null;
	}

	@Override
	public professor modify_professor(professor prf, Long id) {
		if((prf!=null)&&(professor_repo.Exist(id))) {
			return professor_repo.Modify(prf, id);
		}return prf;
	}

	@Override
	public List<professor> get_professors() {
		return professor_repo.GetProfessors();
	}

}
