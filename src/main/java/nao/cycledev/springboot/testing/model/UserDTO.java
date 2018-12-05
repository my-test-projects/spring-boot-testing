package nao.cycledev.springboot.testing.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    @NotBlank
    private String userName;

    public static UserDTO create(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static List<UserDTO> create(List<User> users) {
        return users.stream()
                .map(UserDTO::create)
                .collect(Collectors.toList());
    }

    public User toUser() {
        return User.builder()
                .id(getId())
                .userName(getUserName())
                .build();
    }
}
