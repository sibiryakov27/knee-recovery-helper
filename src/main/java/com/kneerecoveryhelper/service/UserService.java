package com.kneerecoveryhelper.service;

import com.kneerecoveryhelper.entity.UserEntity;
import com.kneerecoveryhelper.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserEntity> user = userRepository.findByEmail(username);
    return user.get(); // TODO: added checking optional
  }

}
