package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nigeria.model.SubscriptionHistoryModel;

@Repository
@Transactional
public interface SubscriptionHistoryRepos extends JpaRepository<SubscriptionHistoryModel, Long>{

}
