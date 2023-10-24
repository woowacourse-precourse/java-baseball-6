package baseball.domain.baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.baseball.BaseballConst.*;

public class BaseballValidator {

    private static final BaseballValidator instance = new BaseballValidator();

    private BaseballValidator() {
    }

    public static BaseballValidator getInstance() {
        return instance;
    }

    public static void validateInput(final String input) {
        validateInputDigit(input);
    }

    private static void validateInputDigit(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_INPUT_DIGIT_MESSAGE);
        }
    }

    public static void validateCommand(final String command) {
        validateCommandDigit(command);
        validateCommandRange(command);
    }

    private static void validateCommandDigit(final String command) {
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_FINISH_COMMAND_MESSAGE);
        }
    }

    private static void validateCommandRange(final String command) {
        int value = Integer.parseInt(command);
        if (value != RESTART_COMMAND && value != FINISH_COMMAND) {
            throw new IllegalArgumentException(ILLEGAL_FINISH_COMMAND_MESSAGE);
        }
    }

    public static void validateUserPick(final List<Integer> pick) {
        validatePickSize(pick);
        validatePickDuplicate(pick);
        validatePickNoZeros(pick);
    }

    private static void validatePickSize(final List<Integer> pick) {
        if (pick.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_SIZE_MESSAGE);
        }
    }

    private static void validatePickDuplicate(final List<Integer> pick) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(pick);
        if (nonDuplicateNumbers.size() != pick.size()) {
            throw new IllegalArgumentException(ILLEGAL_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private static void validatePickNoZeros(final List<Integer> pick) {
        for (Integer value : pick) {
            if (value == 0) {
                throw new IllegalArgumentException(ILLEGAL_INPUT_INCLUDE_ZERO_MESSAGE);
            }
        }
    }
}
