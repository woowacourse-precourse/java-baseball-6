package baseball.Dto;

import java.util.Collections;
import java.util.List;

public class UserNumbers {
    private List<Integer> user;
    private static UserNumbers instance;

    private UserNumbers() {}

    public static synchronized UserNumbers getInstance() {
        if (instance == null) {
            instance = new UserNumbers();
        }
        return instance;
    }

    public void createUserNumbers(List<Integer> userNumbers) {
        this.user = userNumbers;
    }

    public List<Integer> requestUserNumbers() {
        return Collections.unmodifiableList(user);
    }
}
