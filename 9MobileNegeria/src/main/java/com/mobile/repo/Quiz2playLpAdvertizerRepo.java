package com.mobile.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.model.Quiz2playLpAdvertizer;

public interface Quiz2playLpAdvertizerRepo extends JpaRepository<Quiz2playLpAdvertizer, Long> {
	Quiz2playLpAdvertizer findByCpIdAndStatus(String cpId, boolean b);

}