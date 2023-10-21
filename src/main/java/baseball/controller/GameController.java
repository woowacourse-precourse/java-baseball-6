package baseball.controller;

import baseball.view.InputView;

public class GameController {

    InputView inputView = new InputView();
    ComputerController computerController = new ComputerController();

    public void proceed() {
        int state = 1;
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
