package baseball;

import baseball.domain.Opponent;
import baseball.view.InputView;

public class BaseBallGame {

    private Opponent opponent;


    public void run() {
        start();
    }

    private void start() {
        InputView.printStart();
        opponent = Opponent.create();
    }
}
