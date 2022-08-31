package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Blog;

import java.util.List;

public interface BlogService {

    Blog createBlog(Blog blog);

//    int getCount();

    List<Blog> getAllBlog();

}
