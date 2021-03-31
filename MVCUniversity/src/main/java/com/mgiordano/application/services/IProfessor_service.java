package com.mgiordano.application.services;

import com.mgiordano.application.models.professor;

public interface IProfessor_service {
	public professor add_professor(professor prf);
	
	public Boolean exist_professor(Long id);
	
	public professor delete_professor(Long id);
	
	public professor modify_professor(professor prf, Long id);
}
