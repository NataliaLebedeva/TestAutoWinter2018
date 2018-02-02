package homework.homework_7_JDI.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfo {
    public static final UserContactInfo USER_CONTACT_INFO = new UserContactInfo(
            "Peter",
            "Chailovskii",
            "Just some small text to check",
            true,
            Arrays.asList(5, 4)
    );

    private String name;
    private String lastName;
    private String description;
    private Boolean isAccepted;
    private List<Integer> summary;

    public List<String> toLog() {
        return new LinkedList<String>(){{
           add(String.format("Summary: %s", summary.stream().mapToInt(Integer::new).sum()));
           add(String.format("Name: %s", name));
           add(String.format("Last Name: %s", lastName));
           add(String.format("Description: %s", description));
        }};
    }

}
