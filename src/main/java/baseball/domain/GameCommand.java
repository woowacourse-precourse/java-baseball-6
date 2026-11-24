package baseball.domain;

import baseball.exception.BaseballErrorMessage;
import baseball.exception.BaseballGameException;
import java.util.Arrays;

public enum GameCommand {
    RESTART("1"),
    EXIT("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String input){
        return Arrays.stream(values())
                .filter(command -> command.support(input))
                .findFirst()
                .orElseThrow(() -> new BaseballGameException(BaseballErrorMessage.INVALID_RESTART_NUMBER));
    }

    private boolean support(String input){
        return this.command.equals(input);
    }

    public boolean isRestart() {
        return this.equals(RESTART);
    }
}
