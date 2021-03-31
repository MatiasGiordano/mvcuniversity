package com.mgiordano.application.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.login_DTO;
import com.mgiordano.application.models.subject;
import com.mgiordano.application.models.user;
import com.mgiordano.application.services.ISubject_service;
import com.mgiordano.application.services.IUser_service;
import com.mgiordano.application.services.subject_service;
import com.mgiordano.application.services.user_service;

@Controller
public class mvc_controller {
	IUser_service user_serv = new user_service();
	ISubject_service subject_serv = new subject_service();
	
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
		
		model.addAttribute("sbj_new", new subject());
		model.addAttribute("insc_new", new inscription());
		model.addAttribute("sbjs", sbjs);
		model.addAttribute("materia", new subject()); //agregar materia en modal
		return "dashboard";
	}
	
	@PostMapping(value="/dashboard")
	public String subject_dashboard(@ModelAttribute subject sbj, Model model) {
		subject_serv.add_subject(sbj);
		return dashboard(null, model);
	}
	
	
	
	

}