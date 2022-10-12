package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.models.User;
import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.LoginUserRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.CreateBlogResponse;
import africa.semicolon.blogSystem.dtos.responses.LoginUserResponse;
import africa.semicolon.blogSystem.dtos.responses.RegisterUserResponse;
import africa.semicolon.blogSystem.exceptions.BlogServiceException;
import africa.semicolon.blogSystem.exceptions.PasswordIncorrectException;
import africa.semicolon.blogSystem.exceptions.UserDoesNotExistsException;
import africa.semicolon.blogSystem.exceptions.UserExistsException;
import africa.semicolon.blogSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogService blogService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        userExist(request);

        User user = new User();
        Mapper.map(request, user);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration successful!!");
        return response;

    }
    private void userExist(RegisterUserRequest request) {
        User savedUser = userRepository.findByUserName(request.getUserName());
        if (savedUser != null) throw new UserExistsException(request.getUserName() + "User already exists");
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        checkUser(request);

        LoginUserResponse response = new LoginUserResponse();
        response.setMessage(String.format("Logged in successfully. Welcome back!"));

        return response;

    }
    private void checkUser(LoginUserRequest request) {
        User savedUser = userRepository.findByUserName(request.getUserName());
        if(savedUser == null) throw new UserDoesNotExistsException("User not yet registered.");
        else if (!Objects.equals(savedUser.getPassword(), request.getPassword())) throw new PasswordIncorrectException("This password is incorrect.");


    }

    @Override
    public CreateBlogResponse createUserBlog(CreateBlogRequest request) {
        checkBlog(request);


        Blog blog = new Blog();
        Mapper.map(request, blog);
        Blog savedBlog =blogService.createBlog(blog);
        var foundUser = userRepository.findByUserName(request.getUserName());
        foundUser.setBlog(savedBlog);
        userRepository.save(foundUser);

        CreateBlogResponse response = new CreateBlogResponse();
        response.setMessage(String.format("Blog successfully created"));

        return response;
    }
    private void checkBlog(CreateBlogRequest request) {
        User registerUser = userRepository.findByUserName(request.getUserName());
        if (registerUser.getBlog()!= null) throw new BlogServiceException("You cannot have more than a blog");
    }


}
