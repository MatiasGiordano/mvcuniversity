package com.mgiordano.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mgiordano.application.models.inscription;
import com.mgiordano.application.models.login_DTO;
import com.mgiordano.application.models.user;
import com.mgiordano.application.services.IUser_service;
import com.mgiordano.application.services.user_service;
import jakarta.validation.Valid;

@Controller
public class user_controller {
	
	private subject_controlller controller2= new subject_controlller();
	
	private IUser_service user_serv= new user_service();
	
	
	
	//USER LOGIN
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("DTO", new login_DTO());
		return "index";	
	}
	@PostMapping(value="/login")
	public String user_login(@ModelAttribute login_DTO DTO, Model model) {
		try {
			user usr= user_serv.login_user(DTO.getDni(), DTO.getFile(), DTO.isAdmin());
			if(usr!=null) {	
				model.addAttribute("usr", usr);
				return controller2.dashboard(model);
			}else {		
				return home(model);}
		}catch(RuntimeException e) {
			model.addAttribute("login_error", "ERROR AL LOGGEAR USUARIO");
			return home(model);
		}
	}
	
	//USER REGISTER
	@GetMapping(value="/user_register")
	public String user_register(Model model) {
		model.addAttribute("usr", new user());
		return "register";
	}
	
	@PostMapping(value="/user_register")
	public String user_register(@Valid @ModelAttribute user usr, BindingResult validation_result, Model model) {
		if(validation_result.hasErrors()) {
			return home(model);
		}else {
			try {
				user_serv.add_user(usr);
				return home(model);
			}catch(RuntimeException e) {
				model.addAttribute("user_error", "ERROR AL GRABAR EL USUARIO");
				return user_register(model);
			}
		}
	}
	
	//USER INSCRIPTION
	@PostMapping(value="/user_insc")
	public String user_insc(@ModelAttribute inscription insc, Model model) {
		try {
			user_serv.add_inscription(insc);
			return controller2.dashboard(model);
		}catch(RuntimeException e) {
			model.addAttribute("insc_error", "ERROR AL INSCRIBIR MATERIA");
			return controller2.dashboard(model);
		}
	}

}
