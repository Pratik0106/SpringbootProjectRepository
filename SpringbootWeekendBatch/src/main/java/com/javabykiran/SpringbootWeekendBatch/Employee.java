package com.javabykiran.SpringbootWeekendBatch;

import java.sql.Date;

public class Employee {

	int id;
	String name;
	String departmentit;
	String phoneno;
	Date createddtm;
	String createdby;
	Date updateddtm;
	String updatedby;
	String status;
	int cid;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentit() {
		return departmentit;
	}
	public void setDepartmentit(String departmentit) {
		this.departmentit = departmentit;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getCreateddtm() {
		return createddtm;
	}
	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getUpdateddtm() {
		return updateddtm;
	}
	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
