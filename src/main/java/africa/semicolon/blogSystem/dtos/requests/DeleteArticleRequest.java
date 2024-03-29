package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeleteArticleRequest {
    private String title;
    private String blogName;
    private String userName;
}
