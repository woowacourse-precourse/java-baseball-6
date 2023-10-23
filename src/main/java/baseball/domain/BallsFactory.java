package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallsFactory {

    public static Balls createBalls(List<Integer> ballNumbers) {
        List<Ball> balls = convertToBall(ballNumbers);
        return new Balls(balls);
    }

    public static Balls createComputerBalls() {
        List<Integer> computer = GenerateRandomNumber();
        return createBalls(computer);
    }

    private static List<Ball> convertToBall(List<Integer> ballNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballNumbers.size(); i++) {
            balls.add(new Ball(new Position(i + 1), new BallNumber(ballNumbers.get(i))));
        }
        return balls;
    }

    private static List<Integer> GenerateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}