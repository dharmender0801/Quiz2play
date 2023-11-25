package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		long requestId = (long) (Math.random() * 100000000000000L);
		Boolean response = lpService.SaveToTransaction(userAgent, model, cpId, kpId, pubId, language,
				proModel.getProductId(), requestId);

		String redirectionUrl = lpService.getRedirectionURl(kpId, pubId, proModel.getProductId(), language,
				String.valueOf(requestId));
		return response ? "9mobile" : "";
	}

	@GetMapping("/9mobile/redirect")
	public String Redirection(HttpServletRequest request, HttpServletResponse response) {
		String redirectionUrl = lpService.getRedirectionURl(request.getParameter("kpId"), request.getParameter("pubId"),
				request.getParameter("productId"), request.getParameter("language"),
				request.getParameter("transactionId"));
		System.out.println(redirectionUrl);
		return "redirect:" + redirectionUrl;
	}

	@GetMapping("/9mobile/redirection")
	public String backRedirection(@RequestParam(required = false) String status,
			@RequestParam(required = false, defaultValue = "0") String token,
			@RequestParam(required = false, defaultValue = "0") String kpId,
			@RequestParam(required = false, defaultValue = "en") String language,
			@RequestParam(required = false, defaultValue = "1020") String productId,
			@RequestParam(value = "msisdn", required = false, defaultValue = "0") String msisdn,
			@RequestParam String transactionId, Model model

	) {
		System.out.println("Token - : :  " + token);
		String response = lpService.sendSubscriptionRequest(status, token, kpId, language, productId, msisdn,
				transactionId, model);
		System.out.println(model.getAttribute("text"));
		return "9mobilesucess";
	}

	@GetMapping("/9mobile/redirection/url")
	public ResponseEntity<String> getRedirect(@RequestParam String productId) {
		return new ResponseEntity<String>(lpService.getURL(productId),HttpStatus.OK);
	}

}
