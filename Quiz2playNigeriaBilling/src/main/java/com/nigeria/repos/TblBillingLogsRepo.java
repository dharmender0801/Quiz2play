package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nigeria.model.TblBillingLogs;

@Repository
public interface TblBillingLogsRepo extends JpaRepository<TblBillingLogs, Long>{

}
