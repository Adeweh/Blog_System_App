package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserRequest {
    private String userName;
    private String email;
    private String password;
}
