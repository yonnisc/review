package com.organization.users.api;

import com.organization.users.api.models.UserCreationRequest;
import com.organization.users.service.UserService;
import com.organization.users.service.exceptions.UserServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsersController {

  private final UserService userService;

  @PostMapping
  @ResponseStatus(OK)
  public ResponseEntity<String> createNewUser(@RequestBody UserCreationRequest userCreationRequest) {
    try {
      if(userService.emailExists(userCreationRequest.getMail())) {
        return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
      }
      else {
        userService.create(userCreationRequest);
      }

    }catch (UserServiceException e) {
      return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(OK);
    }
}
