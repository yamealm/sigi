package com.args.sigi.object;

public class CountryTranslation  {

    private Long id;
    private String alias;
    //bi-directional many-to-one association to Language
//    @ManyToOne
//    @JoinColumn(name = "languageId")
    private int languageId;
//    @ManyToOne
//    @JoinColumn(name = "countryId")
    private Long countryId;

    public CountryTranslation() {
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


    public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Override
    public String toString() {
        return super.toString();
    }

}
