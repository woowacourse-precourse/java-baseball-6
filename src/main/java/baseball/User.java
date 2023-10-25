package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final char RESTART_NUMBER = '1';
    private static final boolean RESTART = true;
    private static final boolean DO_NOT_RESTART = false;
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
        userInputValidator.validateInputRestartNumber(userInput);

        if (userInput.equals(RESTART_NUMBER)) {
            gameRestart = RESTART;
        } else {
            gameRestart = DO_NOT_RESTART;
        }
    }
}
