package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {
    public static List<String> inputGameNumber(Validator validator) {
        List<String> numbers = getNumberList(Console.readLine());
        validator.validateStandard(numbers);
        return numbers;
    }

    private static List<String> getNumberList(String numbers) {
        return List.of(numbers.split(""));
    }

    public static int endOrRestart(Validator validator) {
        String userInput = Console.readLine();
        return validator.validateEndOrRestart(userInput);
    }
}
