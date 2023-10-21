package baseball.domain.command.validation;

import static baseball.domain.command.GameCommands.GAME_END;
import static baseball.domain.command.GameCommands.RESTART;

public class CommandValidator {

    private static final String NONE_COMMAND = "해당 명령어는 존재하지 않습니다.";

    public static void validate(Integer command) {
        if (!command.equals(RESTART) && !command.equals(GAME_END)) {
            throw new IllegalArgumentException(NONE_COMMAND);
        }
    }
}
