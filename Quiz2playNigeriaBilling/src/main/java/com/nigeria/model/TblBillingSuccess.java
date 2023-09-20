package com.nigeria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_billing_success")
public class TblBillingSuccess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "total_amount")
	private String totalAmount;

	@Column(name = "type_event")
	private String typeEvent;

	@Column(name = "error_desc")
	private String errorDesc;

	@Column(name = "deducted_amount")
	private String deductedAmount;

	@Column(name = "process_datetime")
	private Date processDateTime;

	@Column(name = "subscription_date")
	private Date subscriptionDate;

	@Column(name = "subscription_id")
	private Long subscriptionId;

	@Column(name = "no_of_attempt")
	private Integer noOfAttempt;

	@Column(name = "daily_counter")
	private Integer dailyCounter;

	@Column(name = "monthly_counter")
	private Integer monthlyCounter;

	@Column(name = "mode")
	private String mode;

	@Column(name = "record_status")
	private Integer recordStatus;

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getDeductedAmount() {
		return deductedAmount;
	}

	public void setDeductedAmount(String deductedAmount) {
		this.deductedAmount = deductedAmount;
	}

	public String getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	public String toString() {
		return "TblBillingSuccess [id=" + id + ", msisdn=" + msisdn + ", productId=" + productId + ", portalId="
				+ portalId + ", serviceId=" + serviceId + ", dateTime=" + dateTime + ", totalAmount=" + totalAmount
				+ ", typeEvent=" + typeEvent + ", errorDesc=" + errorDesc + ", deductedAmount=" + deductedAmount
				+ ", processDateTime=" + processDateTime + ", subscriptionDate=" + subscriptionDate
				+ ", subscriptionId=" + subscriptionId + ", noOfAttempt=" + noOfAttempt + ", dailyCounter="
				+ dailyCounter + ", monthlyCounter=" + monthlyCounter + ", mode=" + mode + ", recordStatus="
				+ recordStatus + "]";
	}

}
