package com.mobile.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.service.LpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class LpServiceImpl implements LpService {

	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;

	@Override
	public Boolean SaveToTransaction(String userAgent, Model model, String cpId, String kpId, String pubId,
			String language, String productId) {
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
				lpTransactionRepo.save(lpTranModel);
				response = true;
			} else {
				response = false;
			}
		} catch (IOException e) {
			response = false;
		}
		return response;
	}

	@Override
	public String getRedirectionURl(String kpId, String pubId, String productId, String language, String host) {
		// TODO Auto-generated method stub
		String redirection = host + "/9mobile/redirection?kpId=" + kpId + "&productId=" + productId + "" + "&langauge="
				+ language + "";
		String url = "http://msisdn.sla-alacrity.com/purchase?merchant=partner:29905e4f22cc93f337652a554165d60bf637b8ed&service=campaign:20b1b06bcf116d2388b84870a78ca4beb7fed222&redirect_url="
				+ redirection + "&correlator=123 ";
		return url;
	}

	@Override
	public String sendSubscriptionRequest(String status, String token, String kpId, String language, String productId,
			String msisdn) {
		Quiz2playLpTransaction lpModel = lpTransactionRepo.findFirstByPartnerTransactionIdOrderByRequestDateDesc(kpId);
		lpModel.setMeta2(msisdn);
		lpModel.setPinSendResponse(token);
		lpTransactionRepo.save(lpModel);
		return null;
	}

}
