package baseball;

public class Application {
    public static void main(String[] args) {
        GameUtil gameUtil = new GameUtil();
        gameUtil.settingGame();

        boolean isContinue = true;
        while (isContinue) {
            gameUtil.receiveUserInput();

            if (gameUtil.compareUserInputWithAnswer()) {
                if (!gameUtil.checkIsContinue()) isContinue = false;
                else {
                    gameUtil.settingGame();
                }
            }
        }
    }
}
