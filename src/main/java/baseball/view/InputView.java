package baseball.view;

import java.util.List;

public interface InputView {
    List<Integer> getPlayerNumbers();

    String moreGameValue();

    String stopGameValue();

    boolean isWantStopGame();
}
