package com.macsupport.ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.macsupport.ninjas.models.Dojo;
import com.macsupport.ninjas.models.Ninja;
import com.macsupport.ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private static NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo= ninjaRepo;
	}
	
	public Ninja ninjaCreate(Ninja newNinja, Long id) {
		return ninjaRepo.save(newNinja);
	}
	public List<Ninja> getAll() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
}
