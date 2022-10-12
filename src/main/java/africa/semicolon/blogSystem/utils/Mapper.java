package africa.semicolon.blogSystem.utils;

import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.models.User;
import africa.semicolon.blogSystem.dtos.requests.CreateBlogRequest;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;

public class Mapper {
    public static void map(RegisterUserRequest request, User user) {

        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
    }

    public static void map(CreateBlogRequest request, Blog blog){

    }
}