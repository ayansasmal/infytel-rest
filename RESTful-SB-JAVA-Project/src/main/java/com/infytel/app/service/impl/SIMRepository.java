package com.infytel.app.service.impl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infytel.app.entities.SIM;

public interface SIMRepository extends CrudRepository<SIM, String> {

	List<SIM> findAllByActivationDate(String activationDate);
}
