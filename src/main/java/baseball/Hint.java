package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    public int getStrike() {
        return strike;
    }

    public int strike;
    public int ball;
    private List<Integer> userAnswer;
    private List<Integer> computerAnswer;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void initHint() {
        this.strike = 0;
        this.ball = 0;
    }


    public void calculateHint(List<Integer> userAnswer, List<Integer> computerAnswer) {
        initHint();
        this.userAnswer = new ArrayList<Integer>(userAnswer);
        this.computerAnswer = new ArrayList<Integer>(computerAnswer);
        countStrike();
        countBall();
    }

    public void printHint() {
        if (this.ball > 0) {
            System.out.print(this.ball + "볼 ");
        }
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크 ");
        }
        if (this.strike == 0 && this.ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private void countStrike() {
        for (int i = 0; i < this.userAnswer.size(); i++) {
            if (userAnswer.get(i).equals(computerAnswer.get(i))) {
                userAnswer.remove(i);
                computerAnswer.remove(i);
                strike++;
                i--;
            }
        }
    }

    private void countBall() {

        for (int i = 0; i < this.userAnswer.size(); i++) {
            Integer userNumber = this.userAnswer.get(i);
            if (computerAnswer.contains(userNumber)) {
                ball++;
            }
        }
    }


}
