package baseball.view;

public interface View {
    void showStartGame();

    String inputUserNumber();

    void showGameResult(String result);

    void showEnd();

    String inputGameRestart();
}
