package baseball.domain;

import baseball.enums.CommandType;

public class GameManager {
    public boolean isGameRetry(String commandCode) throws IllegalArgumentException {
        return CommandType.selectCommandTypeByCode(commandCode)
                .equals(CommandType.RETRY);
    }
}
