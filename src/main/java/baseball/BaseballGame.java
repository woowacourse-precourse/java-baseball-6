package baseball;

import java.util.Objects;

public class BaseballGame {

    Computer computer = new Computer();
    User user = new User();

    Integer judgeStrike() {
        int strike = 0;
        for (Integer item : user.numbers) {
            if (Objects.equals(item, computer.numbers.get(user.numbers.indexOf(item)))) {
                strike++;
            }
        }
        return strike;
    }

    Integer judgeBall() {
        int ball = 0;
        for (Integer item : user.numbers) {
            for (int i = 0; i < 3; i++) {
                if (i != user.numbers.indexOf(item) && Objects.equals(item, computer.numbers.get(i))) {
                    ball++;
                }
            }
        }
        return ball;
    }

    void printJudgement(int strike, int ball) {
        if (ball > 0 || strike > 0) {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public void play() {
        this.computer.selectNumber();

        boolean correct = false;
        while (!correct) {
            System.out.print("숫자를 입력해주세요 : ");
            this.user.selectNumber();

            Integer strike = this.judgeStrike();
            Integer ball = this.judgeBall();

            this.printJudgement(strike, ball);

            correct = strike == 3;

            if (correct) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
}
