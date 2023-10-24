package baseball.game;

import static constant.Constant.ZERO;

import java.util.List;
import java.util.Objects;


public class InningResult {
    private int numberOfBalls;
    private int numberOfStrikes;

    private InningResult() {
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

    protected static InningResult countMatchesBetween(List<Integer> userInputNumbers, List<Integer> generatedNumbers) {
        InningResult result = new InningResult();
        for (int i = 0; i < userInputNumbers.size(); i++) {
            if (generatedNumbers.contains(userInputNumbers.get(i))) {
                if (Objects.equals(userInputNumbers.get(i), generatedNumbers.get(i))) {
                    result.increaseStrike();
                } else {
                    result.increaseBall();
                }
            }
        }
        return result;
    }
}