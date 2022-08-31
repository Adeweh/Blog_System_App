package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.LoginUserRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.CreateBlogResponse;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import africa.semicolon.blogSystem.dtos.responses.RegisterUserResponse;

public interface UserService {
     RegisterUserResponse registerUser(RegisterUserRequest request);

     LoginUserResponse loginUser(LoginUserRequest request);

     CreateBlogResponse createUserBlog(CreateBlogRequest request);


}
