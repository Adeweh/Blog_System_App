package africa.semicolon.blogSystem.dtos.requests;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddArticleRequest {
    private String userName;
    private String title;
    private String body;
    private String blogName;

}
