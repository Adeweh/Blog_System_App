package africa.semicolon.blogSystem.utils;

import africa.semicolon.blogSystem.data.models.Article;
import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.models.Comment;
import africa.semicolon.blogSystem.data.models.User;
import africa.semicolon.blogSystem.dtos.requests.AddArticleRequest;
import africa.semicolon.blogSystem.dtos.requests.AddCommentRequest;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import africa.semicolon.blogSystem.dtos.responses.FindArticleResponse;

public class Mapper {
    public static void map(RegisterUserRequest request, User user) {

        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static void map(AddArticleRequest request, Article newArticle){
        newArticle.setTitle(request.getTitle());
        newArticle.setBody(request.getBody());
        newArticle.setBody(request.getBody());
    }
    public static void map(AddCommentRequest request, Comment comment) {
        comment.setCommenter(request.getCommenter());
        comment.setContent(request.getContent());
    }

    public static void map(FindArticleResponse response, Article newArticle) {
        response.setTitle(newArticle.getTitle());
        response.setBody(newArticle.getBody());
        response.setBody(newArticle.getBody());
    }
}