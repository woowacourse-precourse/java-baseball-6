package baseball.controller;

import baseball.view.OutputView;

public class GamePlayController {

    private final OutputView outputView = new OutputView();

    public GamePlayController() {
        outputView.printCreateController();
    }
}
