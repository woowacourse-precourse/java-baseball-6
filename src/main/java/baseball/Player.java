package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    private Numbers numbers;
    private UserInputValidator userInputValidator;

    public Player() {
    }

    public void getUserInput() {
        String userInput = Console.readLine();
        userInputValidator = new UserInputValidator(userInput);
        userInputValidator.checkValid();
        List<Integer> userInputNumbers = userInput.chars().mapToObj(Character::getNumericValue).toList();
        numbers = new Numbers(userInputNumbers);
    }
}

