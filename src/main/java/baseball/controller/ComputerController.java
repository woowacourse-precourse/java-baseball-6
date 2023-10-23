package baseball.controller;

import baseball.model.DecimalNumber;
import baseball.view.OutputView;
import java.util.List;

public class ComputerController {

    private RandomNumber randomNumber = new RandomNumber();
    private OutputView outputView;
    private Validation validation;

    public ComputerController(OutputView outputView, Validation validation) {
        this.outputView = outputView;
        this.validation = validation;
    }

    public void startGame(DecimalNumber decimalNumber) {
        List<Integer> computer = randomNumber.generateRandomNum();
        decimalNumber.setComputer(computer);
    }

    
}
