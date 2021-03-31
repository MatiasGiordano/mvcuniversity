package com.mgiordano.application.services;

import java.util.List;

import com.mgiordano.application.models.subject;
import com.mgiordano.application.repositories.ISubject_repository;
import com.mgiordano.application.repositories.subject_repository;

public class subject_service implements ISubject_service{
	private ISubject_repository subject_repo = new subject_repository();

	@Override
	public subject add_subject(subject sbj) {
		if(sbj!=null) {
			return subject_repo.Add(sbj);
		}return sbj;
	}

	@Override
	public Boolean exist_subject(Long id) {
		if(id>0) {
			return subject_repo.Exist(id);
		}return false;
	}

	@Override
	public subject delete_subject(Long id) {
		if(subject_repo.Exist(id)) {
			return subject_repo.Delete(id);
		}return null;
	}

	@Override
	public subject modify_subject(subject sbj, Long id) {
		if((sbj!=null)&&(subject_repo.Exist(id))) {
			return subject_repo.Modify(sbj, id);
		}return sbj;
	}

	@Override
	public List<subject> get_subjects() {
		return subject_repo.GetSubjects();
	}
	
	
}
