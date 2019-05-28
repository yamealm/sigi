package com.args.sigi.object;

import java.sql.Timestamp;


public class AuditAction  {

    private Long id;
    private String info;
    private String host;
    private Timestamp date;
    //bi-directional many-to-one association to City
//    @ManyToOne
//    @JoinColumn(name = "userId")
    private Long userId;
    //bi-directional many-to-one association to State
//    @ManyToOne
//    @JoinColumn(name = "permissionId")
    private Long permissionId;
    //bi-directional many-to-one association to County

    public AuditAction() {
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
