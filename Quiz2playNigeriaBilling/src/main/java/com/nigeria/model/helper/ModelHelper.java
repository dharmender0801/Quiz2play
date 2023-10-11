package com.nigeria.model.helper;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.model.ProductConfigModel;
import com.nigeria.model.SubscriptionModel;
import com.nigeria.model.SubscriptionRequestModel;
import com.nigeria.model.TblBillingLogs;
import com.nigeria.model.TblBillingSuccess;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.repos.SubscriptionRepos;
import com.nigeria.repos.SubscriptionRequestRepos;
import com.nigeria.repos.TblBillingLogsRepo;
import com.nigeria.repos.TblBillingSuccessRepo;
import com.nigeria.request.SubscriptionRequest;

@Component
public class ModelHelper {

	@Autowired
	private PartnerNotificationRepo notificationRepo;
	@Autowired
	private SubscriptionRequestRepos subRequestRepo;
	@Autowired
	private SubscriptionRepos subscriptionRepo;
	@Autowired
	private TblBillingLogsRepo billingLogsRepo;
	@Autowired
	private TblBillingSuccessRepo billingSuccessRepo;

	public SubscriptionRequestModel saveSubscriptionRequest(SubscriptionRequest body, String response, String url,
			String msisdn) {
		// TODO Auto-generated method stub

		SubscriptionRequestModel subscriptionRequestModel = new SubscriptionRequestModel();
		try {
			subscriptionRequestModel.setDateTime(new Date());
			subscriptionRequestModel.setAdvId(body.getAdvId());
			subscriptionRequestModel.setChannel("WAP");
			subscriptionRequestModel.setProductId(body.getProductId());
			subscriptionRequestModel.setPinPushResponse(response);
			subscriptionRequestModel.setPartnerTransactionId(body.getPartnerTransactionId());
			subscriptionRequestModel.setTransactionId("0");
			subscriptionRequestModel.setLanguage(body.getLanguage());
			subscriptionRequestModel.setMsisdn(msisdn);
			subscriptionRequestModel.setPinPushRequest(url);
			subscriptionRequestModel.setPortalId("106");
			subRequestRepo.save(subscriptionRequestModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscriptionRequestModel;

	}

	public void saveNotificationRequest(String msisdn, String notifyRequest, String notifyResponse, String portalId) {
		PartnerNoticationRequest notifyModel = new PartnerNoticationRequest();
		try {
			notifyModel.setDateTime(new Date());
			notifyModel.setMsisdn(msisdn);
			notifyModel.setNotificationRequest(notifyRequest);
			notifyModel.setNotificationResponse(notifyResponse);
			notifyModel.setPortalId(portalId);
			notificationRepo.save(notifyModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SubscriptionModel saveintosubscription(String msisdn, SubscriptionRequestModel subscriptionRequest,
			ProductConfigModel productConfig) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, Integer.parseInt(productConfig.getValidity()));
		Date date1 = cal.getTime();
		SubscriptionModel subModel = new SubscriptionModel();
		try {
			subModel.setActiveStatus(1);
			subModel.setAdvId(subscriptionRequest.getAdvId());
			subModel.setAmount(productConfig.getPricePoint());
			subModel.setChannel(subscriptionRequest.getChannel());
			subModel.setCurrency(productConfig.getCurrency());
			subModel.setLanguage(subscriptionRequest.getLanguage());
			subModel.setMappedItemtypeId(productConfig.getPricePoint());
			subModel.setMsisdn(msisdn);
			subModel.setPortalId(subscriptionRequest.getPortalId());
			subModel.setPrice(productConfig.getPricePoint());
			subModel.setPartnerTransactionId(subscriptionRequest.getPartnerTransactionId());
			subModel.setProductId(productConfig.getProductId());
			subModel.setProductName(productConfig.getProductName());
			subModel.setProductType(productConfig.getPackType());
			subModel.setServiceId(Long.valueOf(productConfig.getServiceId()));
			subModel.setServiceName(productConfig.getServiceName());
			subModel.setSubscriptionDate(new Date());
			subModel.setTransactionId(subscriptionRequest.getTransactionId());
			subModel.setUserId(0L);
			subModel.setChargeAmount(productConfig.getPricePoint());
			subModel.setValidity(Integer.parseInt(productConfig.getValidity()));
			subModel.setChargeDate(new Date());
			subModel.setExpiryDate(date1);
			subscriptionRepo.save(subModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subModel;
	}

	public void saveBillingSuccessEntry(String msisdn, ProductConfigModel productConfig, SubscriptionModel model,
			String typeEvent) {
		TblBillingSuccess tblBillingSuccess = new TblBillingSuccess();
		try {
			tblBillingSuccess.setMsisdn(msisdn);
			tblBillingSuccess.setProductId(productConfig.getProductId());
			tblBillingSuccess.setPortalId(String.valueOf(productConfig.getPortalId()));
			tblBillingSuccess.setServiceId(String.valueOf(productConfig.getServiceId()));
			tblBillingSuccess.setDateTime(new Date());
			tblBillingSuccess.setProcessDateTime(new Date());
			tblBillingSuccess.setNoOfAttempt(1);
			tblBillingSuccess.setDailyCounter(1);
			tblBillingSuccess.setMonthlyCounter(1);
			tblBillingSuccess.setTotalAmount(productConfig.getPricePoint());
			tblBillingSuccess.setDeductedAmount(productConfig.getPricePoint());
			tblBillingSuccess.setTypeEvent(typeEvent);
			tblBillingSuccess.setSubscriptionDate(model.getSubscriptionDate());
			tblBillingSuccess.setSubscriptionId(model.getId());
			tblBillingSuccess.setMode(model.getChannel());
			tblBillingSuccess.setRecordStatus(1);
			tblBillingSuccess.setErrorDesc("Success");
			billingSuccessRepo.save(tblBillingSuccess);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public TblBillingLogs saveBillingLogsEntry(String msisdn, ProductConfigModel productConfig, SubscriptionModel model,
			String typeEvent, String errordesc, String reason) {

		TblBillingLogs tblBillingLogs = new TblBillingLogs();
		try {
			tblBillingLogs.setMsisdn(msisdn);
			tblBillingLogs.setProductId(productConfig.getProductId());
			tblBillingLogs.setPortalId(String.valueOf(productConfig.getPortalId()));
			tblBillingLogs.setServiceId(String.valueOf(productConfig.getServiceId()));
			tblBillingLogs.setTotalAmount(productConfig.getPricePoint());
			tblBillingLogs.setDateTime(new Date());
			tblBillingLogs.setSubscriptionDate(model.getSubscriptionDate());
			tblBillingLogs.setErrorDesc(errordesc);
			tblBillingLogs.setBillingresponse(reason);
			tblBillingLogs.setTypeEvent(typeEvent);
			tblBillingLogs.setRecordStatus(1);
			tblBillingLogs.setNoOfAttempt(1);
			tblBillingLogs.setDailyCounter(1);
			tblBillingLogs.setMonthlyCounter(1);
			tblBillingLogs.setMode(model.getChannel());

			billingLogsRepo.save(tblBillingLogs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tblBillingLogs;

	}
	private void updateSubscriptionModel(SubscriptionModel subModel, ProductConfigModel productConfig) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, Integer.parseInt(productConfig.getValidity()));
		Date date1 = cal.getTime();

		try {
			subModel.setChargeDate(new Date());
			subModel.setChargeAmount(productConfig.getPricePoint());
			subModel.setActiveStatus(2);
			subModel.setExpiryDate(date1);
			subModel.setValidity(Integer.parseInt(productConfig.getValidity()));

			subscriptionRepo.save(subModel);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
