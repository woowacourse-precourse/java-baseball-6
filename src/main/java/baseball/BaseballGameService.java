package baseball;

import static baseball.Application.NUMBER_LENGTH;

import balls.Balls;


public class BaseballGameService {
    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

    public Balls createComputerBalls() {
        Balls computerBalls = new Balls(generateRandomNumber.generateRandomNumber());
        return computerBalls;
    }

    public boolean baseballGameServiceStart(Balls computerBalls, Balls userBalls) {
        int ball = computerBalls.countBall(userBalls);
        int strike = computerBalls.countStrike(userBalls);
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

}
