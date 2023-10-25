package baseball.domain;

public class Referee {

    private final int NUMBERS_LENGTH = 3;

    private final Numbers answerNumbers;

    public Referee(Numbers randomNumbers) {
        this.answerNumbers = randomNumbers;
    }

    public int countStrike(Numbers playerNumbers) {
        int position = 0;
        int strike = 0;
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (answerNumbers.isSamePosition(playerNumbers, position)) {
                strike++;
            }
            position++;
        }
        return strike;
    }

    public int countBall(Numbers playerNumbers) {
        int position = 0;
        int ball = 0;
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            if (answerNumbers.isSameNumber(playerNumbers, position)) {
                ball++;
            }
            position++;
        }
        return ball;
    }
}
