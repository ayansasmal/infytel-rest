package com.infytel.app.service.impl;

import org.springframework.data.repository.CrudRepository;

import com.infytel.app.model.IdentityDetails;

public interface IdentityDetailsRepository extends CrudRepository<IdentityDetails, String> {

	IdentityDetails findByIdentityNumber(String identityNumber);
}
