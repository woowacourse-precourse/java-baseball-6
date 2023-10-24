package baseball;

import java.util.List;

public interface Game {
    void gameStart();
    void gamePlay();
    void gameEnd();

    List<Integer> makeAnswer();
}
