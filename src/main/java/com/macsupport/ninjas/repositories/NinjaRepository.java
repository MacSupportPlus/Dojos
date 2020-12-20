package com.macsupport.ninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.macsupport.ninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja,Long> {

}
