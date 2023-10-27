package com.nigeria.repos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nigeria.model.SubscriptionModel;

@Repository
public interface SubscriptionRepos extends JpaRepository<SubscriptionModel, Long> {

	SubscriptionModel findByMsisdnAndProductId(String msisdn, String productId);

	Optional<SubscriptionModel> findByMsisdn(String msisdn);

	List<SubscriptionModel> findByChargeDateBeforeAndProductIdIn(Date currentDate, List<String> productIds);
}
