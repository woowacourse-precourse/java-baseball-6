package baseball.controller;

import baseball.model.Computer;
import baseball.util.BaseballNumberGenerator;
import baseball.util.BaseballRandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private final static Computer computer = new Computer(new BaseballRandomNumberGenerator().generate());
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    public void start(){
        outputView.printGameStartMessage();
    }


}
