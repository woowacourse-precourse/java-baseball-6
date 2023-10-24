package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Integer> programNumbers;
    private Set<String> inputSet;
    private int strikeCount;
    private int ballCount;

    public Game(List<Integer> programNumbers) {
        this.programNumbers = programNumbers;
        this.inputSet = new HashSet<>();
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

    public boolean checkDuplicatedInput(String input) {
        if(inputSet.contains(input)) return true;

        inputSet.add(input);
        return false;
    }

    public void end() {
        this.programNumbers = null;
        this.inputSet = null;
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
