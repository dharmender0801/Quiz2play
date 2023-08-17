package com.mobile.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.model.PromotionTypeModel;

@Transactional
@Repository
public interface PromotionTypeRepo extends JpaRepository<PromotionTypeModel, Integer> {

	PromotionTypeModel findByPortalidAndStatus(String portalId, String status);

	List<PromotionTypeModel> findByPortalid(String portalId);

	PromotionTypeModel findByPortalidAndPackType(String portalId, String packtype);

	PromotionTypeModel findByPortalidAndStatusAndOperatorid(String portalId, String packtype, String operatorid);

	List<PromotionTypeModel> findByStatus(String status);

	List<PromotionTypeModel> findByPortalidAndOperatorid(String portalid, String opid);

	List<PromotionTypeModel> findByCurrencyAndStatus(String string, String string2);

	PromotionTypeModel findByPortalidAndStatusAndOperatoridAndLanguage(String portalId, String string,
			String operatorid, String language);

}
