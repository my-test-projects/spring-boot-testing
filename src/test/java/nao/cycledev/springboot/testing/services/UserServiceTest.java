package nao.cycledev.springboot.testing.services;

import nao.cycledev.springboot.testing.model.User;
import nao.cycledev.springboot.testing.model.UserDTO;
import nao.cycledev.springboot.testing.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User(1, "loprysk");
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    }

    @Test
    public void testFindUserById() throws ClassNotFoundException {
       UserDTO userDTO = userService.getById(1);

       assertThat(userDTO.getId(), is(1L));
       assertThat(userDTO.getUserName(), is("loprysk"));
    }
}