package baseball.model;

import java.util.List;

public class baseballCount {
    private int strikeCount;
    private int ballCount;

    private baseballCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void addBallCount() {
        ballCount++;
    }

    public int countStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        for(int idx = 0; idx < userNumberList.size(); idx++) {
            if(computerNumberList.get(idx).equals(userNumberList.get(idx))) {
                addStrikeCount();
            }
        }

        return getStrikeCount();
    }
}
