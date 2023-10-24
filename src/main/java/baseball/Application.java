package baseball;

import baseball.constant.GameStatus;
import baseball.controller.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStatus gameStatus;
        OUTPUT_VIEW.printGameStart();
        do {
            new Game().play(INPUT_VIEW.inputNumbers());
            gameStatus = GameStatus.apply(INPUT_VIEW.inputRestartOrNot());
        }
        while (gameStatus != GameStatus.QUIT);
    }
}
