package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobile.model.PromotionTypeModel;
import com.mobile.service.LpService;
import com.mobile.service.PromotionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class mobile9Controller {

	@Autowired
	private LpService lpService;

	@Autowired
	private PromotionService promotionService;

	@GetMapping("/9mobile/subscribe")
	public String homePage(@RequestHeader(value = "User-Agent") String userAgent, Model model,
			@RequestParam(value = "cpId", required = false, defaultValue = "0") String cpId,
			@RequestParam(value = "kpId", required = false, defaultValue = "0") String kpId,
			@RequestParam(value = "pubId", required = false, defaultValue = "0") String pubId,
			@RequestParam(value = "language", required = false, defaultValue = "en") String language,
			@RequestHeader String Host) {
		PromotionTypeModel proModel = promotionService.GetPromo("106", model);
		Boolean response = lpService.SaveToTransaction(userAgent, model, cpId, kpId, pubId, language,
				proModel.getProductId());
		String redirectionUrl = lpService.getRedirectionURl(kpId, pubId, proModel.getProductId(), language, Host);
		return response ? "9mobile" : "";
	}

	@GetMapping("/redirect")
	public String Redirection(@RequestHeader String Host, @RequestParam String kpId, @RequestParam String pubId,
			@RequestParam String productId, @RequestParam String language) {
		String redirectionUrl = lpService.getRedirectionURl(kpId, pubId, productId, language, Host);
		System.out.println(redirectionUrl);
		return "redirect:" + redirectionUrl;
	}

	@GetMapping("/9mobile/redirection")
	public String backRedirection(@RequestParam String status, @RequestParam String token, @RequestParam String kpId,
			@RequestParam String language, @RequestParam String productId,
			@RequestParam(value = "msisdn", required = false, defaultValue = "0") String msisdn) {
		String response = lpService.sendSubscriptionRequest(status,token,kpId,language,productId,msisdn);
		return "9mobilesucess";
	}

}
