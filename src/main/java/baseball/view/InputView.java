package baseball.view;

import baseball.util.ValidationRule;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final ValidationRule validationRules;

    public InputView(ValidationRule validationRules) {
        this.validationRules = validationRules;
    }

    public List<Integer> readPlayerNumber() {
        String input = getValidatedPlayerNumber(Console.readLine());
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private String getValidatedPlayerNumber(String playerNumber) {
        validationRules.FormatValidationRule(playerNumber);
        validationRules.NumericValidationRule(playerNumber);
        validationRules.LengthValidationRule(playerNumber);
        return playerNumber; // Return the playerNumber after validation
    }
}
