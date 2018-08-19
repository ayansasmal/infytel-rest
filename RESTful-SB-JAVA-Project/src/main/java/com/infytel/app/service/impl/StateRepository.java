package com.infytel.app.service.impl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infytel.app.entities.State;

public interface StateRepository extends CrudRepository<State, String> {
	
	/**
	 * Retrieve all states belonging to the provided country code
	 * 
	 * @param countryCode
	 * @return
	 */
	List<State> findAllByCode(String code);

}
