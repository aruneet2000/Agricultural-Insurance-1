package com.project.Agriculturalinsurance.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name="claim_officer")
public class ClaimOfficer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "first_name", nullable = false)
	@Size(min=1, message="Enter at least 5 Characters...")
    private String firstName;
     
    @Column(name = "last_name", nullable = false)
    @Size(min=1, message="Enter at least 5 Characters...")
    private String lastName;
    
    @Column(name = "dob", nullable = false)
    @Past(message="Date of Birth can not be a future date")
//    @Size(min=1, message="Plesae Enter Your Date of Birth")
    private Date dOB;
    
    @Column(name = "gender", nullable = false)
    @Size(min=1, message="Please select a gender type")
    private String gender;
    
    @Column(name = "contact", nullable = false, unique = true, length = 10)
    @Size(min=10, message="Enter a Valid Phone Number")
    @Size(max=10, message="Enter a Valid Phone Number")
    private String contact;
    
    @Column(name = "bank_name", nullable = false)
    @Size(min=1, message="Bank Name can not be NULL")
    private String bankName;
    
    @Column(name = "bank_branch", nullable = false)
    @Size(min=1, message="Branch Name can not be NULL")
    private String bankBranch;
    
    @Column(name = "add_line1", nullable = false)
    @Size(min=1, message="Mention your address")
    private String addLine1;
    
    @Column(name = "add_line2")
    private String addLine2;
    
    @Column(name = "city", nullable = false)
    @Size(min=1, message="City can not be NULL")
    private String city;
    
    @Column(name = "state", nullable = false)
    @Size(min=1, message="State can not be NULL")
    private String state;
    
    @Column(name = "zip", nullable = false, length = 6)
    @Size(min=6, message="Enter a Valid Zip/Postal Code")
    @Size(max=6, message="Enter a Valid Zip/Postal Code")
    private String zipCode;
    
    @Column(name = "officer_id", nullable = false)
    @Size(min=1, message="Create an Officer ID")
    private String officerId;
    
    @Column(name="password", nullable = false)
    @Size(min=1, message="Create a Password")
    private String password;
    
    @Column(name="approved")
    private boolean approved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getOfficerId() {
		return officerId;
	}

	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
    
}
