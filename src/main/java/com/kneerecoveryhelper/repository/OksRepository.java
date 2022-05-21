package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.OksResultEntity;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OksRepository extends JpaRepository<OksResultEntity, Integer> {

  Optional<OksResultEntity> findByWeekNumber(Integer weekNumber);

}
