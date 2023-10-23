package baseball.view;

import baseball.model.GameResult;

public interface OutputView {
    void gameStart();

    void requestNumber();

    void showGameResult(GameResult gameResult);

    void goodGame(final int targetSize);

    void areYouWantMoreGame(final String moreValue, final String stopValue);
}
