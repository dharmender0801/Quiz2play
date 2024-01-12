package com.nigeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nigeria.model.ProductConfigModel;

@Repository
@Transactional
public interface ProductConfigRepos extends JpaRepository<ProductConfigModel, Long> {

	ProductConfigModel findByProductId(String productId);

	ProductConfigModel findByProductIdAndLanguage(String productId, String language);

	ProductConfigModel findByCreditAndLanguage(String offerCode, String string);

	ProductConfigModel findByCredit(String packName);

}
