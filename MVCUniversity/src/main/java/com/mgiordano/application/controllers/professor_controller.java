package com.mgiordano.application.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.mgiordano.application.models.professor;
import com.mgiordano.application.services.IProfessor_service;
import com.mgiordano.application.services.IUser_service;
import com.mgiordano.application.services.professor_service;
import com.mgiordano.application.services.user_service;

import jakarta.validation.Valid;

@Controller
public class professor_controller {

	private IProfessor_service professor_serv= new professor_service();
	private IUser_service user_serv= new user_service();
	private subject_controlller controller2= new subject_controlller();
	
	//PROFESSOR REGISTER
	@PostMapping(value="/professor_register/{id}")
	public String professor_register(@PathVariable int id,@Valid @ModelAttribute professor prf, BindingResult validation_result, Model model) { 								
		model.addAttribute("usr", user_serv.get_user(id));
		if(validation_result.hasErrors()) {
			return controller2.dashboard(model);
		}else {
			try {
				professor_serv.add_professor(prf);
				return controller2.dashboard(model);
			}catch(RuntimeException e) {
				model.addAttribute("prfreg_error", "ERROR AL REGISTRAR PROFESOR");
				return controller2.dashboard(model);
			}
		}
	}
	//PROFESSOR DELETE    (Without implementation)	
	@PostMapping(value="/professor_delete/{id}")	
	public String professor_delete(@PathVariable int id, @ModelAttribute Long id_prf, Model model) {
		try{
			model.addAttribute("usr", user_serv.get_user(id));
			professor_serv.delete_professor(id_prf);
			return controller2.dashboard(model);
		}catch(RuntimeException e) {
			model.addAttribute("prfdel_error", "ERROR AL REGISTRAR PROFESOR");	
			return controller2.dashboard(model);
		}
	}
	

}