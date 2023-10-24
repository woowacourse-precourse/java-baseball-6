package baseball.model;

import java.util.ArrayList;
import java.util.List;

import baseball.validation.PlayerBallValidator;

public class Player {
    private final List<Integer> playerBalls = new ArrayList<>();

    public Player(final String playerInput) {
        validatePlayerBalls(playerInput);
        for (char c : playerInput.toCharArray()) {
            int playerBall = Character.getNumericValue(c);
            playerBalls.add(playerBall);
        }
    }

    private void validatePlayerBalls(final String playerInput) {
        PlayerBallValidator validator = new PlayerBallValidator();
        List<String> validResultList = validator.validate(playerInput);
        if (!validResultList.isEmpty()) {
            String exceptionMessage = validResultList.get(0);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public int getPlayerBall(final int inning) {
        return playerBalls.get(inning);
    }
}
