package com.mobile.service;

import org.springframework.ui.Model;

public interface mtnService {

	void saveTransaction(String userAgent, Model model, String cpId, String kpId, String pubId, String language, String string, long requestId);

	String getRedirectionURl(String parameter, String parameter2, String parameter3, String parameter4,
			String parameter5);

}
