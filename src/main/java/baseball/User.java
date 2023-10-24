package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    private List<Integer> numbers;
    private boolean gameRestart;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isGameRestart() {
        return gameRestart;
    }

    public void generateNumbers() {
        String userInput = Console.readLine();
        UserInputValidator userInputValidator = new UserInputValidator();

        userInputValidator.validateInputNumbers(userInput);

        for (char input : userInput.toCharArray()) {
            numbers.add(Character.getNumericValue(input));
        }
    }
}
