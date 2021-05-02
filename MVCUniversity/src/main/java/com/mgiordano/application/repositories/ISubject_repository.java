package com.mgiordano.application.repositories;

import java.util.List;
import com.mgiordano.application.models.subject;

public interface ISubject_repository {

	public subject Add(subject sbj);

	public subject Exist(Integer id);

	public subject Delete(Integer id);

	public subject Modify(subject sbj, Integer id);

	public List<subject> GetSubjects();


}
