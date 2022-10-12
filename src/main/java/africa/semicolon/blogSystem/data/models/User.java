package africa.semicolon.blogSystem.data.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String userName;
    @DBRef
    private Blog blog;
    private String email;
    private String password;

}
