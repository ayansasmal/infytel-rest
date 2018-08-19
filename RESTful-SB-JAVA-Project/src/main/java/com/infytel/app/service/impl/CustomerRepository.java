package com.infytel.app.service.impl;

import org.springframework.data.repository.CrudRepository;

import com.infytel.app.model.CustomerBean;

public interface CustomerRepository extends CrudRepository<CustomerBean, String> {

}
