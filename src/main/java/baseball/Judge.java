package baseball;

import static baseball.Constant.BALL_MESSAGE;
import static baseball.Constant.NOTHING_MESSAGE;
import static baseball.Constant.STRIKE_MESSAGE;

import java.util.List;

public class Judge {
    private int strike = 0;
    private int ball = 0;
    List<Integer> answer;
    List<Integer> guess;

    public Judge(List<Integer> answer, List<Integer> guess) {
        this.answer = answer;
        this.guess = guess;
    }

    public void calcResult() {
        for (int i = 0; i < guess.size(); i++) {
            if (answer.contains(guess.get(i))) {
                if (answer.get(i).equals(guess.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
    }

    public void printResult() {
        if(strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
        }
        else if(strike == 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
        else if(ball == 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
        else {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
        }
    }

    public boolean isCorrect() {
        return strike == 3;
    }
}
