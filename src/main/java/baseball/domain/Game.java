package baseball.domain;

public class Game {
    int strike;
    int ball;
    int[] randomNumbers;

    public void intiField() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }


    public int getBall() {
        return ball;
    }


    public int[] getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void strikeCount() {
        strike++;
    }

    public void ballCount() {
        ball++;
    }
}
