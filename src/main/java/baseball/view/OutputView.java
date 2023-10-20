package baseball.view;

import static baseball.view.Messages.BALL;
import static baseball.view.Messages.GAME_CLEAR_MESSAGE;
import static baseball.view.Messages.INPUT_NUMBER_MESSAGE;
import static baseball.view.Messages.INPUT_OPTION_MESSAGE;
import static baseball.view.Messages.NOTHING;
import static baseball.view.Messages.START_GAME_MESSAGE;
import static baseball.view.Messages.STRIKE;

import baseball.domain.result.Result;

public class OutputView {

    public void showStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void showInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void showOptionMenu() {
        System.out.println(GAME_CLEAR_MESSAGE);
        System.out.println(INPUT_OPTION_MESSAGE);
    }

    public void showResult(Result result) {
        showBall(result);
        if (result.getBall() > 0 && result.getStrike() > 0) {
            System.out.print(" ");
        }
        showStrike(result);
        showNothing(result);
        System.out.println();
    }

    private void showBall(Result result) {
        if (result.getStrike() > 0) {
            System.out.print(result.getBall() + BALL + " ");
        }
    }

    private void showStrike(Result result) {
        if (result.getBall() > 0) {
            System.out.print(result.getStrike() + STRIKE + " ");
        }
    }

    private void showNothing(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.print(NOTHING);
        }
    }
}
