package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.exception.ErrorMsg;
import racingcar.exception.UserInputException;

public class GameValidator {

    private final static int CAME_COUNT_ZERO = 0;
    private static final int CAR_NAME_MAX_LENGTH = 6;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_BLANK = 0;
    private static final int CAR_CHECK_INDEX_1 = 1;
    private static final String BLANK_BAR = " ";
    private static final String COMMA = ",";

    public static String isNumeric(String strValue) {
        try {
            Integer.parseInt(strValue);
            return strValue;
        } catch (NumberFormatException ex) {
            throw new UserInputException(ErrorMsg.ERROR_INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static void validateCheckGameCycle(int cycleCount) {
        if (cycleCount == CAME_COUNT_ZERO) {
            throw new UserInputException(ErrorMsg.ERROR_GAME_CYCLE_SAME_0.getMessage());
        }
    }

    public static void validateCheckDuplicateCarName(List<Car> raceCars) {
        Set<String> carNamesSet = new HashSet<>();
        boolean hasDuplicate = raceCars.stream()
                .map(Car::getCarName)
                .anyMatch(carName -> !carNamesSet.add(carName));
        if (hasDuplicate) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_NAME_SAME.getMessage());
        }
    }

    public static void validateCarNameSpaceBlack(String carName) {

        if (carName.equals(BLANK_BAR)) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_NAME_BLANK_BAR.getMessage());
        }
    }

    public static void validateCarNameMinLength(String carName) {
        if (carName.length() == CAR_NAME_MIN_LENGTH) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_NAME_MIN_LENGTH.getMessage());
        }
    }

    public static void validateLastWordToCarName(String carName) {
        if (carName.substring(carName.length() - CAR_CHECK_INDEX_1).equals(COMMA)) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_LAST_WORD.getMessage());
        }
    }


    public static void validateBlankCarName(String carName) {
        if (carName.length() == CAR_NAME_BLANK) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_NOT_FOUND_NAME.getMessage());
        }
    }

    public static void validateCarNameMaxLength(String carName) {
        if (carName.length() == CAR_NAME_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.ERROR_CAR_NAME_LENGTH_MORE_THAN_6.getMessage());
        }
    }
}
