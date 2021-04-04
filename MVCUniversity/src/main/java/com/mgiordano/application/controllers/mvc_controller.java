package com.mgiordano.application.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.login_DTO;
import com.mgiordano.application.models.professor;
import com.mgiordano.application.models.subject;
import com.mgiordano.application.models.user;
import com.mgiordano.application.services.IProfessor_service;
import com.mgiordano.application.services.ISubject_service;
import com.mgiordano.application.services.IUser_service;
import com.mgiordano.application.services.professor_service;
import com.mgiordano.application.services.subject_service;
import com.mgiordano.application.services.user_service;

@Controller
public class mvc_controller {
	IUser_service user_serv = new user_service();
	ISubject_service subject_serv = new subject_service();
	IProfessor_service professor_serv = new professor_service();
	
	@GetMapping(value="/")
	public String home(Locale locale, Model model) {
		model.addAttribute("DTO", new login_DTO());
		return "index";	
	}
	@PostMapping(value="/login")
	public String user_login(@ModelAttribute login_DTO DTO, Model model) {
		user usr= user_serv.login_user(DTO.getDni(), DTO.getFile(), DTO.isAdmin());
		if(usr!=null) {	
			model.addAttribute("usr", usr);
			return dashboard(null, model);
		}else {
		
			return home(null, model);
		}
	}

	@GetMapping(value="/user_register")
	public String user_register(Locale locale, Model model) {
		model.addAttribute("usr", new user());
		return "register";
	}
	
	@PostMapping(value="/user_register")
	public String user_register(@ModelAttribute user usr, Model model) {
		user_serv.add_user(usr);
		return home(null, model);
	}
	


	@GetMapping(value="/dashboard")
	public String dashboard(Locale locale, Model model) {
		List<subject> sbjs = subject_serv.get_subjects();
		List<professor> prfs = professor_serv.get_professors();
		
		model.addAttribute("sbj_new", new subject());
		model.addAttribute("insc_new", new inscription());
		model.addAttribute("sbjs", sbjs);
		model.addAttribute("materia", new subject()); 
		model.addAttribute("prfs", prfs);
		model.addAttribute("prf", new professor());
		return "dashboard";
	}
	
	@PostMapping(value="/dashboard")
	public String subject_dashboard(@ModelAttribute subject sbj, Model model) {
		subject_serv.add_subject(sbj);
		return dashboard(null, model);
	}
	@PostMapping(value="/user_insc")
	public String user_insc(@ModelAttribute inscription insc, Model model) {
		user_serv.add_inscription(insc);
		return dashboard(null, model);
	}
	
	@PostMapping(value="/professor_register/{id}")
	public String professor_register(@PathVariable int id, @ModelAttribute professor prf, Model model) {
		prf.setId(0);   //agrego esto por error en el id al agregar profes
		professor_serv.add_professor(prf);
		model.addAttribute("usr", user_serv.get_user(id));
		return dashboard(null, model);
	}
	
	

}
