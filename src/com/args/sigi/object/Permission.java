package com.args.sigi.object;

import java.util.List;

public class Permission  {

    public static String LOG_IN = "User has logged in.";
    public static String LOG_OUT = "User has logged out.";
    public static Long LIST_PROFILES = 1L;
    public static Long ADD_PROFILE = 2L;
    public static Long CHANGE_PROFILE_STATUS = 3L;
    public static Long EDIT_PROFILE = 4L;
    public static Long VIEW_PROFILE = 5L;
    public static Long LIST_ENTERPRISES = 6L;
    public static Long ADD_ENTERPRISE = 7L;
    public static Long EDIT_ENTERPRISE = 8L;
    public static Long VIEW_ENTERPRISE = 9L;
    public static Long CHANGE_ENTERPRISE_STATUS = 10L;
    public static Long LIST_CUSTOMER = 11L;
    public static Long EDIT_CUSTOMER = 12L;
    public static Long VIEW_CUSTOMER = 13L;
    public static Long CHANGE_CUSTOMER_STATUS = 14L;
    public static Long LIST_PROVIDERS = 15L;
    public static Long ADD_PROVIDER = 16L;
    public static Long EDIT_PROVIDER = 17L;
    public static Long VIEW_PROVIDER = 18L;
    public static Long CHANGE_PROVIDER_STATUS = 19L;
    public static Long LIST_PRODUCTS = 20L;
    public static Long ADD_PRODUCT = 21L;
    public static Long EDIT_PRODUCT = 22L;
    public static Long VIEW_PRODUCT = 23L;
    public static Long CHANGE_PRODUCT_STATUS = 24L;
    public static Long LIST_COUNTRIES = 25L;
    public static Long ADD_COUNTRY = 26L;
    public static Long EDIT_COUNTRY = 27L;
    public static Long VIEW_COUNTRY = 28L;
    public static Long CHANGE_COUNTRY_STATUS = 29L;
    public static Long LIST_MOBILE_OPERATORS = 30L;
    public static Long ADD_MOBILE_OPERATOR = 31L;
    public static Long EDIT_MOBILE_OPERATOR = 32L;
    public static Long VIEW_MOBILE_OPERATOR = 33L;
    public static Long CHANGE_MOBILE_OPERATOR_STATUS = 34L;
    public static Long LIST_USERS = 35L;
    public static Long ADD_USER = 36L;
    public static Long EDIT_USER = 37L;
    public static Long VIEW_USER = 38L;
    public static Long CHANGE_USER_STATUS = 39L;
    public static Long ADMIN_SETTINGS = 40L;
    public static Long SMS_TESTING = 41L;
    public static Long EMAIL_TESTING = 42L;
    public static Long REPORT_EXECUTE = 43L;
    public static Long LIST_REPORTS = 44L;
    public static Long ADD_REPORTS = 45L;
    public static Long EDIT_REPORTS = 46L;
    public static Long VIEW_REPORTS = 47L;
    public static Long CHANGE_REPORTS_STATUS = 48L;
    public static Long LIST_SMS = 49L;
    public static Long SEND_SMS = 50L;
    public static Long VIEW_SMS = 51L;
    public static Long AUDIT_ACTIONS = 52L;
    public static Long LIST_TRANSACTION = 53L;
    public static Long AUTOMATIC_PROCESS = 54L;
    public static Long VIEW_TRANSACTION = 55L;
    public static Long LIST_ACCOUNTS = 91L;
    public static Long ADD_ACCOUNT = 57L;
    public static Long EDIT_ACCOUNT = 58L;
    public static Long VIEW_ACCOUNT = 59L;
    public static Long CHANGE_ACCOUNT_STATUS = 60L;
    public static Long SEND_ACCOUNT_DATA = 61L;
    public static Long TOP_UP_CALCULATION_LIST = 62L;
    public static Long TOP_UP_CALCULATION_EDIT = 63L;
    public static Long TOP_UP_CALCULATION_VIEW = 64L;
    public static Long LIST_BILL_PAYMENT_CALCULATION = 65L;
    public static Long EDIT_BILL_PAYMENT_CALCULATION = 66L;
    public static Long VIEW_BILL_PAYMENT_CALCULATION = 67L;
    public static Long LIST_BILL_PAYMENT = 68L;
    public static Long EDIT_BILL_PAYMENT = 69L;
    public static Long VIEW_BILL_PAYMENT = 70L;
    public static Long CHANGE_BILL_PAYMENT_STATUS = 71L;
    public static Long LIST_INVOICE = 72L;
    public static Long READ_INVOICE = 73L;
    public static Long RECHARGE_BALANCE = 77L;
    public static Long FORCE_INVOICE = 79L;
    public static Long LIST_BANNERS= 80L;
    public static Long ADD_BANNER = 81L;
    public static Long EDIT_BANNER = 82L;
    public static Long VIEW_BANNER = 83L;
    public static Long CHANGE_BANNER_STATUS = 84L;
    public static Long SearchAccessNumber = 85L;
    public static Long CHANGE_IP_ADRESS = 86L;
    public static Long ADD_IP = 87L;
    public static Long DELETE_IP = 88L;
    public static Long LIST_BLACKIP = 89L;
    public static Long BALANCE_ADJUSMENT = 90L;
    
    private Long id;
    private String action;
    private boolean enabled;
    private String entity;
    private String name;
    private String permissionGroupId;
    //bi-directional many-to-one association to PermissionData
//    @OneToMany(mappedBy = "permission", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    private List<PermissionData> permissionData;
//    @ManyToOne
//    @JoinColumn(name = "permissionGroupId")
//    private PermissionGroup permissionGroup;

    public Permission() {
    }
    
    public Permission(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEntity() {
        return this.entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    

//    public List<PermissionData> getPermissionData() {
//        return this.permissionData;
//    }

//    public void setPermissionData(List<PermissionData> permissionData) {
//        this.permissionData = permissionData;
//    }
//
//    public PermissionGroup getPermissionGroup() {
//        return this.permissionGroup;
//    }

//    public void setPermissionGroup(PermissionGroup permissionGroup) {
//        this.permissionGroup = permissionGroup;
//    }

//    public PermissionData getPermissionDataByLanguageId(Long languageId) {
//        PermissionData pd = null;
//        for (PermissionData pData : this.permissionData) {
//            if (pData.getLanguageId()==(languageId)) {
//                pd = pData;
//                break;
//            }
//        }
//        return pd;
//    }

    public String getPermissionGroupId() {
		return permissionGroupId;
	}
	public void setPermissionGroupId(String permissionGroupId) {
		this.permissionGroupId = permissionGroupId;
	}
	@Override
    public String toString() {
        return super.toString();
    }


}
