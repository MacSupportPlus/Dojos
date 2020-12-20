package com.macsupport.ninjas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.macsupport.ninjas.models.Dojo;
import com.macsupport.ninjas.repositories.DojoRepository;


@Service
public class DojoService {

	
	private static DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo create(Dojo newDojo, Long id) {
		return dojoRepo.save(newDojo);
	}
	
	public List<Dojo> getAll() {
		return (List<Dojo>) dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	public Dojo update(Dojo dojoToUpdate, @Valid Long id) {
		 //TODO Auto-generated method stub
		return dojoRepo.save(dojoToUpdate);
	}
	public void deleteDojo(Long id) {
		// TODO Auto-generated method stub
		dojoRepo.deleteById(id);
	}
}

