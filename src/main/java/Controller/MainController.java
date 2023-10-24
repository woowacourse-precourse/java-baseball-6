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

    public void run() {
        do {
            startGame();
        } while (retryGame());
    }

    private void startGame() {
        outputView.printGameStart();
        Computer computer = creatComputer();
        while (true) {
            User user = createUser();
            Map<String, Integer> comparisonResult = compareNumbers(computer, user);
            if (isGameOver(comparisonResult)) {
                break;
            }
        }
    }
    
    private Computer creatComputer() {
        return new Computer();
    }

    private User createUser() {
        User user = new User();
        user.setUserNumber(inputView.printUserInput());
        return user;
    }

    private Map<String, Integer> compareNumbers(Computer computer, User user) {
        return numberCompare.getNumberCount(
                computer.getComputerNumber(),
                user.getuserNumber());
    }

    private boolean isGameOver(Map<String, Integer> comparisonResult) {
        return outputView.printGamerResult(comparisonResult);
    }

    private boolean retryGame() {
        return retryView.printRetryMessage();
    }
}
