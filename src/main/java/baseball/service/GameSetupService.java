package baseball.service;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> ballNumbers = new ArrayList<>();
        while (ballNumbers.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BALL, MAX_BALL);
            if (!ballNumbers.contains(randomNumber)) {
                ballNumbers.add(randomNumber);
            }
        }
        return ballNumbers;
    }

    private List<Ball> createComputerBalls(List<Integer> ballNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer ballNumber : ballNumbers) {
            balls.add(new Ball(ballNumber));
        }
        return balls;
    }

    private List<Ball> createPlayerBalls(String playerGuess) {
        List<Ball> balls = new ArrayList<>();
        for (char ballNumber : playerGuess.toCharArray()) {
            balls.add(new Ball(ballNumber - '0'));
        }
        return balls;
    }
}
