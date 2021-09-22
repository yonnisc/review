package com.organization.users.service;

import com.organization.users.api.models.UserCreationRequest;
import com.organization.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  public void create(UserCreationRequest user) {
    userRepository.save(user);
  }

  public boolean emailExists(String mail) {
    if (userRepository.findByMail(mail).isPresent()) {
      return true;
    } else return false;
  }
}
