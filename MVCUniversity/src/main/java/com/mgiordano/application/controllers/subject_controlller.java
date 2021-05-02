package com.mgiordano.application.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.professor;
import com.mgiordano.application.models.subject;
import com.mgiordano.application.models.subject_DTO;
import com.mgiordano.application.services.IProfessor_service;
import com.mgiordano.application.services.ISubject_service;
import com.mgiordano.application.services.IUser_service;
import com.mgiordano.application.services.professor_service;
import com.mgiordano.application.services.subject_service;
import com.mgiordano.application.services.user_service;
import jakarta.validation.Valid;



@Controller
public class subject_controlller {
	

	private ISubject_service subject_serv= new subject_service();	
	private IProfessor_service professor_serv= new professor_service();
	private IUser_service user_serv= new user_service();
	
	//DASHBOARD MAPPING 
	@GetMapping(value="/dashboard")
	public String dashboard(Model model) {
		List<subject> sbjs = subject_serv.get_subjects();
		List<professor> prfs = professor_serv.get_professors();
		
		model.addAttribute("insc_new", new inscription());
		model.addAttribute("sbjs", sbjs);
		model.addAttribute("subject", new subject_DTO()); 
		model.addAttribute("prfs", prfs);
		model.addAttribute("prf", new professor());
		return "dashboard";
	}
	
	//SUBJECT REGISTER 
	@PostMapping(value="/subject_register/{id}")
	public String subject_register(@PathVariable int id,@Valid @ModelAttribute subject_DTO sbj, BindingResult validation_result,Model model) {
		subject new_sbj = new subject();
		model.addAttribute("usr", user_serv.get_user(id));
		new_sbj.setName(sbj.getName());
		new_sbj.setSchedule(sbj.getSchedule());
		new_sbj.setDay(sbj.getDay());
		new_sbj.setDuration(sbj.getDuration());
		new_sbj.setProfessor_id(sbj.getProfessor_id());
		new_sbj.setProfessor(professor_serv.get_professor(new_sbj.getProfessor_id()));
		new_sbj.setMax_students(sbj.getMax_students());
		if(validation_result.hasErrors()) {
			return dashboard(model);
		}else {
			try {
				subject_serv.add_subject(new_sbj);
				return dashboard(model);
			}catch(RuntimeException e) {
				model.addAttribute("sbjreg_error","ERROR AL REGISTRAR MATERIA");
				return dashboard(model);}
		}
	}
	
	//SUBJECT DELETE
	@PostMapping("/subject_delete/{id}")
	public String subject_delete(@PathVariable Integer id, @ModelAttribute Model model) {
		try {

			subject_serv.delete_subject(id);
			return dashboard(model);
		}catch(RuntimeException e) {
			model.addAttribute("sbjdel_error", "ERROR AL ELIMINAR MATERIA");
			return dashboard(model);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
