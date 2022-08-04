package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.repositories.UserRepository;
import africa.semicolon.blogSystem.dtos.requests.RegisterUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerUser_repositorySizeIsOneTest(){
        //given that i have a register form
        RegisterUserRequest registerUserForm = new RegisterUserRequest();
        //when i try to register
        registerUserForm.setEmail("dorcas");
        registerUserForm.setPassword("iLoveJesus222");
        userService.registerUser(registerUserForm);
        //check that repository size has increased
        assertEquals(1L, userRepository.count());
      //  assertThat(userRepository.count(), is(1l));

    }

}