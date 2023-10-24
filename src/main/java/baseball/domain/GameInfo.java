package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {

    private List<Integer> computerNum = new ArrayList<>();
    private int strikeCount;
    private int ballCount;
    private String input;
    private boolean replay;

    public GameInfo(List<Integer> computerNum) {
        this.computerNum = computerNum;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }

    public boolean isReplay() {
        return replay;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }
}
