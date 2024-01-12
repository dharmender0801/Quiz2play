package com.nigeria.model.helper;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nigeria.model.PartnerNoticationRequest;
import com.nigeria.model.ProductConfigModel;
import com.nigeria.model.SdpNoticationLogsModel;
import com.nigeria.model.SubscriptionHistoryModel;
import com.nigeria.model.SubscriptionModel;
import com.nigeria.model.SubscriptionRequestModel;
import com.nigeria.model.TblBillingLogs;
import com.nigeria.model.TblBillingSuccess;
import com.nigeria.model.UnsubLogsModel;
import com.nigeria.repos.PartnerNotificationRepo;
import com.nigeria.repos.ProductConfigRepos;
import com.nigeria.repos.SdpNoticationLogsRepos;
import com.nigeria.repos.SubscriptionHistoryRepos;
import com.nigeria.repos.SubscriptionRepos;
import com.nigeria.repos.SubscriptionRequestRepos;
import com.nigeria.repos.TblBillingLogsRepo;
import com.nigeria.repos.TblBillingSuccessRepo;
import com.nigeria.repos.UnsubLogsRepos;
import com.nigeria.repos.UserProfileRepos;
import com.nigeria.request.SubscriptionRequest;
import com.nigeria.request.notifyReq;

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
	@Autowired
	private SubscriptionHistoryRepos historyRepos;
	@Autowired
	private UserProfileRepos profileRepos;
	@Autowired
	private ProductConfigRepos configRepos;
	@Autowired
	private SdpNoticationLogsRepos logsRepos;
	@Autowired
	private UnsubLogsRepos unsubrepos;

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
			subscriptionRequestModel.setMeta2(body.getToken());
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
			ProductConfigModel productConfig, int flag) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, Integer.parseInt(productConfig.getValidity()));
		Date date1 = cal.getTime();
		SubscriptionModel subModel = subscriptionRepo.findByMsisdn(msisdn).orElse(new SubscriptionModel());
		try {
			subModel.setActiveStatus(1);
			subModel.setAdvId(subscriptionRequest.getAdvId());
			subModel.setAmount(productConfig.getPricePoint());
			subModel.setChannel(subscriptionRequest.getChannel());
			subModel.setCurrency(productConfig.getCurrency());
			subModel.setLanguage(subscriptionRequest.getLanguage());
			subModel.setMappedItemtypeId(productConfig.getPricePoint());
			subModel.setMsisdn(msisdn);
			subModel.setMeta2(subscriptionRequest.getMeta2());
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
			subModel.setValidity(Integer.parseInt(productConfig.getValidity()));
			subModel.setExpiryDate(date1);
			if (flag == 1) {
				subModel.setChargeAmount(productConfig.getPricePoint());
				subModel.setChargeDate(new Date());
			}
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

	public TblBillingLogs saveBillingLogsEntry(notifyReq notifyReq) {
		SubscriptionModel SubModel = subscriptionRepo.findByMsisdn(notifyReq.getMsisdn()).get();
		if (SubModel != null) {
			String typeEvent = null;
			if (SubModel.getChargeDate() == null) {
				typeEvent = "sub";
			} else {
				typeEvent = "ren";
			}
			TblBillingLogs tblBillingLogs = new TblBillingLogs();
			try {
				tblBillingLogs.setMsisdn(notifyReq.getMsisdn());
				tblBillingLogs.setProductId(SubModel.getProductId());
				tblBillingLogs.setPortalId(String.valueOf(SubModel.getPortalId()));
				tblBillingLogs.setServiceId(String.valueOf(SubModel.getServiceId()));
				tblBillingLogs.setTotalAmount(SubModel.getAmount());
				tblBillingLogs.setDateTime(new Date());
				tblBillingLogs.setSubscriptionDate(SubModel.getSubscriptionDate());
				tblBillingLogs.setErrorDesc(notifyReq.getTransaction().getStatus());
				tblBillingLogs.setBillingresponse(notifyReq.getTransaction().getStatus());
				tblBillingLogs.setTypeEvent(typeEvent);
				tblBillingLogs.setRecordStatus(1);
				tblBillingLogs.setNoOfAttempt(1);
				tblBillingLogs.setDailyCounter(1);
				tblBillingLogs.setMonthlyCounter(1);
				tblBillingLogs.setMode(SubModel.getChannel());
				billingLogsRepo.save(tblBillingLogs);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void updateSubscriptionModel(SubscriptionModel subModel, ProductConfigModel productConfig) {

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

	public SubscriptionModel updateSubscription(notifyReq success) {
		// TODO Auto-generated method stub
		SubscriptionModel SubModel = subscriptionRepo.findByMsisdn(success.getMsisdn()).get();
		ProductConfigModel PModel = configRepos.findByProductIdAndLanguage(SubModel.getProductId(), "en");
		updateSubscriptionModel(SubModel, PModel);
		String typeEvent = null;
		if (SubModel.getChargeDate() == null) {
			typeEvent = "sub";
		} else {
			typeEvent = "ren";
		}
		saveBillingSuccessEntry(success.getMsisdn(), PModel, SubModel, typeEvent);
		saveBillingLogsEntry(success);
		return SubModel;
	}

	public void Unsubscription(String msisdn) {
		// TODO Auto-generated method stub
		SubscriptionModel subModel = subscriptionRepo.findByMsisdn(msisdn).get();
		if (subModel != null) {
			saveUnsubscriptionEntry(subModel);
			profileRepos.deleteFromSubscriptionId(subModel.getId());
			subscriptionRepo.delete(subModel);
		}

	}

	private void saveUnsubscriptionEntry(SubscriptionModel subModel) {
		// TODO Auto-generated method stub
		SubscriptionHistoryModel subHistory = new SubscriptionHistoryModel();
		try {
			subHistory.setActiveStatus(subModel.getActiveStatus());
			subHistory.setAdvId(subModel.getAdvId());
			subHistory.setAmount(subModel.getAmount());
			subHistory.setCancelChannel("Callback");
			subHistory.setCancelDate(new Date());
			subHistory.setCancelReason("Callback");
			subHistory.setSubscriptionId(subModel.getId());
			subHistory.setChannel(subModel.getChannel());
			subHistory.setChargeAmount(subModel.getChargeAmount());
			subHistory.setChargeDate(subModel.getChargeDate());
			subHistory.setCurrency(subModel.getCurrency());
			subHistory.setExpiryDate(subModel.getExpiryDate());
			subHistory.setGraceDate(subModel.getGraceDate());
			subHistory.setKeyword(subModel.getKeyword());
			subHistory.setLanguage(subModel.getLanguage());
			subHistory.setMappedItemtypeId(subModel.getMappedItemtypeId());
			subHistory.setChargeAmount(subModel.getChargeAmount());
			subHistory.setMeta1(subModel.getMeta1());
			subHistory.setMeta2(subModel.getMeta2());
			subHistory.setMeta3(subModel.getMeta3());
			subHistory.setMsisdn(subModel.getMsisdn());
			subHistory.setOperatorResponse(subModel.getOperatorResponse());
			subHistory.setPartnerTransactionId(subModel.getPartnerTransactionId());
			subHistory.setPrice(subModel.getPrice());
			subHistory.setProductId(subModel.getProductId());
			subHistory.setProductName(subModel.getProductName());
			subHistory.setProductType(subModel.getProductType());
			subHistory.setServiceId(subModel.getServiceId());
			subHistory.setServiceName(subModel.getServiceName());
			subHistory.setSubscriptionDate(subModel.getSubscriptionDate());
			subHistory.setTransactionId(subModel.getTransactionId());
			subHistory.setUserId(subModel.getUserId());
			subHistory.setValidity(subModel.getValidity());

			historyRepos.save(subHistory);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveBillingLogsEntry(String msisdn, ProductConfigModel configModel, SubscriptionModel subModel,
			String typeEvent, String errordesc, String asText) {
		if (subModel != null) {
			TblBillingLogs tblBillingLogs = new TblBillingLogs();
			try {
				tblBillingLogs.setMsisdn(msisdn);
				tblBillingLogs.setProductId(subModel.getProductId());
				tblBillingLogs.setPortalId(String.valueOf(subModel.getPortalId()));
				tblBillingLogs.setServiceId(String.valueOf(subModel.getServiceId()));
				tblBillingLogs.setTotalAmount(subModel.getAmount());
				tblBillingLogs.setDateTime(new Date());
				tblBillingLogs.setSubscriptionDate(subModel.getSubscriptionDate());
				tblBillingLogs.setErrorDesc(errordesc);
				tblBillingLogs.setBillingresponse(asText);
				tblBillingLogs.setTypeEvent(typeEvent);
				tblBillingLogs.setRecordStatus(1);
				tblBillingLogs.setNoOfAttempt(1);
				tblBillingLogs.setDailyCounter(1);
				tblBillingLogs.setMonthlyCounter(1);
				tblBillingLogs.setMode(subModel.getChannel());
				billingLogsRepo.save(tblBillingLogs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub

	}

	public void savetounsublog(String url, String response, String msisdn, String portalid) {
		UnsubLogsModel unsubModel = new UnsubLogsModel();
		unsubModel.setDatetime(new Date());
		unsubModel.setMsisdn(msisdn);
		unsubModel.setRequest(url);
		unsubModel.setResponse(response);
		unsubModel.setPortalid(portalid);
		unsubrepos.save(unsubModel);
	}

	public void saveSdpLogs() {
		SdpNoticationLogsModel logsModel = new SdpNoticationLogsModel();
	}

	public SubscriptionModel SubscribeUser(String msisdn, String packName, String channel, String transactionId,
			String userStatus) {
		// TODO Auto-generated method stub
		ProductConfigModel productConfig = configRepos.findByCredit(packName);
		SubscriptionModel subModel1 = subscriptionRepo.findByMsisdn(msisdn).orElse(null);
		if (productConfig != null) {
			if (subModel1 == null) {
				SubscriptionModel subModel = new SubscriptionModel();
				subModel.setMsisdn(msisdn);
				subModel.setActiveStatus(1);
				subModel.setAmount(productConfig.getPricePoint());
				subModel.setChannel(channel);
				subModel.setCurrency(productConfig.getCurrency());
				subModel.setLanguage("en");
				subModel.setMappedItemtypeId(productConfig.getPricePoint());
				subModel.setPortalId("106");
				subModel.setPrice(productConfig.getPricePoint());
				subModel.setTransactionId(transactionId);
				subModel.setProductId(productConfig.getProductId());
				subModel.setProductName(productConfig.getProductName());
				subModel.setProductType(productConfig.getPackType());
				subModel.setServiceId(Long.valueOf(productConfig.getServiceId()));
				subModel.setServiceName(productConfig.getServiceName());
				subModel.setSubscriptionDate(new Date());
				subModel.setUserId(0L);
				subModel.setValidity(Integer.parseInt(productConfig.getValidity()));
				if (userStatus.equalsIgnoreCase("0")) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, Integer.parseInt(productConfig.getValidity()));
					Date date1 = cal.getTime();
					subModel.setChargeAmount(productConfig.getPricePoint());
					subModel.setChargeDate(new Date());
					subModel.setExpiryDate(date1);
				}

				subscriptionRepo.save(subModel);
				return subModel;
			} else {
				return subModel1;
			}

		} else {
			return subModel1;
		}

	}

}
