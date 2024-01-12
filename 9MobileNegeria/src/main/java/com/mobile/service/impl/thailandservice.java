package com.mobile.service.impl;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.ProductConfigModel;
import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.model.SubscriptionRequestModel;
import com.mobile.repo.ProductConfigRepos;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.repo.SubscriptionRequestRepos;
import com.mobile.service.thailandserv;

@Service
public class thailandservice implements thailandserv {

	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;
	@Autowired
	private ProductConfigRepos configRepos;
	@Autowired
	private SubscriptionRequestRepos repos;

	@Override
	public Boolean saveTransaction(String userAgent, Model model, String cpId, String kpId, String pubId,
			String language, String productId, long requestId) {
		// TODO Auto-generated method stub
		Boolean response = false;
		try {
			Quiz2playLpAdvertizer isActiveLpAdv = advertizerRepo.findByCpIdAndStatus(cpId, true);
			if (isActiveLpAdv != null) {
				model.addAttribute("kpId", kpId);
				model.addAttribute("cpId", cpId);
				model.addAttribute("pubId", pubId);
				model.addAttribute("productId", productId);
				model.addAttribute("language", language);
				model.addAttribute("transactionId", requestId);
				model.addAttribute("redirect", "/ais/redirect");
				model.addAttribute("img",
						"https://static.gamezop.com/quiz-champion/assets/images/quiz-champions-logo.png");
				model.addAttribute("branding", "https://logos-world.net/wp-content/uploads/2023/03/AIS-Logo.jpg");
				InetAddress IP = InetAddress.getLocalHost();
				System.out.println(IP.toString());
				Quiz2playLpTransaction lpTranModel = new Quiz2playLpTransaction();
				lpTranModel.setAdvId(cpId);
				lpTranModel.setPubId(pubId);
				lpTranModel.setPartnerTransactionId(kpId);
				lpTranModel.setRequestDate(new Date());
				lpTranModel.setIpAdress(IP.toString());
				lpTranModel.setUserAgent(userAgent);
				lpTranModel.setProductId(productId);
				lpTranModel.setTransactionId(String.valueOf(requestId));
//				lpTransactionRepo.save(lpTranModel);
				response = true;
			} else {
				model.addAttribute("text", "Vendor is not Authorized");
				model.addAttribute("img",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/512px-Cross_red_circle.svg.png?20181021160952");

			}
		} catch (Exception e) {
			model.addAttribute("text", "Some Server Issue Please try after some time");
			model.addAttribute("img",
					"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/512px-Cross_red_circle.svg.png?20181021160952");

			e.printStackTrace();
		}
		return response;
	}

	@Override
	public String getRedirectionURl(String kpId, String pubId, String productId, String language, String transactionId,
			String advId) {
		// TODO Auto-generated method stub
		String redirectionUrl = "http://api.costartech.io/sp/ais/to/5780?click_id=" + transactionId;
		SubscriptionRequestModel requestModel = new SubscriptionRequestModel();
		requestModel.setTransactionId(transactionId);
		requestModel.setAdvId(redirectionUrl);
		requestModel.setAdvId(advId);
		requestModel.setPinPushRequest(redirectionUrl);
		requestModel.setProductId(productId);
		requestModel.setPartnerTransactionId(kpId);
		requestModel.setPubid(pubId);
		requestModel.setPortalId("107");
		repos.save(requestModel);
		return redirectionUrl;
	}

}
