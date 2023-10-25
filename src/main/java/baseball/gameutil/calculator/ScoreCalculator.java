package baseball.gameutil.calculator;

import baseball.gameutil.Score;
import java.util.List;

/**
 * 이 인터페이스를 구현하면 입력값을 검증할 수 있다.
 */
public interface ScoreCalculator {

    Score calScore(List<Integer> userInput, List<Integer> computerInput);
}
