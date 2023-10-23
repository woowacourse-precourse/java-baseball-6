package baseball.gameutil.calculator;

import baseball.gameutil.Score;
import java.util.List;

public interface ScoreCalculator {

    Score calScore(List<Integer> userInput, List<Integer> computerInput);
}
