package com.nigeria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "tbl_billing_logs")
public class TblBillingLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "portal_id")
	private String portalId;

	@Column(name = "service_id")
	private String serviceId;

	@Column(name = "total_amount")
	private String totalAmount;

	@Column(name = "process_datetime")
	private Date processDateTime;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "thread_id")
	private Integer threadId;

	@Column(name = "type_event")
	private String typeEvent;

	@Column(name = "record_status")
	private Integer recordStatus;

	@Column(name = "no_of_attempt")
	private Integer noOfAttempt;

	@Column(name = "daily_counter")
	private Integer dailyCounter;

	@Column(name = "monthly_counter")
	private Integer monthlyCounter;

	@Column(name = "mode")
	private String mode;

	@Column(name = "subscription_date")
	private Date subscriptionDate;

	@Column(name = "error_desc")
	private String errorDesc;

	@Column(name = "billing_request")
	private String billingRequest;
	
	@Column(name = "billing_response")
	private String billingresponse;
	
	
	
	
	public String getBillingRequest() {
		return billingRequest;
	}

	public void setBillingRequest(String billingRequest) {
		this.billingRequest = billingRequest;
	}

	public String getBillingresponse() {
		return billingresponse;
	}

	public void setBillingresponse(String billingresponse) {
		this.billingresponse = billingresponse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPortalId() {
		return portalId;
	}

	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getProcessDateTime() {
		return processDateTime;
	}

	public void setProcessDateTime(Date processDateTime) {
		this.processDateTime = processDateTime;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Integer getNoOfAttempt() {
		return noOfAttempt;
	}

	public void setNoOfAttempt(Integer noOfAttempt) {
		this.noOfAttempt = noOfAttempt;
	}

	public Integer getDailyCounter() {
		return dailyCounter;
	}

	public void setDailyCounter(Integer dailyCounter) {
		this.dailyCounter = dailyCounter;
	}

	public Integer getMonthlyCounter() {
		return monthlyCounter;
	}

	public void setMonthlyCounter(Integer monthlyCounter) {
		this.monthlyCounter = monthlyCounter;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	


}
