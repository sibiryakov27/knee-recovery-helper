package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.PatientEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

  Optional<PatientEntity> findByEmail(String email);

}
