package baseball;

import java.util.List;

public interface gameManageInterface {
    void init();

    List<Integer> selectComputerNumber();

    void selectPlayerNumber(playerEntity playerEntity);

    List<Integer> stringToIntArray(String playerNumber);

    resultCompareNumber judgeNumber(List<Integer> playerNumber, List<Integer> computerNumber);

    resultCompareNumber PrintNumber(int strikeCount, int ballCount);

    void play();

    void playAgain();

}
