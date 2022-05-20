package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.OksQuestionResultEntity;
import com.kneerecoveryhelper.entity.OksResultEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OksQuestionRepository extends JpaRepository<OksQuestionResultEntity, Integer> {

  List<OksQuestionResultEntity> getAllByOksResultOrderByQuestionNumber(OksResultEntity oksResult);

}
