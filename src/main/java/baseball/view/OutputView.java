package baseball.view;

import baseball.domain.result.Result;

public class OutputView {

    public void showStartMessage() {
        System.out.println(Messages.START_GAME_MESSAGE);
    }

    public void showInputNumberMessage() {
        System.out.print(Messages.INPUT_NUMBER_MESSAGE);
    }

    public void showOptionMenu() {
        System.out.println(Messages.GAME_CLEAR_MESSAGE);
        System.out.println(Messages.INPUT_OPTION_MESSAGE);
    }

    public void showResult(Result result) {
        showBall(result);
        if (result.ball() > 0 && result.strike() > 0) {
            System.out.print(" ");
        }
        showStrike(result);
        showNothing(result);
        System.out.println();
    }

    private void showBall(Result result) {
        if (result.ball() > 0) {
            System.out.print(result.ball() + Messages.BALL);
        }
    }

    private void showStrike(Result result) {
        if (result.strike() > 0) {
            System.out.print(result.strike() + Messages.STRIKE);
        }
    }

    private void showNothing(Result result) {
        if (result.strike() == 0 && result.ball() == 0) {
            System.out.print(Messages.NOTHING);
        }
    }
}
