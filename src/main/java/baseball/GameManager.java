package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    NumberArray numForUser;
    Computer computer;

    void Start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if ("1".equals(readMenu())) {
                game();
            } else {
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
            ball.setBallNum(0);
            strike.setNum(0);
            System.out.print("숫자를 입력해주세요 : ");
            numForUser = new NumberArray(Console.readLine());
            computer.check(numForUser.getNumList());
            if (ball.getBallNum() == 0 && strike.getNum() == 0) {
                System.out.println("낫싱");
            }
            if (printBall(ball.getBallNum()) > 0 && strike.getNum() > 0) {
                System.out.print(" ");
            }
            printStrike(strike.getNum());
            System.out.println();
            if (strike.getNum() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    void printStrike(int num) {
        if (num > 0) {
            System.out.print(num + "스트라이크");
        }
    }

    int printBall(int num) {
        if (num > 0) {
            System.out.print(num + "볼");
        }
        return num;
    }


}
