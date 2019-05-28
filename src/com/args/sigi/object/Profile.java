package com.args.sigi.object;

import java.util.List;

public class Profile {

    public static Long ADMINISTRATOR = 1L;

    private Long id;
    private boolean enabled;
    private String name;
//    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private List<PermissionHasProfile> permissionHasProfiles;
//    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<ProfileData> profileData;
//    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    private List<ReportHasProfile> reportHasProfiles;

    public Profile() {
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

    public List<PermissionHasProfile> getPermissionHasProfiles() {
        return this.permissionHasProfiles;
    }

    public void setPermissionHasProfiles(List<PermissionHasProfile> permissionHasProfiles) {
        this.permissionHasProfiles = permissionHasProfiles;
    }

    public List<ProfileData> getProfileData() {
        return this.profileData;
    }

    public void setProfileData(List<ProfileData> profileData) {
        this.profileData = profileData;
    }

//    public List<ReportHasProfile> getReportHasProfiles() {
//        return this.reportHasProfiles;
//    }
//
//    public void setReportHasProfiles(List<ReportHasProfile> reportHasProfiles) {
//        this.reportHasProfiles = reportHasProfiles;
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ProfileData getProfileDataByLanguageId(Long languageId) {
        ProfileData pd = null;
        for (ProfileData pData : this.profileData) {
            if (pData.getLanguageId()==(languageId)) {
                pd = pData;
                break;
            }
        }
        return pd;
    }
}
