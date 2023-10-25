package baseball.view;

import baseball.utils.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class InputView {

    private static final String GAME_RESTART_INPUT = "1";
    private static final String GAME_END_INPUT = "2";
    private static final int USER_INSERT_NUMBER_SIZE_THREE = 3;
    private static final int USER_ANSWER_NUMBER_RANGE_MIN = 1;

    private InputView() {
    }

    public static String commandUserInput() {
        return Console.readLine();
    }

    public static List<Integer> generateUserAnswer() {
            List<Integer> userAnswer = getUserInput();
            validateUserAnswerInput(userAnswer);
            return userAnswer;
    }

    public static List<Integer> getUserInput() {
        List<Integer> userAnswer = new ArrayList<>();
        String input = InputView.commandUserInput();
        String[] splitInput = input.split("");
        for (String userInput : splitInput) {
            try {
                int convertInt = Integer.parseInt(userInput);
                userAnswer.add(convertInt);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_ONLY_NUMBER.getMessage());
            }
        }
        return userAnswer;
    }

    public static void validateUserAnswerInput(List<Integer> userAnswers) {
        for (Integer userAnswer : userAnswers) {
            if (userAnswer < USER_ANSWER_NUMBER_RANGE_MIN) {
                throw new IllegalArgumentException(ErrorMessage.INSERT_USER_NUMBER_SIZE_ERROR.getMessage());
            }
        }

        if (userAnswers.size() != USER_INSERT_NUMBER_SIZE_THREE) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NUMBER_SIZE_THREE.getMessage());
        }

        Set<Integer> userAnswerSet = new HashSet<>(userAnswers);
        if (userAnswerSet.size() != USER_INSERT_NUMBER_SIZE_THREE) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NUMBER_NOT_DUPLICATION.getMessage());
        }
        for (Integer userAnswer : userAnswers) {
            if(!userAnswers.contains(userAnswer)){
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NUMBER_NOT_DUPLICATION.getMessage());
            }
        }
    }

    public static boolean restartGame() {
        OutputView.printAskRestart();
        String userInput = InputView.commandUserInput();
        if (Objects.equals(userInput, GAME_RESTART_INPUT)) {
            return true;
        }
        if (Objects.equals(userInput, GAME_END_INPUT)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.INSERT_USER_RESTART_COMMAND_ERROR.getMessage());
    }
}
