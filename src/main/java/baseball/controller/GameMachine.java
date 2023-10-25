package baseball.controller;

import baseball.domain.BaseballReferee;
import baseball.domain.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballReferee baseballReferee;

    public GameMachine() {
        inputView = new InputView();
        outputView = new OutputView();
        baseballReferee = new BaseballReferee();
    }

    public void start() {
        outputView.gameStartMessage();

        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer> randomNumber = computerNumber.getComputer();

        while (true) {
            outputView.inputNumberMessage();
            List<Integer> inputNumber = inputView.inputNumber();

            outputView.refereeMessage(baseballReferee.referee(randomNumber, inputNumber));

            if (randomNumber.equals(inputNumber)) {
                break;
            }
        }

        restart();
    }

    private void restart() {
        outputView.gameRestartMessage();
        if (inputView.restartCheck()) {
            start();
        }
    }

}
