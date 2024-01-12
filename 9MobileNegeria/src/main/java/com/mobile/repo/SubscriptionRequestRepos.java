package com.mobile.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.model.SubscriptionRequestModel;

@Repository
@Transactional
public interface SubscriptionRequestRepos extends JpaRepository<SubscriptionRequestModel, Long> {


}
