package com.mobile.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.model.Quiz2playLpTransaction;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface Quiz2playLpTransactionRepo extends JpaRepository<Quiz2playLpTransaction, Long> {
	Quiz2playLpTransaction findFirstByPartnerTransactionIdOrderByRequestDateDesc(String kpId);

	Quiz2playLpTransaction findByPartnerTransactionIdAndTransactionId(String kpId, String tranId);

	Quiz2playLpTransaction findByTransactionId(String transactionId);

}
