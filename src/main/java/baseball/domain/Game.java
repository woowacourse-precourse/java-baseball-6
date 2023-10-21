package baseball.domain;

import java.util.ArrayList;

public class Game {
    int ballCount;
    int strikeCount;

    int[] randomNumber;

    public void setRandomNumber(int[] randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int[] getRandomNumber() {
        return this.randomNumber;
    }


    public void setCountZero() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addBallCount() {
        this.ballCount += 1;
    }

    public void addStrikeCount() {
        this.strikeCount += 1;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
