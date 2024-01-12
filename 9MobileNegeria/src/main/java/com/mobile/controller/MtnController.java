package com.mobile.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobile.model.PromotionTypeModel;
import com.mobile.service.PromotionService;
import com.mobile.service.mtnService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MtnController {

	@Autowired
	private mtnService mtnService;
	@Autowired
	private PromotionService promotionService;

	@GetMapping("/mtn/subscribe")
	public String check(@RequestHeader(value = "User-Agent") String userAgent, Model model,
			@RequestParam(value = "cpId", required = false, defaultValue = "0") String cpId,
			@RequestParam(value = "kpId", required = false, defaultValue = "0") String kpId,
			@RequestParam(value = "pubId", required = false, defaultValue = "0") String pubId,
			@RequestParam(value = "language", required = false, defaultValue = "en") String language,
			@RequestHeader String Host) {
		PromotionTypeModel proModel = promotionService.GetPromo("106", model, "2");
		long requestId = (long) (Math.random() * 100000000000000L);
		mtnService.saveTransaction(userAgent, model, cpId, kpId, pubId, language, proModel.getProductId(), requestId);
		return "9mobile";
	}

	@GetMapping("/mtn/redirect")
	public String Redirection(HttpServletRequest request, HttpServletResponse response, Model model) {
//
//		model.addAttribute("text", "Your Subscription Request Is Unsuccessful");
//		model.addAttribute("img",
//				"https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Cross_red_circle.svg/512px-Cross_red_circle.svg.png?20181021160952");
		String redirectionUrl = mtnService.getRedirectionURl(request.getParameter("kpId"),
				request.getParameter("pubId"), request.getParameter("productId"), request.getParameter("language"),
				request.getParameter("transactionId"));
		System.out.println(redirectionUrl);
		return "redirect:http://" + redirectionUrl;
	}

	@RequestMapping(value = "/nigeria/mtn/echohe", method = RequestMethod.GET)
	public void heDetailGET(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.write(headerName);
			out.write("<br />");
			Enumeration headers = request.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = (String) headers.nextElement();
				out.write("&nbsp;&nbsp;&nbsp;&nbsp;" + headerValue);
				out.write("<br />");
			}
		}
		out.write("------------");
		out.write("Remote Addr : \"" + request.getRemoteAddr() + "\"");
		out.write("------------");

		out.close();
	}

	@GetMapping("/mtn/wifi")
	public String wifi(Model model, @RequestParam(value = "cpId", required = false, defaultValue = "0") String cpId,
			@RequestParam(value = "kpId", required = false, defaultValue = "0") String kpId,
			@RequestParam(value = "pubId", required = false, defaultValue = "0") String pubId,
			@RequestParam(value = "language", required = false, defaultValue = "en") String language) {
		PromotionTypeModel proModel = promotionService.GetPromo("106", model, "2");
		model.addAttribute("kpId", kpId);
		model.addAttribute("cpId", cpId);
		model.addAttribute("pubId", pubId);
		model.addAttribute("productId", proModel.getProductId());
		model.addAttribute("language", language);
		model.addAttribute("redirect", "/mtn/redirect");
		model.addAttribute("img", "https://static.gamezop.com/quiz-champion/assets/images/quiz-champions-logo.png");
		model.addAttribute("branding",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/MTN_Logo.svg/2048px-MTN_Logo.svg.png");

		return "9mobilewifi";
	}

}
