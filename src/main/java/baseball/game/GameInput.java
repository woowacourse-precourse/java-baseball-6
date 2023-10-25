package baseball.game;

import java.util.List;

public interface GameInput {
    String setInput();

    List<Integer> getIntegerInput(String input);

    String getReplayOrOverInput(String input);

    void close();
}
