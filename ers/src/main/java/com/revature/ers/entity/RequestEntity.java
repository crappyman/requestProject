package com.revature.ers.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="request_details")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="req_id")
    private int reqId;
    
    @Column(name="user_id ")
    private int userId;
    
    @Column(name="type")
    private int reqType;
    
    @Column(name="request_amount", nullable = false)
    private int reqAmount;

    @Column(name="submit_date ", nullable = false)
    private Date submitDate;

    @Column(name="approve_date ")
    private Date approveDate;

     @Column(name="manager", nullable = true)
    private Integer manager;

   
 @Column(name="status", nullable = false)
    private int reqStatus;


public RequestEntity() {
	super();
	// TODO Auto-generated constructor stub
}



public RequestEntity(int reqId, int userId, int reqType, int reqAmount, Date submitDate,  Integer manager, int reqStatus) {
	super();
	this.reqId = reqId;
	this.userId = userId;
	this.reqType = reqType;
	this.reqAmount = reqAmount;
	this.submitDate = submitDate;
	
	this.manager = manager;
	this.reqStatus = reqStatus;
}



public RequestEntity(int reqId, int userId, int reqType, int reqAmount, String submitDate, String approveDate,
		Integer manager, int reqStatus) {
	super();
	this.reqId = reqId;
	this.userId = userId;
	this.reqType = reqType;
	this.reqAmount = reqAmount;
	this.submitDate = new Date(submitDate);
	this.approveDate = new Date(approveDate);
	this.manager = manager;
	this.reqStatus = reqStatus;
}



public int getReqId() {
	return reqId;
}


public void setReqId(int reqId) {
	this.reqId = reqId;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public int getReqType() {
	return reqType;
}


public void setReqType(int reqType) {
	this.reqType = reqType;
}


public int getReqAmount() {
	return reqAmount;
}


public void setReqAmount(int reqAmount) {
	this.reqAmount = reqAmount;
}


public Date getSubmitDate() {
	return submitDate;
}


public void setSubmitDate(Date submitDate) {
	this.submitDate = submitDate;
}


public Date getApproveDate() {
	return approveDate;
}


public void setApproveDate(Date approveDate) {
	this.approveDate = approveDate;
}


public Integer getManager() {
	return manager;
}


public void setManager(Integer manager) {
	this.manager = manager;
}


public int getReqStatus() {
	return reqStatus;
}


public void setReqStatus(int reqStatus) {
	this.reqStatus = reqStatus;
}



@Override
public String toString() {
	return "RequestEntity [reqId=" + reqId + ", userId=" + userId + ", reqType=" + reqType + ", reqAmount=" + reqAmount
			+ ", submitDate=" + submitDate + ", approveDate=" + approveDate + ", manager=" + manager + ", reqStatus="
			+ reqStatus + "]";
}

   
}