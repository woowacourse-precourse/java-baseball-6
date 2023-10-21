package baseball;

import baseball.controller.Controller;
import baseball.domain.Computer;
import baseball.domain.GuessNumber;
import baseball.domain.State;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Controller controller = new Controller(new Computer(), new GuessNumber(), new InputView(outputView), outputView,
                new State());
        controller.start();
    }
}
