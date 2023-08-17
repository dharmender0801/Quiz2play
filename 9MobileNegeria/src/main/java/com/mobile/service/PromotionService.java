package com.mobile.service;

import org.springframework.ui.Model;

import com.mobile.model.PromotionTypeModel;

public interface PromotionService {

	PromotionTypeModel GetPromo(String string, Model model);

}
