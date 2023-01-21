package africa.semicolon.blogSystem.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    private String id;
    private String content;
    private String commenter;

}
