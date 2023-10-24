package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballNumberGenerator;
import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        Computer computer = new Computer(baseballNumberGenerator);
        BaseballController baseballController = new BaseballController(inputView,outputView,computer,baseballNumberGenerator);
        baseballController.start();
    }
}
