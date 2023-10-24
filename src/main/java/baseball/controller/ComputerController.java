package baseball.controller;

import static baseball.model.Constant.FINISHED;
import static baseball.model.Constant.NUMBER_SIZE;
import static baseball.model.Constant.RUNNING;

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

    public boolean checkAnswer() {
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

        return answerResult(ball, strike);
    }

    private boolean answerResult(int ball, int strike) {
        OutputView.printHint(ball, strike);

        if (strike == NUMBER_SIZE) {
            return FINISHED;
        }
        return RUNNING;
    }
}
