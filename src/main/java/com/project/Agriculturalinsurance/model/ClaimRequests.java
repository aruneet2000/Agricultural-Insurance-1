package com.project.Agriculturalinsurance.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "claim_requests")
public class ClaimRequests {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "claim_id", nullable = false)
	private String claimId;
	
	@Column(name = "farmer_id", nullable = false)
	private String farmerId;
	
	@Column(name = "claim_date", nullable = false)
	@Past(message="Date of Claim can not be a future date")
    private Date claimDate;
	
	@Column(name = "caim_type", nullable = false)
	@Size(min=1, message="Please select a claim type")
	private String claimType;
	
	@Column(name = "policy_id", nullable = false)
	@Size(min=1, message="Please Enter a Policy ID")
	private String policyId;
	
	@Column(name = "claim_amount", nullable = false)
	@Size(min=1, message="Please Enter Claim Amount")
	private String claimAmount;
	
	@Column(name = "description", nullable = false)
	@Size(min=1, message="Please Provide a Description")
	private String desc;
	
	@Column(name = "remarks", nullable = false)
	private String remarks;
	
	@Column(name = "is_due")
	private boolean due=true;
	
	public ClaimRequests() {
		super();
	}
	
	public ClaimRequests(String claimId, String farmerId, Date claimDate) {
		super();
		this.claimId = claimId;
		this.farmerId = farmerId;
		this.claimDate = claimDate;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public boolean isDue() {
		return due;
	}


	public void setDue(boolean due) {
		this.due = due;
	}
	
	
	
}
