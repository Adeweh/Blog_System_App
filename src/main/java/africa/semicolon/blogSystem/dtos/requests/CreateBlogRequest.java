package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;

@Data
public class CreateBlogRequest {
    private String title;
    private String userName;
    private String description;

}
