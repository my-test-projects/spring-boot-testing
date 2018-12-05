package nao.cycledev.springboot.testing.services;

import nao.cycledev.springboot.testing.model.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getById(long id) throws ClassNotFoundException;
    void delete(long id);
    UserDTO save(UserDTO user);
}
