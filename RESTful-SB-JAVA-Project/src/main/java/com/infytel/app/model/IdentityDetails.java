package com.infytel.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="tbl_identitydetails")
public class IdentityDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1725910866309598733L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String documentId;
	@NotBlank(message = "Type of ID cannot be blank")
	private String typeOfIdentityDocument;
	@NotBlank(message = "Identity Number cannot be blank")
	private String identityNumber;
	@Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String expiryDate;
	@Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String issueDate;
	@NotBlank(message = "Issued At cannot be blank")
	private String issuedAt;
	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;
	@NotBlank(message = "Date of Birth cannot be blank")
	private String dateOfBirth;

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the typeOfIdentityDocument
	 */
	public String getTypeOfIdentityDocument() {
		return typeOfIdentityDocument;
	}

	/**
	 * @param typeOfIdentityDocument the typeOfIdentityDocument to set
	 */
	public void setTypeOfIdentityDocument(String typeOfIdentityDocument) {
		this.typeOfIdentityDocument = typeOfIdentityDocument;
	}

	/**
	 * @return the identityNumber
	 */
	public String getIdentityNumber() {
		return identityNumber;
	}

	/**
	 * @param identityNumber the identityNumber to set
	 */
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the issueDate
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the issuedAt
	 */
	public String getIssuedAt() {
		return issuedAt;
	}

	/**
	 * @param issuedAt the issuedAt to set
	 */
	public void setIssuedAt(String issuedAt) {
		this.issuedAt = issuedAt;
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
