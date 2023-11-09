package baseball.Model;

import java.util.List;

public class GameResult {
    private int balls = 0;
    private int strikes = 0;

    GameResult(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        for (int i = 0; i < answerNumbers.size(); i++) {
            int answerDigit = answerNumbers.get(i);
            int inputDigit = inputNumbers.get(i);

            if (answerDigit == inputDigit) {
                this.strikes++;
            } else if (answerNumbers.contains(inputDigit)) {
                this.balls++;
            }
        }
    }

    public String resultToString() {
        String result = "";
        if (this.balls != 0) {
            result += this.balls + "볼";
        }
        if (this.strikes != 0) {
            if (this.balls != 0) {
                result += " ";
            }
            result += this.strikes + "스트라이크";
        }
        if (this.balls == 0 && this.strikes == 0) {
            result = "낫싱";
        }
        return result;
    }

    public int getStrikes() {
        return this.strikes;
    }

}