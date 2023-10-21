package Controller;

import Model.Computer;
import Model.User;
import Util.NumberCompare;
import View.InputView;
import View.OutputView;
import View.RetryView;
import java.util.Map;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    private final RetryView retryView;

    private final NumberCompare numberCompare = new NumberCompare();

    public MainController(InputView inputView, OutputView outputView, RetryView retryView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryView = retryView;
    }

    public void run() throws IllegalArgumentException {
        try {
            outputView.printGameStart();
            Computer computer = new Computer();

            while (true) {
                User user = new User();
                user.setUserNumber(inputView.printUserInput());
                Map<String, Integer> comparisonResult = numberCompare.getNumberCount(
                        computer.getComputerNumber(),
                        user.getuserNumber());
                if (outputView.printGamerResult(comparisonResult)) {
                    if (retryView.printRetryMessage()) {
                        run();
                        break;
                    }
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }
}
