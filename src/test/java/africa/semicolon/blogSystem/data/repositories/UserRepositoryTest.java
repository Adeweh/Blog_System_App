package africa.semicolon.blogSystem.data.repositories;

import africa.semicolon.blogSystem.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest(){
        User user = new User();
        var savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());


    }

}