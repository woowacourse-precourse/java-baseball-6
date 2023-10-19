package baseball.Game;

import java.util.List;

public interface BaseBallGame {

    void initGame();

    void playGame();

    List<Integer> makeRandomNumber();

    Integer countStrike(List<Integer> answer);

    Integer countBall(List<Integer> answer);

    void printResult(Integer strike, Integer ball);

}
