package com.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobile.model.PromotionTypeModel;
import com.mobile.service.PromotionService;
import com.mobile.service.thailandserv;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ThailandController {
	@Autowired
	private thailandserv thailandserv;
	@Autowired
	private PromotionService promotionService;

	@GetMapping("/ais/subscribe")
	public String aisRequest(@RequestHeader(value = "User-Agent") String userAgent, Model model,
			@RequestParam(value = "cpId", required = false, defaultValue = "0") String cpId,
			@RequestParam(value = "kpId", required = false, defaultValue = "0") String kpId,
			@RequestParam(value = "pubId", required = false, defaultValue = "0") String pubId,
			@RequestParam(value = "language", required = false, defaultValue = "en") String language,
			@RequestHeader String Host) {
		PromotionTypeModel proModel = promotionService.GetPromo("107", model, "1");
		long requestId = (long) (Math.random() * 100000000000000L);
		Boolean resp = thailandserv.saveTransaction(userAgent, model, cpId, kpId, pubId, language,
				proModel.getProductId(), requestId);
		return resp ? "9mobile" : "9mobilesucess";
	}

	@GetMapping("/ais/redirect")
	public String Redirection(HttpServletRequest request, HttpServletResponse response, Model model) {
		String redirectionUrl = thailandserv.getRedirectionURl(request.getParameter("kpId"),
				request.getParameter("pubId"), request.getParameter("productId"), request.getParameter("language"),
				request.getParameter("transactionId"), request.getParameter("cpId"));
		System.out.println(redirectionUrl);
		return "redirect:http://" + redirectionUrl;
	}

}
