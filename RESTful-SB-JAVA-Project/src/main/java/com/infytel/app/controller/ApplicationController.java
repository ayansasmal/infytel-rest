package com.infytel.app.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.app.entities.SIM;
import com.infytel.app.entities.State;
import com.infytel.app.model.CustomerBean;
import com.infytel.app.model.ErrorBean;
import com.infytel.app.model.ErrorDetail;
import com.infytel.app.model.Request;
import com.infytel.app.model.Response;
import com.infytel.app.service.impl.ApplicationServiceImpl;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestController
public class ApplicationController {

	private static final String FAILURE_STATUS = "failure";

	private static final String SUCCESS_STATUS = "success";

	private static final String GET_ALL_STATES = "getAllStates";

	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	ApplicationServiceImpl service;

	@GetMapping(path = "/")
	public ResponseEntity<Response<String>> healthCheck() {
		logger.debug("In HealthCheck");
		return new ResponseEntity(new Response<String>(), HttpStatus.OK);
	}

	@GetMapping(path = "login")
	public Principal user(Principal user) {
		return user;
	}

	@GetMapping(path = "getAllStates/{countryCode}", produces = "application/json")
	public ResponseEntity<Response> getAllStates(@PathVariable String countryCode) {
		try {
			List<State> states;
			if (StringUtils.isNotBlank(countryCode) && !StringUtils.equalsIgnoreCase(countryCode, "all")) {
				states = service.getAllStatesByCountryCode(countryCode);
			} else {
				states = service.getAllStates();
			}
			Response<List<State>> response = new Response<>();
			response.setData(states);
			response.setResource(GET_ALL_STATES);
			response.setStatus(SUCCESS_STATUS);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception while getAllstates {}", e.getMessage(), e);
			Response<ErrorBean> errorResponse = new Response<>();
			ErrorBean errBean = new ErrorBean();
			ErrorDetail err = new ErrorDetail();
			errBean.getErrors().add(err);
			errorResponse.setData(errBean);
			errorResponse.setResource(GET_ALL_STATES);
			errorResponse.setStatus(FAILURE_STATUS);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "getInactiveSIM", produces = "application/json")
	public ResponseEntity<Response> getAllInActiveSIMs() {
		try {
			List<SIM> inactiveSims = service.getAllInactiveSims();
			Response<List<SIM>> response = new Response<>();
			response.setData(inactiveSims);
			response.setResource("getInactiveSIM");
			response.setStatus(SUCCESS_STATUS);
			if (inactiveSims.isEmpty()) {
				logger.error("No inactive SIMS available");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Exception while getInactiveSIM {}", e.getMessage(), e);
			Response<ErrorBean> errorResponse = new Response<>();
			ErrorBean errBean = new ErrorBean();
			ErrorDetail err = new ErrorDetail();
			errBean.getErrors().add(err);
			errorResponse.setData(errBean);
			errorResponse.setResource("getInactiveSIM");
			errorResponse.setStatus(FAILURE_STATUS);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "validateId", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Response> validateId(@RequestBody @Valid Request<CustomerBean> request) {
		logger.debug("validateId request {}", request);
		CustomerBean customerDetails = request.getData();
		try {
			boolean isValid = service.isValidIdDetails(customerDetails);
			Response<Boolean> response = new Response<>();
			response.setData(isValid);
			response.setResource("validateId");
			response.setStatus(SUCCESS_STATUS);
			if (isValid) {
				return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			Response<ErrorBean> errorResponse = new Response<>();
			ErrorBean errBean = new ErrorBean();
			ErrorDetail err = new ErrorDetail();
			errBean.getErrors().add(err);
			errorResponse.setData(errBean);
			errorResponse.setResource("validateId");
			errorResponse.setStatus(FAILURE_STATUS);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "activateSIM", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Response> activateSIM(@RequestBody @Valid Request<CustomerBean> request) {
		CustomerBean customerDetails = request.getData();
		try {
			CustomerBean savedCustomer = service.activateSIM(customerDetails);
			Response<CustomerBean> response = new Response<>();
			response.setData(savedCustomer);
			response.setResource("activateSIM");
			response.setStatus(SUCCESS_STATUS);
			if (savedCustomer != null && StringUtils.isNotBlank(savedCustomer.getCustomerId())) {
				return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			logger.error("Exception while activating sim {}", e.getMessage(), e);
			Response<ErrorBean> errorResponse = new Response<>();
			ErrorBean errBean = new ErrorBean();
			ErrorDetail err = new ErrorDetail();
			errBean.getErrors().add(err);
			errorResponse.setData(errBean);
			errorResponse.setResource("activateSIM");
			errorResponse.setStatus(FAILURE_STATUS);
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
