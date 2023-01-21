package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddCommentRequest {
    private String commenter;
    private String articleTitle;
    private String content;
    private String blogName;
}
