package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.Eq5d5lResultEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Eq5d5lRepository extends JpaRepository<Eq5d5lResultEntity, Integer> {

  Optional<Eq5d5lResultEntity> findByWeekNumber(Integer weekNumber);

}
