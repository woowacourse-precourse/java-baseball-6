package baseball.ProcessGame;

import java.util.List;

public interface BaseBallGame {

    void initGame();

    void playGame();

    List<Integer> makeRandomNumber();

    Integer countStrike(List<Integer> answer);

    Integer countBall(List<Integer> answer);

    Boolean gameResult(Integer strike, Integer ball);

}
