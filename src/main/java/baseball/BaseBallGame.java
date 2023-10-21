package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private User user;
    private Computer computer;
    private int strike;
    private int ball;

    public BaseBallGame(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void start() {
        computer.createRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            user.input();
            check();
            print();
            if (strike == 3 && !restart()) {
                break;
            }
            strike = 0;
            ball = 0;
            user.getNumbers().clear();
        }
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (Console.readLine().equals("1")) {
            computer.getNumbers().clear();
            computer.createRandomNumber();
            return true;
        }
        return false;
    }

    private void check() {
        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                strike++;
            } else if (userNumbers.contains(computerNumbers.get(i))) {
                ball++;
            }
        }
    }

    private void print() {
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
