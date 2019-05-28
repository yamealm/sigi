package com.args.sigi.object;

import java.sql.Timestamp;


public class UserHasProfileHasEnterprise {

	private Long id;

	private Timestamp beginningDate;

	private Timestamp endingDate;

	//bi-directional many-to-one association to Profile
//    @ManyToOne
//	@JoinColumn(name="userId")
	private Long userId;
    
	//bi-directional many-to-one association to Profile
//    @ManyToOne
//	@JoinColumn(name="profileId")
	private Long profileId;

	//bi-directional many-to-one association to Enterprise
//    @ManyToOne
//	@JoinColumn(name="enterpriseId")
	private int enterpriseId;

    public UserHasProfileHasEnterprise() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getBeginningDate() {
		return this.beginningDate;
	}

	public void setBeginningDate(Timestamp beginningDate) {
		this.beginningDate = beginningDate;
	}

	public Timestamp getEndingDate() {
		return this.endingDate;
	}

	public void setEndingDate(Timestamp endingDate) {
		this.endingDate = endingDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	
}