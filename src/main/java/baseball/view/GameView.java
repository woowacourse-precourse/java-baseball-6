package baseball.view;

import baseball.model.Game;

public interface GameView {
    void showInputRequiredMessage();

    void showResultOf(Game game);

    void showToBeContinueMessage();

    void showQuitGameMessage();
}
