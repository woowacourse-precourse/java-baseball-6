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
        int ball = gameResult.getBall();
        int strike = gameResult.getStrike();

        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }

        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        
        System.out.println();
    }
}
