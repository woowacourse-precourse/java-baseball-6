package baseball.view;

import baseball.domain.GameResult;
import baseball.util.Sentence;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println(Sentence.GAME_START_MESSAGE.getMessage());
    }

    public void printInputNumbersMessage() {
        System.out.print(Sentence.INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printGameSuccessMessage() {
        System.out.println(Sentence.GAME_SUCCESS_MESSAGE.getMessage());
    }

    public void printGameActionMessage() {
        System.out.println(Sentence.GAME_RESTART_EXIT_MESSAGE.getMessage());
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println(gameResult);
    }
}
