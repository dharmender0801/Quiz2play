package com.mobile.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PromotionTypeModel proModel = promotionService.GetPromo("106", model);
		mtnService.saveTransaction(userAgent, model, cpId, kpId, pubId, language, proModel.getProductId());
		return "9mobile";
	}

	@RequestMapping(value = { "/nigeria/mtn/echohe" }, method = { RequestMethod.GET, RequestMethod.POST })
	public void heDetail(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Request Headers</h1>");

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println("<strong>" + headerName + "</strong>: " + request.getHeader(headerName) + "<br>");
		}

		out.println("</body></html>");
		out.close();
	}

}
