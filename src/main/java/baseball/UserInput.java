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
        String removedSpace = getUserInput().replace(" ", "");

        validation.validateThreeNumbers(removedSpace);
        for (int i = 0; i < removedSpace.length(); i++) {
            result.add(removedSpace.charAt(i) - '0');
        }
        return new ArrayList<>(result);
    }

    public void validateContinueSign(String input) {
        validation.validateSign(input);
    }
}
