package baseball;

import static baseball.Application.NUMBER_LENGTH;

import balls.Balls;
import java.util.stream.IntStream;


public class BaseballGameService {
    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

    public Balls createComputerBalls() {
        Balls computerBalls = new Balls(generateRandomNumber.generateRandomNumber());
        return computerBalls;
    }

    public boolean baseballGameServiceStart(Balls computerBalls, Balls userBalls) {
        int ball = countBall(computerBalls, userBalls);
        int strike = countStrike(computerBalls, userBalls);
        if (strike == NUMBER_LENGTH) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        if (ball > 0 && strike < 1) {
            System.out.printf("%d볼%n", ball);
            return true;
        }
        if (ball > 0 && strike > 0) {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            return true;
        }
        if (ball < 1 && strike > 0) {
            System.out.printf("%d스트라이크%n", strike);
            return true;
        }
        if (ball < 1 && strike < 1) {
            System.out.println("낫싱");
            return true;
        }
        return true;
    }

    public int countBall(Balls computerBalls, Balls userBalls) {
        return (int) IntStream.range(0, computerBalls.getBallsSize())
                .filter(i -> isBall(i, computerBalls, userBalls))
                .count();
    }

    public boolean isBall(int digit, Balls computerBalls, Balls userBalls) {
        return IntStream.range(0, computerBalls.getBallsSize())
                .filter(index -> digit != index)
                .anyMatch(index -> computerBalls.compareByDigit(digit, userBalls.getBall(index)));
    }

    public int countStrike(Balls computerBalls, Balls userBalls) {
        return (int) IntStream.range(0, computerBalls.getBallsSize())
                .filter(i -> isStrike(i, computerBalls, userBalls))
                .count();
    }

    public boolean isStrike(int digit, Balls computerBalls, Balls userBalls) {
        return computerBalls.compareByDigit(digit, userBalls.getBall(digit));
    }

}
