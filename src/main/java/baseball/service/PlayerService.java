package baseball.service;

import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {

    private final BaseballValidator baseballValidator;

    public PlayerService(BaseballValidator baseballValidator) {
        this.baseballValidator = baseballValidator;
    }

    public String receiveBaseballNumber() {
        String playerBaseballNumber = Console.readLine();
        baseballValidator.validate(playerBaseballNumber);
        return playerBaseballNumber;
    }
}
