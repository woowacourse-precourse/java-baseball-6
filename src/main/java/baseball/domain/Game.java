package baseball.domain;

import java.util.List;

public class Game {
    private List<Integer> targetNumber;
    private User user;

    public Game(List<Integer> targetNumber, User user) {
        this.targetNumber = targetNumber;
        this.user = user;
    }

    public List<Integer> getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
