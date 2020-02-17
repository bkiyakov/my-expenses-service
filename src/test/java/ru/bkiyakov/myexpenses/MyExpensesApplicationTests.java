package ru.bkiyakov.myexpenses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.bkiyakov.myexpenses.models.User;
import ru.bkiyakov.myexpenses.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MyExpensesApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    //TODO переделать с учетом аутентификации
    //https://reflectoring.io/spring-boot-test/
    @Test
    void registrationWorksThrowAllLayers() {
//        User newUser = new User();
//        newUser.setUsername("testuser");
//
//        mockMvc.perform(post)
    }

}
