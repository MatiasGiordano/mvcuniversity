package com.mgiordano.application.repositories;

import java.util.List;

import com.mgiordano.application.models.professor;

public interface IProfessor_repository {

	public professor Add(professor prf);

	public professor Exist(Long id);

	public professor Delete(Long id);

	public professor Modify(professor prf, Long id);

	public List<professor> GetProfessors();

	public professor GetProfessor(Integer id);

}
