package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateBlogRequest {
    private String name;
    private String userName;
    private String description;

}
