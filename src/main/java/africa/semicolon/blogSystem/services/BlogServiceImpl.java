package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Blog;
import africa.semicolon.blogSystem.data.repositories.BlogRepository;
import africa.semicolon.blogSystem.dtos.responses.CreateBlogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;
    @Override
    public Blog createBlog(Blog blog) {
        blogRepository.save(blog);


        return blog;

    }

    @Override
    public List<Blog> getAllBlog() {
        List allBlog = blogRepository.findAll();
        return allBlog;
    }
}
