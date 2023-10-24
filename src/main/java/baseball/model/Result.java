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
        for (Integer inputNumber : inputNumbers) {
            if (computerNumbers.contains(inputNumber) && !inputNumber.equals(computerNumbers.get(inputNumbers.indexOf(inputNumber))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}