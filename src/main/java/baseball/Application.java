package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 리팩토링(계속)

        BaseBallGameUI baseBallGameUI = new BaseBallGameUI();
        baseBallGameUI.startMessage();
        try {
            baseBallGameUI.startGame();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
