package baseball.controller;

import baseball.model.Balls;
import baseball.model.PlayResult;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private OutputView outputView;
    private InputView inputView;
    private Balls com;
    private PlayResult result;

    public void start() {
        init();
        outputView.printGameStart();

        while (result.isContinue()) {
            Balls user = new Balls(inputView.readBallNumbers());
        }
    }

    private void init() {
        outputView = new OutputView();
        inputView = new InputView();
        com = new Balls(RandomNumberGenerator.createRandomNumbers());
        result = new PlayResult();
    }
}
