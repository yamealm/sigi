package com.args.sigi.object;

public class ProfileData  {

    private Integer id;
    private String alias;
    private String description;
    //bi-directional many-to-one association to Language
//    @ManyToOne
//    @JoinColumn(name = "languageId")
    private int languageId;
//    @ManyToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "profileId")
    private Long profile;

    public ProfileData() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	@Override
    public String toString() {
        return super.toString();
    }

}
