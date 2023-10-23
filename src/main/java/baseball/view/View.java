package baseball.view;

import baseball.model.Result;

public interface View {
    void showStartGame();

    String inputUserNumber();

    void showGameResult(Result result);

    void showEnd();

    String inputGameRestart();
}
