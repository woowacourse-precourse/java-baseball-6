package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer = new Computer();
    private final Balls userBalls = new Balls();

    public void createComputerBalls() {
        computer.createRandomBalls();
    }

    public void inputUserBalls() {
        String balls = Console.readLine();
        userBalls.convertToBalls(balls);
    }

    public int countContainedBalls() {
        return computer.countContainedBalls(userBalls);
    }

    public int countStrike() {
        return computer.countContainedBallsAsIndex(userBalls);
    }

    public boolean isThreeStrike(int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        return false;
    }

    public boolean isNothing(int ball) {
        if (ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        return false;
    }

    public void outputResult(int ball, int strike) {
        if (ball == 0) {
            System.out.println(strike+"스트라이크");
        }
        if (strike == 0) {
            System.out.println(ball+"볼");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public void outputGameSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void outputRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int inputRestartNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
