package africa.semicolon.blogSystem.dtos.responses;

import lombok.Data;

@Data
public class CreateBlogResponse {
    private String message;
    private String blogId;
}
