package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    public List<String> inputGameNumber(Validator validator) {
        List<String> numbers = getNumberList(Console.readLine());
        validator.validateStandard(numbers);
        return numbers;
    }

    private List<String> getNumberList(String numbers) {
        return List.of(numbers.split(""));
    }

    public String endOrRestart(Validator validator) {
        String userInput = Console.readLine();
        validator.validateEndOrRestart(userInput);

        return userInput;
    }
}
