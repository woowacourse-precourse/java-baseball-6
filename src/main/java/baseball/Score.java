package baseball;

import java.util.List;

public class Score {
    int strike;
    int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public int countStrike(List<Integer> computer, List<Integer> human) {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (computer.get(i) == human.get(i)) {
                strike ++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computer, List<Integer> human) {
        int ball = 0;
        for (int i=0; i<3; i++) {
            if (computer.get(i) != human.get(i) && computer.contains(human.get(i))) {
                ball ++;
            }
        }
        return ball;
    }

    public void getResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
