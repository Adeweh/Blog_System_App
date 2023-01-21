package africa.semicolon.blogSystem.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor

public class Article {
    @Id
    private String id;
    private String title;
    private String body;
    private String blogName;
    private String writer;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
}
