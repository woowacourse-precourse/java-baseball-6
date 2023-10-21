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

public class GameSetupService {

    public Game gameCreate() {
        return new Game(generateComputerBalls());
    }

    public Balls generatePlayerBalls(String playerGuess) {
        return new Balls(createPlayerBalls(playerGuess));
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

    private List<Ball> createPlayerBalls(String playerGuess) {
        return playerGuess.chars()
                .mapToObj(ballNumber -> new Ball(Character.getNumericValue(ballNumber)))
                .collect(Collectors.toList());
    }
}
