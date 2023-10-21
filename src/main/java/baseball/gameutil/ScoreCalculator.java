package baseball.gameutil;

import java.util.List;

public interface ScoreCalculator {

    Score calScore(List<Integer> userInput, List<Integer> computerInput);
}
