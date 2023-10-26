package baseball.service;

import java.util.List;

public interface GameManageInterface {
    void init();

    List<Integer> selectComputerNumber();

    Integer judgeNumber(List<Integer> playerNumber, List<Integer> computerNumber);

    Integer printResultNumber(int strikeCount, int ballCount);

    void play();

    boolean isPlayAgain();

}
