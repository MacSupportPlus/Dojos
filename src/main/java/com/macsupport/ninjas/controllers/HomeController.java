package com.macsupport.ninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.macsupport.ninjas.models.Dojo;
import com.macsupport.ninjas.models.Ninja;
import com.macsupport.ninjas.services.DojoService;
import com.macsupport.ninjas.services.NinjaService;


@Controller
public class HomeController {
	private static DojoService dojoServ;
	private static NinjaService ninServ;
	
	public HomeController(DojoService dojoServ, NinjaService ninServ) {
		this.dojoServ = dojoServ;
		this.ninServ = ninServ;
	}
	
	@GetMapping("/dojos") 
	public String index(Model model) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "dojo.jsp"; 
	}
	
	@GetMapping("/create")
	public String createAll(Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
;		model.addAttribute("newNinja", new Ninja());
		model.addAttribute("newDojo", new Dojo());
		return "index.jsp";
	}
	@PostMapping("/dojos/create")
	public String create(@ModelAttribute("newDojo") Dojo newDojo, Model model, Long id) {
		dojoServ.create(newDojo, id);
		return "redirect:/dojos/" + id;
	}
	@GetMapping("/dojos/{id}")
	public String dojosDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleDojo", dojoServ.getOne(id));
		model.addAttribute("allNinjas", ninServ.getAll());
		return "dojo.jsp";
	}
	@GetMapping("/dojos/edit/{id}")
	public String dojoEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleDojo", dojoServ.getOne(id));
		return "edit.jsp";
	}
	
	@PostMapping("/dojos/update/{id}")
	public String updateDojo(@PathVariable("id") Long id, @ModelAttribute("singleDojo") Dojo singleDojo) {
    	dojoServ.update(singleDojo, id);
    	return "redirect:/dojos/" + id ;
    }	
	@PostMapping("/ninjas/create")
	public String ninjaCreate(@ModelAttribute("newNinja") Ninja newNinja, Model model, Long id) {
		ninServ.ninjaCreate(newNinja, id);
		return "redirect:/dojos/" + id;
	}
	//@PostMapping("/languages/{id}/delete")
	@RequestMapping(value="/dojos/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		dojoServ.deleteDojo(id);
		return "redirect:/dojos";
	}

	

}
