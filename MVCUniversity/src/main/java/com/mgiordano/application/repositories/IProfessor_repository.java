package com.mgiordano.application.repositories;

import com.mgiordano.application.models.professor;

public interface IProfessor_repository {

	public professor Add(professor prf);

	public Boolean Exist(Long id);

	public professor Delete(Long id);

	public professor Modify(professor prf, Long id);

}
