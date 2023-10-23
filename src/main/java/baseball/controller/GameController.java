package baseball.controller;

import baseball.model.Balls;
import baseball.model.PlayResult;
import baseball.model.RestartOption;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Objects;

public class GameController {

    private OutputView outputView;
    private InputView inputView;
    private Balls com;
    private PlayResult result;

    private void init() {
        outputView = new OutputView();
        inputView = new InputView();
        com = new Balls(RandomNumberGenerator.createRandomNumbers());
        result = new PlayResult();
    }

    public void start() {
        init();
        outputView.printGameStart();

        while (result.isContinue()) {
            Balls user = new Balls(inputView.readBallNumbers());
            result = com.play(user);
            outputView.printResult(result);
        }
        end();
    }

    private void end() {
        outputView.printGameClear();
        RestartOption option = inputView.readRestartCommand();

        if (option.isRestart()) start();
    }
}
