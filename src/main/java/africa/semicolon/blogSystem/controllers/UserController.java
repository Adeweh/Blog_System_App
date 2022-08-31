package africa.semicolon.blogSystem.controllers;

import africa.semicolon.blogSystem.dtos.requests.LoginUserRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import africa.semicolon.blogSystem.dtos.responses.RegisterUserResponse;
import africa.semicolon.blogSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

@Autowired
    UserService userService;

@PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest register){
    try{
        RegisterUserResponse response = userService.registerUser(register);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }catch (Exception err){
        return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);   }

       // return userService.registerUser(registerUserRequest);

}

@GetMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest loginUserRequest){
    try {
        LoginUserResponse loginUserResponse = userService.loginUser(loginUserRequest);
        return new ResponseEntity<>(loginUserResponse, HttpStatus.OK);
    } catch (Exception err){
        return new ResponseEntity<>(err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }


}


}
