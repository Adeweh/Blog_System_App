package africa.semicolon.blogSystem.dtos.responses;

import africa.semicolon.blogSystem.data.models.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class RegisterUserResponse {
    private String message;
}
