package baseball.gameutil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreCalculatorBaseBall implements ScoreCalculator {

    @Override
    public Score calScore(List<Integer> userInput, List<Integer> computerInput) {
        return new Score(
            calBall(userInput, computerInput),
            calStrike(userInput, computerInput)
        );
    }

    private Integer calStrike(List<Integer> userInput, List<Integer> computerInput) {
        // assert userInput.size() == computerInput.size();
        int count = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == computerInput.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    private Integer calBall(List<Integer> userInput, List<Integer> computerInput) {
        // assert userInput.size() == computerInput.size();
        Set<Integer> computerInputSet = new HashSet<>(computerInput);
        int count = 0;
        for (int i = 0; i < userInput.size(); i++) {
            Integer targetNumber = userInput.get(i);
            if (targetNumber != computerInput.get(i) && computerInputSet.contains(targetNumber)) {
                count += 1;
            }
        }
        return count;
    }
}
