package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    private Numbers numbers;
    private final UserInputValidator userInputValidator;

    public Player() {
        this.userInputValidator = new UserInputValidator();
    }

    public void getUserInput() {
        String userInput = Console.readLine();
        userInputValidator.checkValid(userInput);
        List<Integer> userInputNumbers = userInput.chars().mapToObj(Character::getNumericValue).toList();
        numbers = new Numbers(userInputNumbers);
    }
}

