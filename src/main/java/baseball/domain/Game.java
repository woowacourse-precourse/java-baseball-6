package baseball.domain;

import java.util.List;

public class Game {
    private List<Integer> randomNumbers;
    private int[] comparisonResult;
    private Game(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public static Game numberOf(List<Integer> randomNumbers) {
        return new Game(randomNumbers);
    }

    public void compareNumber(List<Integer> inputNumbers) {
        comparisonResult = new int[]{0, 0};
        for(int currentPosition = 0; currentPosition < randomNumbers.size(); currentPosition++) {
            compareInputNumber(currentPosition, inputNumbers);
        }
    }

    private void compareInputNumber(int currentPosition, List<Integer> inputNumbers) {
        if(randomNumbers.get(currentPosition) == inputNumbers.get(currentPosition)) {
            comparisonResult[1]++;
            return;
        }
        if(randomNumbers.contains(inputNumbers.get(currentPosition))) {
            comparisonResult[0]++;
        }
    }

    public boolean isThreeStrike() {
        return comparisonResult[1] == 3;
    }

    public boolean isOnlyStrike() {
        return comparisonResult[0] == 0 && comparisonResult[1] != 0;
    }

    public boolean isOnlyBall() {
        return comparisonResult[0] != 0 && comparisonResult[1] == 0;
    }

    public boolean isNothing() {
        return comparisonResult[0] == 0 && comparisonResult[1] == 0;
    }

    public int getBallNumber() {
        return comparisonResult[0];
    }

    public int getStrikeNumber() {
        return comparisonResult[1];
    }
}
