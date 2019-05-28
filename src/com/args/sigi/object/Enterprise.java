package com.args.sigi.object;

import java.io.Serializable;
import java.util.List;

public class Enterprise  {

;
    public static final Long CG_TURBINES = 1L;

    private Long id;
    private String address;
    private String atcNumber;
    private String email;
    private boolean enabled;
    private String infoEmail;
    private String invoiceAddress;
    private String name;
    private String url;
    
    //bi-directional many-to-one association to Currency
//    @ManyToOne(cascade = {CascadeType.REFRESH})
//    @JoinColumn(name = "currencyId")
    private int currencyId;
    //bi-directional many-to-one association to Country
//    @ManyToOne(cascade = {CascadeType.REFRESH})
//    @JoinColumn(name = "countryId")
    private Long countryId;
    //bi-directional many-to-one association to EnterpriseHasTinType
//    @OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
//    private List<EnterpriseHasTinType> enterpriseHasTinTypes;
    //bi-directional many-to-one association to Preference
//    @OneToMany(mappedBy = "enterprise", cascade = {CascadeType.REFRESH})
//    private List<PreferenceValue> preferenceValues;
    //bi-directional many-to-one association to Tax

    public Enterprise() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAtcNumber() {
        return this.atcNumber;
    }

    public void setAtcNumber(String atcNumber) {
        this.atcNumber = atcNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getInfoEmail() {
        return this.infoEmail;
    }

    public void setInfoEmail(String infoEmail) {
        this.infoEmail = infoEmail;
    }

    public String getInvoiceAddress() {
        return this.invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


//    public List<EnterpriseHasTinType> getEnterpriseHasTinTypes() {
//        return this.enterpriseHasTinTypes;
//    }
//
//    public void setEnterpriseHasTinTypes(List<EnterpriseHasTinType> enterpriseHasTinTypes) {
//        this.enterpriseHasTinTypes = enterpriseHasTinTypes;
//    }
//
//
//    public List<PreferenceValue> getPreferenceValues() {
//        return this.preferenceValues;
//    }
//
//    public void setPreferenceValues(List<PreferenceValue> preferenceValues) {
//        this.preferenceValues = preferenceValues;
//    }

    public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
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
