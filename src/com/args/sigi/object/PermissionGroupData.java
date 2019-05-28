package com.args.sigi.object;

import java.io.Serializable;


public class PermissionGroupData  {

    private Long id;
    private String alias;
    private String description;
    //bi-directional many-to-one association to Language
//    @ManyToOne
//    @JoinColumn(name = "languageId")
    private int languageId;
//    @ManyToOne
//    @JoinColumn(name = "permissionGroupId")
    private Long permissionGroupId;

    public PermissionGroupData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Long getPermissionGroupId() {
		return permissionGroupId;
	}

	public void setPermissionGroupId(Long permissionGroupId) {
		this.permissionGroupId = permissionGroupId;
	}

	@Override
    public String toString() {
        return super.toString();
    }


}
