package baseball.view;

import baseball.domain.GameResult;

import static baseball.util.MessageConst.*;

public class OutputView {
    public void printGameStartMsg() {
        System.out.println(GAME_START_MSG);
    }

    public void inputNumberMsg() {
        System.out.print(INPUT_NUMBER_MSG);
    }

    public void printGameResult(GameResult gameResult) {
        String resultString = gameResult.createResultString();
        System.out.println(resultString);
    }

    public void printGameOverMsg() {
        System.out.println(GAME_OVER_MSG);
        System.out.println(RESTART_OR_NOT_MSG);
    }
}
