package com.args.sigi.object;

import java.io.Serializable;

public class PermissionData  {

    private Long id;
    private String alias;
    private String description;
    //bi-directional many-to-one association to Language
//    @ManyToOne
//    @JoinColumn(name = "languageId")
    private int languageId;
//    @ManyToOne
//    @JoinColumn(name = "permissionId")
    private Long permissionId;

    public PermissionData() {
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

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Override
    public String toString() {
        return super.toString();
    }

}
