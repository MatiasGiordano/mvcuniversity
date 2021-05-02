package com.mgiordano.application.services;

import java.util.List;
import com.mgiordano.application.models.subject;
import com.mgiordano.application.repositories.ISubject_repository;
import com.mgiordano.application.repositories.subject_repository;

public class subject_service implements ISubject_service{
		
	private ISubject_repository subject_repo= new subject_repository();

	@Override
	public subject add_subject(subject sbj) throws RuntimeException{
		try {
			if(sbj!=null) {
				return subject_repo.Add(sbj);
			}return sbj;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean exist_subject(Integer id) throws RuntimeException{
		try {
			Boolean result= false;
			if(id>0) {
				if(subject_repo.Exist(id) != null) {
					result= true;
				}		
			}return result;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public subject delete_subject(Integer id) throws RuntimeException{
		try {
			if(exist_subject(id)){
				return subject_repo.Delete(id);
			}return null;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public subject modify_subject(subject sbj, Integer id) throws RuntimeException{
		try {
			if((sbj!=null)&&(exist_subject(id))) {
				return subject_repo.Modify(sbj, id);
			}return sbj;
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<subject> get_subjects() throws RuntimeException{
		try {
			return subject_repo.GetSubjects();
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
