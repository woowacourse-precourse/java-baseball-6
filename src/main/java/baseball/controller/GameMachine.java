package baseball.controller;

import baseball.domain.BaseballReferee;
import baseball.domain.ComputerNumber;
import baseball.view.InputView;

import java.util.List;

public class GameMachine {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private final InputView inputView;
    private final BaseballReferee baseballReferee;

    public GameMachine() {
        inputView = new InputView();
        baseballReferee = new BaseballReferee();
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);

        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer> randomNumber = computerNumber.getComputer();

        while (true) {
            List<Integer> inputNumber = inputView.inputNumber();

            System.out.println(baseballReferee.referee(randomNumber, inputNumber));
            
            if (randomNumber.equals(inputNumber)) {
                break;
            }
        }

        restart();
    }

    private void restart() {
        if (inputView.restartCheck()) {
            start();
        }
    }

}
