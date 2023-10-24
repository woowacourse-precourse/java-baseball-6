package baseball.Model;

import java.util.List;

public class User {
    private final List<Integer> userNumber;

    private User(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public static User createByNumber(List<Integer> playerNumber) {
        return new User(playerNumber);
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
