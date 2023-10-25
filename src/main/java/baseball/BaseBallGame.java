package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private boolean end;
    private int strike, ball;
    private List<Integer> computer = new ArrayList<>();

    private void init() {
        this.end = false;
        this.computer = new ArrayList<>();
        Util.getRandomNumber(this.computer);
    }

    private void check(int computerItem, int userItem, int comIdx, int userIdx) {
        if (computerItem == userItem) {
            if (comIdx == userIdx) {
                this.strike++;
            } else {
                this.ball++;
            }
        }
    }

    private void count(List<Integer> num) {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int computerItem = this.computer.get(i);
                int userItem = num.get(j);
                check(computerItem, userItem, i, j);
            }
        }
    }

    private void print() {
        if (this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (this.strike > 0 && this.ball > 0) {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
            return;
        }
        if (this.ball > 0) {
            System.out.println(this.ball + "볼");
            return;
        }
        if (this.strike > 0) {
            System.out.println(this.strike + "스트라이크");
        }
        if (this.strike == 3) {
            this.end = true;
        }
    }

    private void play() {
        do {
            List<Integer> num = Util.getNumber();
            count(num);
            print();
        } while (!this.end);
    }

    public void start() {
        init();
        play();
        end();
    }

    public void end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
