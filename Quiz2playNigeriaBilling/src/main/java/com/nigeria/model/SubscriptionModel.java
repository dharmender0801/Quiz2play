package com.nigeria.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appstore_users_subscription")
public class SubscriptionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "msisdn")
	private String msisdn;

	@Column(name = "service_id")
	private Long serviceId;

	@Column(name = "portal_id")
	private String portalId;

	@Column(name = "active_status")
	private Integer activeStatus;

	@Column(name = "adv_id")
	private String advId;

	@Column(name = "amount")
	private String amount;

	@Column(name = "channel")
	private String channel;

	@Column(name = "charge_amount")
	private String chargeAmount;

	@Column(name = "charge_date")
	private Date chargeDate;

	@Column(name = "currency")
	private String currency;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "grace_date")
	private Date graceDate;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "mapped_itemtype_id")
	private String mappedItemtypeId;

	@Column(name = "meta1")
	private String meta1;

	@Column(name = "meta2")
	private String meta2;

	@Column(name = "meta3")
	private String meta3;

	@Column(name = "operator_response")
	private String operatorResponse;

	@Column(name = "partner_transaction_id")
	private String partnerTransactionId;

	@Column(name = "price")
	private String price;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "subscription_date")
	private Date subscriptionDate;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "unsub_date")
	private Date unsubDate;

	@Column(name = "validity")
	private Integer validity;

	@Column(name = "language")
	private String language;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getAdvId() {
		return advId;
	}

	public void setAdvId(String advId) {
		this.advId = advId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getGraceDate() {
		return graceDate;
	}

	public void setGraceDate(Date graceDate) {
		this.graceDate = graceDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMappedItemtypeId() {
		return mappedItemtypeId;
	}

	public void setMappedItemtypeId(String mappedItemtypeId) {
		this.mappedItemtypeId = mappedItemtypeId;
	}

	public String getMeta1() {
		return meta1;
	}

	public void setMeta1(String meta1) {
		this.meta1 = meta1;
	}

	public String getMeta2() {
		return meta2;
	}

	public void setMeta2(String meta2) {
		this.meta2 = meta2;
	}

	public String getMeta3() {
		return meta3;
	}

	public void setMeta3(String meta3) {
		this.meta3 = meta3;
	}

	public String getOperatorResponse() {
		return operatorResponse;
	}

	public void setOperatorResponse(String operatorResponse) {
		this.operatorResponse = operatorResponse;
	}

	public String getPartnerTransactionId() {
		return partnerTransactionId;
	}

	public void setPartnerTransactionId(String partnerTransactionId) {
		this.partnerTransactionId = partnerTransactionId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getUnsubDate() {
		return unsubDate;
	}

	public void setUnsubDate(Date unsubDate) {
		this.unsubDate = unsubDate;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPortalId() {
		return portalId;
	}

	public void setPortalId(String portalId) {
		this.portalId = portalId;
	}

	@Override
	public String toString() {
		return "SubscriptionModel [id=" + id + ", userId=" + userId + ", msisdn=" + msisdn + ", serviceId=" + serviceId
				+ ", portalId=" + portalId + ", activeStatus=" + activeStatus + ", advId=" + advId + ", amount="
				+ amount + ", channel=" + channel + ", chargeAmount=" + chargeAmount + ", chargeDate=" + chargeDate
				+ ", currency=" + currency + ", expiryDate=" + expiryDate + ", graceDate=" + graceDate + ", keyword="
				+ keyword + ", mappedItemtypeId=" + mappedItemtypeId + ", meta1=" + meta1 + ", meta2=" + meta2
				+ ", meta3=" + meta3 + ", operatorResponse=" + operatorResponse + ", partnerTransactionId="
				+ partnerTransactionId + ", price=" + price + ", productId=" + productId + ", productName="
				+ productName + ", productType=" + productType + ", serviceName=" + serviceName + ", subscriptionDate="
				+ subscriptionDate + ", transactionId=" + transactionId + ", unsubDate=" + unsubDate + ", validity="
				+ validity + ", language=" + language + "]";
	}

}
