package com.args.sigi.object;

import java.io.Serializable;
import java.util.List;

public class PermissionGroup {

    private Long id;
    private boolean enabled;
    private String name;
    //bi-directional many-to-one association to PermissionGroupData
//    @OneToMany(mappedBy = "permissionGroup", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<PermissionGroupData> permissionGroupData;

    public PermissionGroup() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionGroupData> getPermissionGroupData() {
        return this.permissionGroupData;
    }

    public void setPermissionGroupData(List<PermissionGroupData> permissionGroupData) {
        this.permissionGroupData = permissionGroupData;
    }

    public PermissionGroupData getPermissionGroupDataByLanguageId(int languageId) {

        for (PermissionGroupData pgData : this.permissionGroupData) {
            if (pgData.getLanguageId()==languageId) {
                return pgData;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

  
}
