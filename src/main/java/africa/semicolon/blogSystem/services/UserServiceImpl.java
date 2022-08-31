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
        isExist(request);

        User user = new User();
        Mapper.map(request, user);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("Registration successful!!");
        return response;

    }
    private void isExist(RegisterUserRequest request) {
        User savedUser = userRepository.findByUserName(request.getEmail());
        if (savedUser != null) throw new UserExistsException(request.getEmail() + "User already exists");
    }


    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
        notExist(request);


        LoginUserResponse response = new LoginUserResponse();
        response.setMessage(String.format("Logged in successfully. Welcome back!"));

        return response;

    }

    @Override
    public CreateBlogResponse createUserBlog(CreateBlogRequest request) {
        Blog blog = new Blog();
        Mapper.map(request, blog);
        Blog savedBlog =blogService.createBlog(blog);
        var foundUser = getUser(request.getUserId());
        foundUser.setBlog(savedBlog);
        userRepository.save(foundUser);

        CreateBlogResponse response = new CreateBlogResponse();
        response.setMessage(String.format("Blog successfully created"));
        response.setBlogId(savedBlog.getId());

        return response;
    }

    private User getUser(String id) {
        User foundUser = userRepository.findUserById(id);
        return  foundUser;

    }

    private void notExist(LoginUserRequest request){



        User savedUser = userRepository.findByUserName(request.getEmail());
        if (savedUser == null) throw new UserDoesNotExistsException("Email not yet registered.");
        else if (!Objects.equals(savedUser.getPassword(), request.getPassword())) throw new  UserDoesNotExistsException("Invalid Password");


    }

}
