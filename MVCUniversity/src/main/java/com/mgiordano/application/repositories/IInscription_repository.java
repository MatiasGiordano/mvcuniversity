package com.mgiordano.application.repositories;

import com.mgiordano.application.models.inscription;


public interface IInscription_repository {
	public inscription Add(inscription insc);
	
	public Boolean Exist(Long id);
	
	public inscription Delete(Long id);
	
}
