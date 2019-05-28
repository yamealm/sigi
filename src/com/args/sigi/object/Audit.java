package com.args.sigi.object;

import java.sql.Timestamp;

public class Audit  {

  
    private Long id;
    private Timestamp creationDate;
    private String extra;
    private String newValues;
    private String originalValues;
    private Long registerId;
    private String remoteIp;
    private String responsibleId;
    private String responsibleType;
    private String tableName;
    private Long event;

    public Audit() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getNewValues() {
        return this.newValues;
    }

    public void setNewValues(String newValues) {
        this.newValues = newValues;
    }

    public String getOriginalValues() {
        return this.originalValues;
    }

    public void setOriginalValues(String originalValues) {
        this.originalValues = originalValues;
    }

    public Long getRegisterId() {
        return this.registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public String getRemoteIp() {
        return this.remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getResponsibleId() {
        return this.responsibleId;
    }

    public void setResponsibleId(String responsibleId) {
        this.responsibleId = responsibleId;
    }

    public String getResponsibleType() {
        return this.responsibleType;
    }

    public void setResponsibleType(String responsibleType) {
        this.responsibleType = responsibleType;
    }

   
    public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getEvent() {
		return event;
	}

	public void setEvent(Long event) {
		this.event = event;
	}

	@Override
    public String toString() {
        return super.toString();
    }

    }
