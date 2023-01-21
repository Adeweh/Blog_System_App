package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FindArticleRequest {
    private String userName;
    private String title;
    private String body;
    private String blogName;
}
