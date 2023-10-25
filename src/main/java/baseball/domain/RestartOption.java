package baseball.domain;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerUtil;
import baseball.validation.IntegerValidator;

public enum RestartOption {
    RESTART_GAME(1),
    EXIT_GAME(2),
    OTHER_CHOICE(3);

    private final int value;

    RestartOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RestartOption create(String stringValue) {
        IntegerValidator.validateInteger(stringValue);
        int value = Integer.parseInt(stringValue);

        RestartOption restartOption = findRestartOption(value);
        validateOtherChoice(restartOption);
        return restartOption;
    }

    private static RestartOption findRestartOption(int value) {
        for (RestartOption choice : RestartOption.values()) {
            if (choice.getValue() == value) {
                return choice;
            }
        }
        return OTHER_CHOICE;
    }

    private static void validateOtherChoice(RestartOption restartOption) {
        if (restartOption == OTHER_CHOICE) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}

