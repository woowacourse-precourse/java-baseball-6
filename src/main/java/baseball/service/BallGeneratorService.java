package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        return IntStream.range(0, playerGuess.length())
                .mapToObj(index -> new Ball(playerGuess.charAt(index) - '0'))
                .collect(Collectors.toList());
    }
}
