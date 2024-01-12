package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nigeria.model.SdpNoticationLogsModel;

public interface SdpNoticationLogsRepos extends JpaRepository<SdpNoticationLogsModel, Long> {

}
