package baseball;

public class Application {
    public static void main(String[] args) {

        BaseballGameUI baseBallGameUI = new BaseballGameUI();
        baseBallGameUI.startMessage();
        try {
            baseBallGameUI.startGame();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
