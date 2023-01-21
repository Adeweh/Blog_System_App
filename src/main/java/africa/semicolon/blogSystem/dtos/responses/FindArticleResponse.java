package africa.semicolon.blogSystem.dtos.responses;

import africa.semicolon.blogSystem.data.models.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FindArticleResponse {
    private String writer;
    private String blogName;
    private String title;
    private String body;
    private List<Comment> comments;
}
