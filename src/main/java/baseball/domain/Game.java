package baseball.domain;

import java.util.List;

public class Game {
    private List<Integer> programNumbers;
    private int strikeCount;
    private int ballCount;

    public Game(List<Integer> programNumbers) {
        this.programNumbers = programNumbers;
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public List<Integer> getProgramNumbers() {
        return this.programNumbers;
    }

    public void increaseStrikeCount() {
        this.strikeCount++;
    }

    public void increaseBallCount() {
        this.ballCount++;
    }

    public void resetCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
