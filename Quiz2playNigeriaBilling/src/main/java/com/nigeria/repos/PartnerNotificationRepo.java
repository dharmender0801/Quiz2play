package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nigeria.model.PartnerNoticationRequest;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface PartnerNotificationRepo extends JpaRepository<PartnerNoticationRequest, Long> {

}
