package nao.cycledev.springboot.testing.controllers;

import nao.cycledev.springboot.testing.model.UserDTO;
import nao.cycledev.springboot.testing.services.UserService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserTest() throws Exception {
        UserDTO userDTO = new UserDTO(1, "noprysk");

        Mockito.when(userService.getById(1L)).thenReturn(userDTO);

        mvc.perform(get("/users/1")).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.userName", Matchers.is(userDTO.getUserName())));
    }
}