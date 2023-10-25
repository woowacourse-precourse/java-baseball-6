package baseball.model;

import baseball.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static final String RESTART_NUMBER = "1";
    private static final boolean RESTART = true;
    private static final boolean DO_NOT_RESTART = false;
    private boolean gameRestart;
    private final UserInputValidator userInputValidator = new UserInputValidator();

    public List<Integer> generateNumbers() {
        String userInput = Console.readLine();
        userInputValidator.validateInputNumbers(userInput);

        List<Integer> numbers = new ArrayList<>();
        for (char input : userInput.toCharArray()) {
            numbers.add(Character.getNumericValue(input));
        }

        return numbers;
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

    public boolean isGameRestart() {
        return gameRestart;
    }
}
