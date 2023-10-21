package baseball.gameutil;

import java.util.List;

public class ScoreCalculatorBaseBall implements ScoreCalculator {

    @Override
    public Score calScore(List<Integer> userInput, List<Integer> computerInput) {
        return Score.fromNumber(
            calStrike(userInput, computerInput),
            calBall(userInput, computerInput)
        );
    }

    private Integer calStrike(List<Integer> userInput, List<Integer> computerInput) {

    }

    private Integer calBall(List<Integer> userInput, List<Integer> computerInput) {
        return null;
    }
}
