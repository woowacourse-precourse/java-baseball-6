package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.domain.Ball.*;
import static baseball.domain.GameResult.EXIT;
import static baseball.domain.GameResult.RESTART;

public class GameService {

    public Game createGame() {
        return new Game(generateComputerBalls());
    }

    private Balls generateComputerBalls() {
        return new Balls(createComputerBalls(generateRandomBallNumbers()));
    }

    private List<Integer> generateRandomBallNumbers() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < BALL_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_BALL, MAX_BALL));
        }
        return new ArrayList<>(ballNumbers);
    }

    private List<Ball> createComputerBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
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
