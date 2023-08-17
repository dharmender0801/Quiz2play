package com.mobile.service;

import org.springframework.ui.Model;

public interface LpService {

	Boolean SaveToTransaction(String userAgent, Model model, String cpId, String kpId, String pubId, String language,
			String productId);

}
