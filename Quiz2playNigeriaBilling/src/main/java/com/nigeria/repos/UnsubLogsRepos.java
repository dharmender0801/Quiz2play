package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nigeria.model.UnsubLogsModel;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface UnsubLogsRepos extends JpaRepository<UnsubLogsModel, Long> {

}
