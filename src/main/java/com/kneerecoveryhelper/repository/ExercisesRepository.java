package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.ExercisesEntity;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Integer> {

  Optional<ExercisesEntity> findByExerciseDate(Date date);

}
