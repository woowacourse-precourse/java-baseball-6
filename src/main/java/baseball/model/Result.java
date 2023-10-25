package baseball.model;

import java.util.List;

public class Result {
    private List<Integer> computerNumbers;
    private List<Integer> inputNumbers;

    public Result(List<Integer> userNumbers, List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
        this.inputNumbers = userNumbers;
    }

    public int calculateStrikes() {
        int strikeCount = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(inputNumbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int calculateBalls() {
        int ballCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            if (computerNumbers.contains(inputNumbers.get(i)) && !inputNumbers.get(i).equals(computerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}