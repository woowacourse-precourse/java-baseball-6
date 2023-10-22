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
        if (result.getBall() > 0 && result.getStrike() > 0) {
            System.out.print(" ");
        }
        showStrike(result);
        showNothing(result);
        System.out.println();
    }

    public void showEndMessage() {
        System.out.println(Messages.GAME_END_MESSAGE);
    }

    private void showBall(Result result) {
        if (result.getBall() > 0) {
            System.out.print(result.getBall() + Messages.BALL);
        }
    }

    private void showStrike(Result result) {
        if (result.getStrike() > 0) {
            System.out.print(result.getStrike() + Messages.STRIKE);
        }
    }

    private void showNothing(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.print(Messages.NOTHING);
        }
    }
}
