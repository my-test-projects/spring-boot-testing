package nao.cycledev.springboot.testing.services;

import nao.cycledev.springboot.testing.model.UserDTO;
import nao.cycledev.springboot.testing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        return UserDTO.create(userRepository.findAll());
    }

    @Override
    public UserDTO getById(long id) throws ClassNotFoundException {
        return UserDTO.create(userRepository.findById(id).orElseThrow(ClassNotFoundException::new));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO save(UserDTO user) {
        return UserDTO
                .create(userRepository.save(user.toUser()));
    }
}
