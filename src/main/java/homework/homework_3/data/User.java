package homework.homework_3.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String login;
    private String password;
//    private String userName;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
