package com.organization.users.repository;

import com.organization.users.api.models.UserCreationRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserCreationRequest, String> {
  Optional<UserCreationRequest> findByMail(String email);
}
