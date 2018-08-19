package com.infytel.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ErrorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2494796370550892047L;
	private List<ErrorDetail> errors = new ArrayList<>();

	/**
	 * @return the errors
	 */
	public List<ErrorDetail> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
