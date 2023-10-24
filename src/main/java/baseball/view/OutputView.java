package baseball.view;

import baseball.domain.dto.GameResult;
import baseball.util.Sentence;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println(Sentence.GAME_START.getMessage());
    }

    public void printInputNumbersMessage() {
        System.out.print(Sentence.INPUT_NUMBER.getMessage());
    }

    public void printGameSuccessMessage() {
        System.out.println(Sentence.GAME_SUCCESS.getMessage());
    }

    public void printGameActionMessage() {
        System.out.println(Sentence.GAME_RESTART_OR_EXIT.getMessage());
    }

    public void printGameResult(GameResult gameResult) {
        int ball = gameResult.ball();
        int strike = gameResult.strike();

        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }

        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }

        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}
