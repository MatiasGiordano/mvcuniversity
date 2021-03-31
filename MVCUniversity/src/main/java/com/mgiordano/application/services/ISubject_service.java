package com.mgiordano.application.services;

import java.util.List;

import com.mgiordano.application.models.subject;

public interface ISubject_service {
	public subject add_subject(subject sbj);
	
	public Boolean exist_subject(Long id);
	
	public subject delete_subject(Long id);
	
	public subject modify_subject(subject sbj, Long id);
	
	public List<subject> get_subjects();
}
