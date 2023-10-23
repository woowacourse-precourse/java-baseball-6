package baseball.game;

import java.util.List;
import java.util.Objects;

import static constant.Constant.ZERO;

public class InningResult {
    private int numberOfBalls;
    private int numberOfStrikes;

    public InningResult() {
        this.numberOfBalls = 0;
        this.numberOfStrikes = 0;
    }


    public void increaseBall() {
        numberOfBalls++;
    }

    public void increaseStrike() {
        numberOfStrikes++;
    }

    public boolean noMatchesExists() {
        return this.numberOfBalls == ZERO && this.numberOfStrikes == ZERO;
    }

    public boolean hasBalls() {
        return this.numberOfBalls > ZERO;
    }

    public boolean hasStrikes() {
        return this.numberOfStrikes > ZERO;
    }

    public String getBallMessage() {
        return this.numberOfBalls + "볼 ";
    }

    public String getStrikeMessage() {
        return this.numberOfStrikes + "스트라이크";
    }

    public boolean isThreeStrikes() {
        return this.numberOfStrikes == 3;
    }

    protected static InningResult countMatchesBetween(List<Integer> first, List<Integer> second) {
        InningResult result = new InningResult();
        for (int i = 0; i < first.size(); i++) {
            if (second.contains(first.get(i))) {
                if (Objects.equals(first.get(i), second.get(i))) {
                    result.increaseStrike();
                } else {
                    result.increaseBall();
                }
            }
        }
        return result;
    }

}