package com.organization.users.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCreationRequest {
  String mail;
  String first_name;
  String last_name;

}
