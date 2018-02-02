package additional_activity.gsonLoader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreds {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "UserCreds[" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
