package baseball;

import baseball.Global.Ball;
import baseball.Global.Strike;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private NumberArray numForUser;
    private Computer computer;

    void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (!"1".equals(readMenu())) {
                break;
            }
        }
    }

    String readMenu() {
        String data = Console.readLine();
        if (!(data.length() == 1 && ("1".equals(data) || "2".equals(data)))) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return data;
    }

    void game() {
        computer = new Computer();
        Ball ball = Ball.getInstance();
        Strike strike = Strike.getInstance();
        while (true) {
            initialize(ball, strike);
            computer.check(numForUser.getNumList()); // to check the number of ball and the number of strike
            if ("break".equals(print(ball, strike))) {
                break;
            }
        }
    }

    void initialize(Ball ball, Strike strike) {
        ball.setBallNum(0);
        strike.setNum(0);
        System.out.print("숫자를 입력해주세요 : ");
        numForUser = new NumberArray(Console.readLine());
    }

    void printStrike(int num) {
        if (num > 0) {
            System.out.print(num + "스트라이크");
        }
        System.out.println();
    }

    void printBall(int numBall, int numStrike) {
        if (numBall > 0) {
            System.out.print(numBall + "볼");
        }
        if (numBall > 0 && numStrike > 0) {
            System.out.print(" ");
        }
    }

    String print(Ball ball, Strike strike) {
        if (ball.getBallNum() == 0 && strike.getNum() == 0) {
            System.out.println("낫싱");
            return "continue";
        }
        printBall(ball.getBallNum(), strike.getNum());
        printStrike(strike.getNum());
        if (strike.getNum() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return "break";
        }
        return "continue";
    }
}
