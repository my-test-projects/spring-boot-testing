package nao.cycledev.springboot.testing.controllers;

import nao.cycledev.springboot.testing.model.UserDTO;
import nao.cycledev.springboot.testing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") long id) throws ClassNotFoundException {
        return userService.getById(id);
    }

    @PostMapping("/")
    public UserDTO createUser(@RequestBody @Valid UserDTO user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
    }
}
