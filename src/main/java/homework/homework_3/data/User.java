package homework.homework_3.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    public static User PITER_CHAILOVSKII = new User("epam", "1234", "Piter Chailovskii");

    private String login;
    private String password;
    private String userName;
}
