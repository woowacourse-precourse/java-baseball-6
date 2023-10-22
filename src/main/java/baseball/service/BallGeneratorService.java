package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.domain.Ball.*;

public class BallGeneratorService {
    public Balls generateRandomBalls() {
        return new Balls(createRandomBalls(generateRandomBallNumbers()));
    }

    private List<Integer> generateRandomBallNumbers() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < BALL_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_BALL, MAX_BALL));
        }
        return new ArrayList<>(ballNumbers);
    }

    private List<Ball> createRandomBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public Balls generatePlayerBalls(String playerGuess) {
        return new Balls(convertStringToBalls(playerGuess));
    }

    private List<Ball> convertStringToBalls(String playerGuess) {
        if (playerGuess == null || playerGuess.isBlank()) {
            throw new IllegalArgumentException("입력은 숫자만 포함해야 합니다.");
        }

        return playerGuess.chars()
                .mapToObj(ballNumber -> new Ball(Character.getNumericValue(ballNumber)))
                .collect(Collectors.toList());
    }
}
