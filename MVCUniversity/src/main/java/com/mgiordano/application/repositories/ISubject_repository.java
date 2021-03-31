package com.mgiordano.application.repositories;

import java.util.List;

import com.mgiordano.application.models.subject;

public interface ISubject_repository {

	public subject Add(subject sbj);

	public Boolean Exist(Long id);

	public subject Delete(Long id);

	public subject Modify(subject sbj, Long id);

	public List<subject> GetSubjects();


}
