package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public static final String RESTART = "1";
    public static final String END_GAME = "2";

    private static final Computer baseballComputer = new Computer();

    public static void startGame() {
        OutputView.printGameStart();
        do {
            baseballComputer.generateNumber();
            startUserTurn();
        } while (true);
    }

    private static void startUserTurn() {
        GameResult gameResult;
        do {
            baseballComputer.addUserNumber(InputView.inputUserNumber());
            gameResult = baseballComputer.createResult();
            OutputView.printGameResult(GameResultMessageGenerator.createGameResultMessage(gameResult));
        } while (!gameResult.isWin());
    }
}
