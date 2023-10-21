package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printStartMsg();
        for(int i=0; i<3; i++) {
            inputView.enterNumbers();
        }
    }
}
