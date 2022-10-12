package africa.semicolon.blogSystem.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userName;
    private String email;
    private String password;
}
