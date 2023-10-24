package baseball.domain;

import baseball.view.InputView;

public class GameHost {
    public boolean checkGameContinue(boolean allStrike) {
        if(allStrike) {
            InputView inputView = new InputView();
            return inputView.askGameEnd();
        }else {
            return false;
        }
    }
}
