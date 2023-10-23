package baseball.view;

import java.util.List;

public interface InputView {
    List<Integer> getPlayerNumber();

    String moreGameValue();

    String stopGameValue();

    boolean isWantStopGame();
}
