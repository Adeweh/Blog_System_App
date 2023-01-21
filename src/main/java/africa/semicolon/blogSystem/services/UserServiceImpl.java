package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.models.User;
import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.*;
import africa.semicolon.blogSystem.dtos.responses.*;
import africa.semicolon.blogSystem.exceptions.BlogExistsException;
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

        Blog savedBlog =blogService.createBlog(request);
        var foundUser = userRepository.findByUserName(request.getUserName());
        foundUser.setBlog(savedBlog);
        userRepository.save(foundUser);

        CreateBlogResponse response = new CreateBlogResponse();
        response.setMessage(String.format("Blog successfully created"));

        return response;
    }

    private void checkBlog(CreateBlogRequest request) {
        User registerUser = userRepository.findByUserName(request.getUserName());
        if (registerUser.getBlog()!= null) throw new BlogExistsException("You cannot have more than a blog");
    }
    @Override
    public AddArticleResponse addArticle(AddArticleRequest articleRequest) {
        blogService.addArticle(articleRequest);

        AddArticleResponse response = new AddArticleResponse();
        response.setMessage(String.format("Article added to your blog"));


        return response;
    }

    @Override
    public DeleteArticleRequest deleteArticle(DeleteArticleRequest request) {
        blogService.deleteArticle(request);

        return request;
    }

    @Override
    public FindArticleResponse viewArticle(FindArticleRequest findArticleRequest) {
       Article newArticle= blogService.viewArticle(findArticleRequest);
       FindArticleResponse response = new FindArticleResponse();
       Mapper.map(response, newArticle);
       response.setBlogName(newArticle.getBlogName());

        return response;
    }


}
