package baseball.gameManage;

import java.util.List;

public interface gameManageInterface {
    void init();

    List<Integer> selectComputerNumber();

    Integer judgeNumber(List<Integer> playerNumber, List<Integer> computerNumber);

    Integer PrintNumber(int strikeCount, int ballCount);

    void play();

    void playAgain();

}
