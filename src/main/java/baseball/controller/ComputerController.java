package baseball.controller;

import static baseball.model.Constant.NUMBER_SIZE;

import baseball.model.DecimalNumber;
import baseball.view.OutputView;
import java.util.List;

public class ComputerController {

    DecimalNumber decimalNumber;

    public ComputerController(DecimalNumber decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public void initComputer() {
        decimalNumber.setComputer();
    }

    public Boolean checkAnswer() {
        List<Integer> computer = decimalNumber.getComputer();
        List<Integer> user = decimalNumber.getUser();

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        OutputView.printHint(ball, strike);

        if (strike == NUMBER_SIZE) {
            return false;
        }
        return true;
    }
}
