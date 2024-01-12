package com.mobile.service.impl;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.ProductConfigModel;
import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.repo.ProductConfigRepos;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.service.mtnService;

@Service
public class mtnServiceImpl implements mtnService {
	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;

	@Autowired
	private ProductConfigRepos configRepos;

	@Override
	public void saveTransaction(String userAgent, Model model, String cpId, String kpId, String pubId, String language,
			String productId, long requestId) {
		try {
			Quiz2playLpAdvertizer isActiveLpAdv = advertizerRepo.findByCpIdAndStatus(cpId, true);
			if (isActiveLpAdv != null) {
				model.addAttribute("kpId", kpId);
				model.addAttribute("cpId", cpId);
				model.addAttribute("pubId", pubId);
				model.addAttribute("productId", productId);
				model.addAttribute("language", language);
				model.addAttribute("transactionId", requestId);
				model.addAttribute("redirect", "/mtn/redirect");
				model.addAttribute("img",
						"https://static.gamezop.com/quiz-champion/assets/images/quiz-champions-logo.png");
				model.addAttribute("branding",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/MTN_Logo.svg/2048px-MTN_Logo.svg.png");
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
				lpTransactionRepo.save(lpTranModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getRedirectionURl(String kpId, String pubId, String productId, String language,
			String transactionId) {
		// TODO Auto-generated method stub
		ProductConfigModel productModel = configRepos.findByProductIdAndLanguage(productId, "en");
		String url = null;
		if (productModel != null) {
			url = productModel.getGraceDuration();
			url = url.replace("xxx", transactionId);
		}
		return url;
	}

}
