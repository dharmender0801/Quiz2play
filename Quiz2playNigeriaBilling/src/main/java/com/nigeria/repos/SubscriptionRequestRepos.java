package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nigeria.model.SubscriptionRequestModel;

@Repository
@Transactional
public interface SubscriptionRequestRepos extends JpaRepository<SubscriptionRequestModel, Long> {

	SubscriptionRequestModel findByTransactionId(String transactionId);

	SubscriptionRequestModel findByMeta2(String ise2);

	SubscriptionRequestModel findByPartnerTransactionId(String kpid);

	SubscriptionRequestModel findByMsisdn(String msisdn);

}
