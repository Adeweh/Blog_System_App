package africa.semicolon.blogSystem.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
@NoArgsConstructor
@Data
public class Blog {
    @Id
    private String id;
    private String title;
    private String description;
    @DBRef
    private List<Article> articles = new ArrayList<>();

}
