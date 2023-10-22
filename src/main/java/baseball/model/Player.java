package baseball.model;

import java.util.List;

import baseball.validation.PlayerBallValidator;

public class Player {
    public Player(final String playerInput) {
        validatePlayerBalls(playerInput);
    }

    private void validatePlayerBalls(final String playerInput) {
        PlayerBallValidator validator = new PlayerBallValidator();
        List<String> validResultList = validator.validate(playerInput);
        if (!validResultList.isEmpty()) {
            String exceptionMessage = validResultList.get(0);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
