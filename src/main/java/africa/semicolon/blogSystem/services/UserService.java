package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.RegisterUserResponse;

public interface UserService {
     RegisterUserResponse registerUser(RegisterUserRequest request);
}
