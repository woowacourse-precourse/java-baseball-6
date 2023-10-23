package baseball.domain;

import baseball.dto.Score;

import java.util.List;

public class Computer {
    private List<Integer> number;

    public Computer(List<Integer> number) {
        this.number = number;
    }

    public Score getScore(List<Integer> userNum) {
        int ball = calculateBall(userNum);
        int strike = calculateStrike(userNum);
        return Score.getInstance(ball - strike, strike);
    }

    private int calculateBall(List<Integer> userNum) {
        int ball = 0;
        for (Integer num : userNum) {
            if (number.contains(num)) {
                ball++;
            }
        }
        return ball;
    }

    private int calculateStrike(List<Integer> userNum) {
        int strike = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (number.get(i) == userNum.get(i)) {
                strike++;
            }
        }
        return strike;
    }
}
