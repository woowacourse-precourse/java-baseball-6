package baseball.gameutil.calculator;

import baseball.gameutil.Score;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 이 클래스는 BaseBall에서 사용할 ScoreCalculator를 구현하는 클래스이다.
 */
public class ScoreCalculatorBaseBall implements ScoreCalculator {

    /**
     * 이 메서드는 사용자의 입력값과 컴퓨터의 입력값을 비교하여 Score를 계산한다.
     * @param userInput 사용자의 입력값
     * @param computerInput 컴퓨터의 입력값
     * @return Score
     */
    @Override
    public Score calScore(List<Integer> userInput, List<Integer> computerInput) {
        return new Score(
            calBall(userInput, computerInput),
            calStrike(userInput, computerInput)
        );
    }

    private int calStrike(List<Integer> userInput, List<Integer> computerInput) {
        return (int) IntStream.range(0, userInput.size())
            .filter(idx -> userInput.get(idx) == computerInput.get(idx))
            .count();
    }

    private int calBall(List<Integer> userInput, List<Integer> computerInput) {
        Set<Integer> computerInputSet = new HashSet<>(computerInput);
        return (int) IntStream.range(0, userInput.size())
            .filter(idx -> userInput.get(idx) != computerInput.get(idx))
            .filter(idx -> computerInputSet.contains(userInput.get(idx)))
            .count();
    }
}
