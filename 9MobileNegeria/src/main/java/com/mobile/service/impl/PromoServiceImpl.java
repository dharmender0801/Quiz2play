package com.mobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.PromotionTypeModel;
import com.mobile.repo.PromotionTypeRepo;
import com.mobile.service.PromotionService;

@Service
public class PromoServiceImpl implements PromotionService {

	@Autowired
	private PromotionTypeRepo promotionTypeRepo;

	@Override
	public PromotionTypeModel GetPromo(String portalid, Model model, String operatorId) {
		// TODO Auto-generated method stub
		PromotionTypeModel response = promotionTypeRepo.findByPortalidAndStatusAndOperatorid(portalid, "1", operatorId);
		model.addAttribute("msg1", response.getPageMsg1());
		model.addAttribute("msg2", response.getPageMsg2());
		model.addAttribute("unsubcode", response.getUnsubcode());
		model.addAttribute("country", response.getCountry());
		model.addAttribute("productId", response.getProductId());
		return response;
	}

}
