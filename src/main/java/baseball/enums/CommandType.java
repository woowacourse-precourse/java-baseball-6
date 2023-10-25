package baseball.enums;

import static baseball.utils.ErrorMessage.COMMAND_CODE_IS_INVALID;

import java.util.Arrays;

public enum CommandType {
    RETRY("1"),
    END("0");

    private String code;

    CommandType(String code) {
        this.code = code;
    }

    public static CommandType selectCommandTypeByCode(String code) {
        return Arrays.stream(CommandType.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_CODE_IS_INVALID));
    }
}
