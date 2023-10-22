package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public Game createGame() {
        return new Game();
    }

    public Balls generatePlayerBalls(String playerGuess) {
        return new Balls(createPlayerBalls(playerGuess));
    }

    private List<Ball> createPlayerBalls(String playerGuess) {
        if (playerGuess == null || playerGuess.isBlank()) {
            throw new IllegalArgumentException("입력은 숫자만 포함해야 합니다.");
        }

        return playerGuess.chars()
                .mapToObj(ballNumber -> new Ball(Character.getNumericValue(ballNumber)))
                .collect(Collectors.toList());
    }

    public boolean restartGame(String choice) {
        if (choice.equals(RESTART)) {
            return true;
        } else if (choice.equals(EXIT)) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2 중 하나의 유효한 입력이 필요합니다.");
    }
}
