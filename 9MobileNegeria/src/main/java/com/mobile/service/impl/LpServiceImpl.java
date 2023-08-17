package com.mobile.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mobile.model.Quiz2playLpAdvertizer;
import com.mobile.model.Quiz2playLpTransaction;
import com.mobile.repo.Quiz2playLpAdvertizerRepo;
import com.mobile.repo.Quiz2playLpTransactionRepo;
import com.mobile.service.LpService;

@Service
public class LpServiceImpl implements LpService {

	@Autowired
	private Quiz2playLpTransactionRepo lpTransactionRepo;
	@Autowired
	private Quiz2playLpAdvertizerRepo advertizerRepo;

	@Override
	public Boolean SaveToTransaction(String userAgent, Model model, String cpId, String kpId, String pubId,
			String language, String productId) {
		// TODO Auto-generated method stub
		Boolean response = false;
		try {
			Quiz2playLpAdvertizer isActiveLpAdv = advertizerRepo.findByCpIdAndStatus(cpId, true);
			if (isActiveLpAdv != null) {
				model.addAttribute("kpId", kpId);
				model.addAttribute("cpId", cpId);
				model.addAttribute("packageId", productId);
				InetAddress IP = InetAddress.getLocalHost();
				System.out.println(IP.toString());
				System.out.println(cpId);
				Quiz2playLpTransaction lpTranModel = new Quiz2playLpTransaction();
				lpTranModel.setAdvId(cpId);
				lpTranModel.setPubId(pubId);
				lpTranModel.setPartnerTransactionId(kpId);
				lpTranModel.setRequestDate(new Date());
				lpTranModel.setIpAdress(IP.toString());
				lpTranModel.setUserAgent(userAgent);
				lpTranModel.setProductId(productId);
				lpTransactionRepo.save(lpTranModel);
				response = true;
			} else {
				response = false;
			}
		} catch (IOException e) {
			response = false;
		}
		return response;
	}

}
