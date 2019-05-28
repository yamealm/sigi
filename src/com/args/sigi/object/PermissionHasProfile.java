package com.args.sigi.object;

import java.io.Serializable;

//@NamedQuery(name = QueryConstants.DELETE_PERMISSION_HAS_PROFILE,
//query = "DELETE FROM PermissionHasProfile php WHERE php.profile.id=:profileId")
public class PermissionHasProfile {


    private Long id;
    //bi-directional many-to-one association to Permission
//    @ManyToOne
//    @JoinColumn(name = "permissionId")
    private Long permissionId;
    //bi-directional many-to-one association to Profile
//    @ManyToOne
//    @JoinColumn(name = "profileId")
    private Long profileId;

    public PermissionHasProfile() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	@Override
    public String toString() {
        return super.toString();
    }

}
