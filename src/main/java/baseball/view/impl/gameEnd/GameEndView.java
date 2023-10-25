package baseball.view.impl.gameEnd;

import baseball.common.GameStatus;

public class GameEndView {
    private final ContinueOrExitInputView continueOrExitInputView = new ContinueOrExitInputView();
    private final ContinueOrExitOutputView continueOrExitOutputView = new ContinueOrExitOutputView();
    private final GameEndOutputView gameEndOutputView = new GameEndOutputView();

    public GameStatus afterGameEnd() {
        continueOrExitOutputView.show(null);
        String input = continueOrExitInputView.getInput();

        return GameStatus.fromValue(input);
    }

    public void exit() {
        gameEndOutputView.show(null);
    }
}
