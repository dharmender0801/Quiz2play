package com.mobile.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.service.LpService;
import com.mobile.utils.HttpRequets;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class LpServiceImpl implements LpService {

	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;

	@Value("${SubReqBody}")
	private String SubReqBody;

	@Value("${subUrl}")
	private String subUrl;

	@Override
	public Boolean SaveToTransaction(String userAgent, Model model, String cpId, String kpId, String pubId,
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

				InetAddress IP = InetAddress.getLocalHost();
				System.out.println(IP.toString());
				Quiz2playLpTransaction lpTranModel = new Quiz2playLpTransaction();
				lpTranModel.setAdvId(cpId);
				lpTranModel.setPubId(pubId);
				lpTranModel.setPartnerTransactionId(kpId);
				lpTranModel.setRequestDate(new Date());
				lpTranModel.setTransactionId(String.valueOf(requestId));
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
	public String getRedirectionURl(String kpId, String pubId, String productId, String language, String transId) {
		// TODO Auto-generated method stub
		String redirection = "https://lp.quiz2play.com/9mobile/redirection?kpId=" + kpId + "&productId=" + productId
				+ "" + "&language=" + language + "&transactionId=" + transId + "";
		String url = "http://msisdn.sla-alacrity.com/purchase?merchant=partner:29905e4f22cc93f337652a554165d60bf637b8ed&service=campaign:20b1b06bcf116d2388b84870a78ca4beb7fed222&correlator=123&redirect_url="
				+ redirection + "";
		return url;
	}

	@Override
	public String sendSubscriptionRequest(String status, String token, String kpId, String language, String productId,
			String msisdn, String transactionId) {
		String body = SubReqBody;
		String url = subUrl;

		Quiz2playLpTransaction lpModel = lpTransactionRepo.findByTransactionId(transactionId);
		if (lpModel != null) {
			body = body.replace("#productId#", productId);
			body = body.replace("#kpId#", kpId);
			body = body.replace("#lang#", language);
			body = body.replace("#token#", token);
			body = body.replace("#advId#", lpModel.getAdvId());
			body = body.replace("#pubId#", lpModel.getPubId());
			try {
				String response = HttpRequets.sendRequest(url, body);
				System.out.println(response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

}
