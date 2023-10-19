package baseball.view;

import baseball.validation.GameValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<Integer> userInputNumber() {

        String userInput = Console.readLine();
        GameValidator.validateIsNumber(userInput);

        String[] split = userInput.split("");

        return changeUserInputToInt(split);
    }

    public int decideGameActionInput() {

        String userInput = Console.readLine();
        GameValidator.validateIsNumber(userInput);

        int decideGameAction = Integer.parseInt(userInput);
        GameValidator.validateIsOneOrTwo(decideGameAction);

        return decideGameAction;
    }

    private List<Integer> changeUserInputToInt(String[] userInput) {

        GameValidator.validateIsThreeNumbers(userInput);

        return Arrays.stream(userInput)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
