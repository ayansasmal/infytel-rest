package com.infytel.app.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.app.entities.SIM;
import com.infytel.app.entities.State;
import com.infytel.app.model.CustomerBean;
import com.infytel.app.model.IdentityDetails;

@Service
public class ApplicationServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	SIMRepository simRepo;

	@Autowired
	IdentityDetailsRepository idRepo;

	@Autowired
	CustomerRepository customerRepo;

	public List<State> getAllStatesByCountryCode(String countryCode) {
		logger.debug("fetching all states for {}", countryCode);
		List<State> states = stateRepo.findAllByCode(countryCode);
		logger.debug("Fetched states are {}", states);
		return states;
	}

	public List<State> getAllStates() {
		logger.debug("fetching all states");
		List<State> states = (List<State>) stateRepo.findAll();
		logger.debug("Fetched states are {}", states);
		return states;
	}

	public List<SIM> getAllInactiveSims() {
		logger.debug("fetching all sim numbers");
		List<SIM> inactiveSims = simRepo.findAllByActivationDate("");
		logger.debug("Fetched inactive sim {}", inactiveSims);
		return inactiveSims;
	}

	public boolean isValidIdDetails(CustomerBean customer) {
		logger.debug("fetching idDetails for the {}", customer.getIdentityDetails());
		IdentityDetails fetchedIdDetails = idRepo.findByIdentityNumber(customer.getIdentityDetails().getIdentityNumber().toUpperCase());
		logger.debug("Fetched idDetails {}", fetchedIdDetails);
		if(fetchedIdDetails==null) {
			return false;
		}
		return StringUtils.equalsIgnoreCase(fetchedIdDetails.getFirstName(), customer.getFirstName())
				&& StringUtils.equalsIgnoreCase(fetchedIdDetails.getLastName(), customer.getLastName())
				&& StringUtils.equalsIgnoreCase(fetchedIdDetails.getDateOfBirth(), customer.getDateOfBirth());
	}
	
	public CustomerBean activateSIM(CustomerBean customerBean) {
		logger.debug("Inserting customer data {}", customerBean);
		simRepo.save(customerBean.getSim());
		CustomerBean savedCustomerBean= customerRepo.save(customerBean);
		logger.debug("Saved Customer {}", savedCustomerBean);
		return savedCustomerBean;
	}
}
