package com.infytel.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.repository.CrudRepository;

@Entity
@Table(name = "tbl_sim")
public class SIM implements Serializable {

	public interface StateRepository extends CrudRepository<State, String> {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4523383640342551816L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String simNumber;
	private String activationDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the simNumber
	 */
	public String getSimNumber() {
		return simNumber;
	}

	/**
	 * @param simNumber the simNumber to set
	 */
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	/**
	 * @return the activationDate
	 */
	public String getActivationDate() {
		return activationDate;
	}

	/**
	 * @param activationDate the activationDate to set
	 */
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
