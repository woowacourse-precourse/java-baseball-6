package baseball;

import static baseball.Application.NUMBER_LENGTH;

import balls.Balls;

public class BaseballGameService {
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
        int ballCount = 0;
        for (int i = 0; i < computerBalls.getBallsSize(); i++) {
            if (isBall(i, computerBalls, userBalls)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public boolean isBall(int digit, Balls computerBalls, Balls userBalls) {
        return computerBalls.compareToByBall(userBalls, digit);
    }

    public int countStrike(Balls computerBalls, Balls userBalls) {
        int strike = 0;
        for (int i = 0; i < computerBalls.getBallsSize(); i++) {
            if (isStrike(i, computerBalls, userBalls)) {
                strike++;
            }
        }
        return strike;
    }

    public boolean isStrike(int digit, Balls computerBalls, Balls userBalls) {
        return computerBalls.compareToByStrike(userBalls, digit);
    }

}
