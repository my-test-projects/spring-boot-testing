package nao.cycledev.springboot.testing.repositories;

import nao.cycledev.springboot.testing.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByIdTest() {
        User user = new User();
        user.setUserName("deniel2018");
        entityManager.persist(user);
        entityManager.flush();

        User user2 = userRepository.findByUserName("deniel2018").orElse(new User());

        assertThat(user2.getId(), is(notNullValue()));
        assertThat(user.getUserName(), is(user2.getUserName()));
    }
}