package baseball.Model;

import java.util.List;

public class User {
    private final List<Integer> userNumber;

    private User(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }
}
