package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.dtos.requests.*;
import africa.semicolon.blogSystem.dtos.responses.*;

public interface UserService {
     RegisterUserResponse registerUser(RegisterUserRequest request);

     LoginUserResponse loginUser(LoginUserRequest request);

     CreateBlogResponse createUserBlog(CreateBlogRequest request);


     AddArticleResponse addArticle(AddArticleRequest articleRequest);

    DeleteArticleRequest deleteArticle(DeleteArticleRequest deleteRequest);

    FindArticleResponse viewArticle(FindArticleRequest findArticleRequest);
}
