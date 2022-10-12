package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginUserRequest {
    private String userName;
    private String password;
}
