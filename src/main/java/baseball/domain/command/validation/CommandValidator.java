package baseball.domain.command.validation;

import baseball.domain.command.GameCommands;

public class CommandValidator {

    private static final String NONE_COMMAND = "해당 명령어는 존재하지 않습니다.";

    public static void validate(Integer command) {
        if (!command.equals(GameCommands.RESTART) && !command.equals(GameCommands.GAME_END)) {
            throw new IllegalArgumentException(NONE_COMMAND);
        }
    }
}
