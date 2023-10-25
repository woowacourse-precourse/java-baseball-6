package baseball.game;

import java.util.List;

public interface BaseballGame {
    void init() throws IllegalArgumentException;

    List<Integer> getAnswer();
}
