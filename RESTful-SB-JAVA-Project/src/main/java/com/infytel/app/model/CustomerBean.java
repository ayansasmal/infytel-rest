package com.infytel.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.infytel.app.entities.SIM;

@Entity
@Table(name = "tbl_customers")
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6957014145481259477L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String customerId;
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;

	private String title;
	@Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String dateOfBirth;
	@NotBlank(message = "Email ID cannot be blank")
	@Email
	private String emailId;

	private String mobileNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull(message = "Address cannot be blank")
	@Valid
	private AddressBean address;

	@OneToOne(cascade = CascadeType.MERGE)
	@NotNull(message = "SIM Details cannot be blank")
	private SIM sim;

	@NotNull(message = "Identity Details cannot be blank")
	private transient IdentityDetails identityDetails;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the address
	 */
	public AddressBean getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressBean address) {
		this.address = address;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	/**
	 * @return the sim
	 */
	public SIM getSim() {
		return sim;
	}

	/**
	 * @param sim the sim to set
	 */
	public void setSim(SIM sim) {
		this.sim = sim;
	}

	/**
	 * @return the identityDetails
	 */
	public IdentityDetails getIdentityDetails() {
		return identityDetails;
	}

	/**
	 * @param identityDetails the identityDetails to set
	 */
	public void setIdentityDetails(IdentityDetails identityDetails) {
		this.identityDetails = identityDetails;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
