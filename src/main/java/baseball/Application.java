package baseball;

import baseball.logic.GameLogic;
import baseball.utils.ComputerUtils;
import baseball.utils.MessageUtils;
import baseball.utils.UserUtils;
import baseball.verification.InputVerification;
import baseball.verification.RestartVerification;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageUtils.startMessage();
        ComputerUtils computerUtils = new ComputerUtils();
        UserUtils userUtils = new UserUtils();
        List<Integer> computerNumber = computerUtils.generateComputerNumber();

        while (true) {
            List<Integer> userNumber = new ArrayList<>();
            MessageUtils.inputPromptMessage();
            String stringFormInputNumber = userUtils.inputUserNumber();
            InputVerification.verifyNumber(stringFormInputNumber);

            int intFormInputNumber = Integer.parseInt(stringFormInputNumber);
            userNumber.add(intFormInputNumber / 100);
            userNumber.add((intFormInputNumber % 100) / 10);
            userNumber.add(intFormInputNumber % 10);

            int strike = GameLogic.checkStrike(userNumber, computerNumber);
            int ball = GameLogic.checkBall(userNumber, computerNumber);

            MessageUtils.resultMessage(strike, ball);

            if (strike == 3) {
                if (!RestartVerification.askForRestart()) {
                    break;
                }
                computerNumber = computerUtils.generateComputerNumber();
            }
        }
    }
}

