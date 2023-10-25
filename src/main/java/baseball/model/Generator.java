package baseball.model;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.Integer.parseInt;

public class Generator {
    public static int generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return parseInt(sb.toString());
    }

    public static int generateUserNumber() {
        int validateNumber = 0;
        String userInputString = InputView.userInput();

        try {
            validateNumber = Validation.isValidateNumber(userInputString);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return validateNumber;
    }
}
