package baseball.views;

import baseball.constants.MessageConstants;

public class GameView {
    private static GameView gameView = new GameView();

    private GameView() {
    }

    public static GameView getInstance() {
        return gameView;
    }

    public void start() {
        System.out.println(MessageConstants.GAME_START);
    }

    public void end() {
        System.out.println(MessageConstants.END_GAME);
    }

    public void requestNumbersInput() {
        System.out.print(MessageConstants.REQUEST_NUMBERS_INPUT);
    }

    public void requestRestartInput() {
        System.out.println(MessageConstants.REQUEST_RESTART_INPUT);
    }

    public void gameResult() {
        System.out.println(MessageConstants.RESULT_DEFAULT);
    }

    public void gameResult(String result) {
        System.out.println(result);
    }
}
