package com.kneerecoveryhelper.repository;

import com.kneerecoveryhelper.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  Optional<UserEntity> findByEmail(String email);

}
