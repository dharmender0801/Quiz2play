package com.mobile.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.service.mtnService;

@Service
public class mtnServiceImpl implements mtnService {


	@Override
	public void saveTransaction(String userAgent, Model model, String cpId, String kpId, String pubId, String language,
			String productId) {
		
		model.addAttribute("kpId", kpId);
		model.addAttribute("cpId", cpId);
		model.addAttribute("pubId", pubId);
		model.addAttribute("productId", productId);
		model.addAttribute("language", language);
		model.addAttribute("redirect", "/mtn/redirect");
		model.addAttribute("img", "https://static.gamezop.com/quiz-champion/assets/images/quiz-champions-logo.png");
		model.addAttribute("branding",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/MTN_Logo.svg/2048px-MTN_Logo.svg.png");

		// TODO Auto-generated method stub
		
	}

}
