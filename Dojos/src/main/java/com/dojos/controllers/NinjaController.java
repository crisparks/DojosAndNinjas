package com.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojos.models.Ninja;
import com.dojos.services.DojoNinjaServ;

@Controller
public class NinjaController {
	private final DojoNinjaServ dojoNinjaServ;
	
	public NinjaController(DojoNinjaServ dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObject") Ninja Ninja, Model model) {
		model.addAttribute("dojos", dojoNinjaServ.getAllDojos());
		return "newninja.jsp";
	}
	
	@PostMapping("/addninja")
	public String addNinja(@Valid @ModelAttribute("ninjaObject") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			dojoNinjaServ.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId() ;
		}
	}
}