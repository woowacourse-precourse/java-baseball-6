package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ComputerController computerController = new ComputerController();

    public void proceed() {
        int state = 1;
        outputView.print_start();
        while (state == 1) {
            computerController.start();

            state = isRetry(inputView.print_retry_message());
        }
    }

    private int isRetry(int num) {
        if (num == 1) {
            return num;
        }
        return 0;
    }
}
