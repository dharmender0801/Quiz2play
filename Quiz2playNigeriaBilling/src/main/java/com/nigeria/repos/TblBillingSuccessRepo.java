package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nigeria.model.TblBillingSuccess;

@Repository
public interface TblBillingSuccessRepo extends JpaRepository<TblBillingSuccess, Long> {

	@Query(value = "SELECT * FROM tbl_billing_success WHERE msisdn = :msisdn AND DATE(date_time)=DATE(NOW()) LIMIT 1", nativeQuery = true)

	TblBillingSuccess findFirstByCurrentDate(@Param("msisdn") String msisdn);



}
