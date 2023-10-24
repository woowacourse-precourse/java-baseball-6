package baseball.domain.model;

import baseball.utils.InputValidator;

import java.util.List;

public class User {
    private final List<String> user;

    public User(final List<String> user) {
        this.user = user;
    }

    public User(final String ballInput) {
        InputValidator.checkUserBallInput(ballInput);
        this.user = makeBallsFromInput(ballInput);
    }

    private List<String> makeBallsFromInput(final String ballInput) {
        return List.of(ballInput.split(""));
    }
}
