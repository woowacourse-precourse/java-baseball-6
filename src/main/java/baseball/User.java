package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> numbers;
    private boolean gameRestart;
    private final UserInputValidator userInputValidator = new UserInputValidator();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isGameRestart() {
        return gameRestart;
    }

    public void generateNumbers() {
        List<Integer> userNumbers = new ArrayList<>();

        String userInput = Console.readLine();

        userInputValidator.validateInputNumbers(userInput);

        for (char input : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(input));
        }

        numbers = userNumbers;
    }

    public void decideGameRestart() {
        String userInput = Console.readLine();
    }
}
