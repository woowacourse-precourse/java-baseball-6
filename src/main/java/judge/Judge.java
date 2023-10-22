package judge;

import baseball.Number;

public class Judge {

    private Number computerNumber;

    public void initialize(Number computerNumber) {
        this.computerNumber = computerNumber;
    }

    public JudgeResult resultFrom(Number userNumber) {
        return JudgeResult.of(countBall(userNumber), countStrike(userNumber));
    }

    private int countBall(Number userNumber) {
        int ball = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            for (int j = 0; j < userNumber.length(); j++) {
                if (i != j && computerNumber.get(i) == userNumber.get(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private int countStrike(Number userNumber) {
        int strike = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }
}
