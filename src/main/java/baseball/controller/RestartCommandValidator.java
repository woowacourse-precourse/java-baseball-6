package baseball.controller;

import static baseball.exception.ExceptionMessage.INVALID_RESTART_COMMAND;
import static baseball.exception.ExceptionMessage.NOT_NUMERIC;
import static baseball.exception.ExceptionMessage.OUT_OF_LENGTH;

import java.util.regex.Pattern;

public class RestartCommandValidator {

    // 기능: 게임 재시작 입력 검증
    public void validateRestartCommandInput(String restartCommand) {
        validateLength(restartCommand, 1);
        validateNumeric(restartCommand);
        validateOneOrTwo(restartCommand);
    }

    // 기능: length 자릿수로 입력해야 한다
    private void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.getError(input, length));
        }
    }

    // 기능: 숫자만 입력해야 한다
    private void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException(NOT_NUMERIC.getError(input));
        }
    }

    // 기능: 1 또는 2만 입력해야 한다
    private void validateOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(INVALID_RESTART_COMMAND.getError(input));
        }
    }
}
