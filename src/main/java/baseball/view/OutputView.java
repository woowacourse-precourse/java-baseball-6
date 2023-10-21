package baseball.view;

import baseball.domain.Score;

public interface OutputView {
    void startGame();

    void endGame();

    void matchResult(Score score);
}
