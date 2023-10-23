package baseball.controller;

import baseball.service.ComputerService;
import baseball.view.OutputView;

public class GameController {
    OutputView output = new OutputView();
    ComputerService computerService = new ComputerService();

    public void run() {
        output.printStartMessage();
    }
}
