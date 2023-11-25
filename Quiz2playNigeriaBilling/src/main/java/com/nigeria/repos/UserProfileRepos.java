package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nigeria.model.UserProfileModel;

@Repository
@Transactional
public interface UserProfileRepos extends JpaRepository<UserProfileModel, Long> {

	@Modifying
	@Query(value = "delete from quiz2play_user_profile where subscription_id=:id", nativeQuery = true)
	void deleteFromSubscriptionId(Long id);

}
