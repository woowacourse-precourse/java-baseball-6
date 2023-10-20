package baseball;

import baseball.generator.GameResultMessageGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public static final String RESTART = "1";
    public static final String END_GAME = "2";

    private static final Computer baseballComputer = new Computer();

    public static void startGame() {
        OutputView.printGameStart();
        do {
            baseballComputer.generateNumber(RandomNumberGenerator::generateRandomNumbers);
            startUserTurn();
            OutputView.printGameOver();
        } while (askRestart());
    }

    private static void startUserTurn() {
        GameResult gameResult;
        do {
            baseballComputer.addUserNumber(InputView.inputUserNumber());
            gameResult = baseballComputer.createResult();
            OutputView.printGameResult(GameResultMessageGenerator.createGameResultMessage(gameResult));
        } while (!gameResult.isWin());
    }

    private static boolean askRestart() {
        String userSelection = InputView.inputRestart();
        validateUserSelection(userSelection);
        return userSelection.equals(RESTART);
    }

    private static void validateUserSelection(final String userSelection) {
        if (!userSelection.equals(RESTART) && !userSelection.equals(END_GAME)) {
            throw new IllegalArgumentException("1(재시작) 혹은 2(종료)만 입력해야 합니다.");
        }
    }
}
