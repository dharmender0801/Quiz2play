package com.mobile.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.model.ProductConfigModel;
import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.repo.ProductConfigRepos;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.service.LpService;
import com.mobile.utils.HttpRequets;

@Service
public class LpServiceImpl implements LpService {

	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;

	@Autowired
	private ProductConfigRepos configRepos;

//	@Autowired
//	private RestTemplate restTemplate;

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
				model.addAttribute("redirect", "/9mobile/redirect");
				model.addAttribute("img", "/images/10666.png");
				model.addAttribute("branding", "/images/download (1).png");
				model.addAttribute("suport", "Support email:");
				model.addAttribute("email", "Nextgen@altruistindia.com");

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
		System.out.println(productId);
		ProductConfigModel productModel = configRepos.findByProductIdAndLanguage(productId, "en");
		String url = null;
		if (productModel != null) {
			String redirection = "https://lp.quiz2play.com/9mobile/redirection?kpId=" + kpId + "&productId=" + productId
					+ "" + "&language=" + language + "&transactionId=" + transId + "";
			url = "http://checkout.sla-alacrity.com/purchase?merchant=" + productModel.getGraceDuration() + "&service="
					+ productModel.getCredit() + "&correlator=123&redirect_url=" + redirection + "";
		}
		return url;
	}

	@Override
	public String sendSubscriptionRequest(String status, String token, String kpId, String language, String productId,
			String msisdn, String transactionId, Model model) {
		String response = null;
		String Backresonse = null;
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
				response = HttpRequets.sendRequest(url, body);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = mapper.readTree(response);
				Backresonse = node.get("statusCode").asText();
				if (Backresonse.equalsIgnoreCase("200")) {
					model.addAttribute("text", "Your Subscription Request Is Successful");
					model.addAttribute("img", "http://lp.quiz2play.com/images/right.png");
				} else {
					model.addAttribute("text", "Your Subscription Request Is Unsuccessful");
					model.addAttribute("img",
							"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/512px-Cross_red_circle.svg.png?20181021160952");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(response);

		} else {
			body = body.replace("#productId#", productId);
			body = body.replace("#kpId#", "0");
			body = body.replace("#lang#", language);
			body = body.replace("#token#", token);
			body = body.replace("#advId#", "0");
			body = body.replace("#pubId#", "0");
			try {
				response = HttpRequets.sendRequest(url, body);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = mapper.readTree(response);
				Backresonse = node.get("statusCode").asText();
				if (Backresonse.equalsIgnoreCase("200")) {
					model.addAttribute("text", "Your Subscription Request Is Successful");
					model.addAttribute("img", "http://lp.quiz2play.com/images/right.png");
				} else {
					model.addAttribute("text", "Your Subscription Request Is Unsuccessful");
					model.addAttribute("img",
							"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/512px-Cross_red_circle.svg.png?20181021160952");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Backresonse;
	}

	@Override
	public String getURL(String productId) {
		// TODO Auto-generated method stub
		return getRedirectionURl("0", "0", productId, "en", "0");
	}

}
