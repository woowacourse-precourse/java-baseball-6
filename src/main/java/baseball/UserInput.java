package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    Validation validation = new Validation();
    public String getUserInput() {
        return Console.readLine();
    }

    public List<Integer> makeUserInputToThreeNumbers() {
        List<Integer> result = new ArrayList<>();
        String removeSpace = getUserInput().replace(" ", "");

        validation.validateThreeNumbers(removeSpace);
        for (int i = 0; i < removeSpace.length(); i++) {
            result.add(removeSpace.charAt(i) - '0');
        }
        return new ArrayList<>(result);
    }

    public void validateContinueSign(String input) {
        validation.validateSign(input);
    }
}
