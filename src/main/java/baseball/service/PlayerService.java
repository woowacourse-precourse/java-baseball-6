package baseball.service;

import static baseball.constant.BaseballConstant.RESTART_OPTION;
import static baseball.constant.BaseballConstant.TURN_OFF_OPTION;

import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Console;

public class PlayerService {

    private static final String WRONG_CHOICE_MESSAGE = "잘못된 선택입니다.";

    private final BaseballValidator baseballValidator;

    public PlayerService(BaseballValidator baseballValidator) {
        this.baseballValidator = baseballValidator;
    }

    public String receiveBaseballNumber() {
        String playerBaseballNumber = Console.readLine();
        baseballValidator.validate(playerBaseballNumber);
        return playerBaseballNumber;
    }

    public boolean askToContinue() {
        String optionNumber = Console.readLine();
        return selectOption(optionNumber);
    }

    private boolean selectOption(String optionNumber) {
        switch (Integer.parseInt(optionNumber)) {
            case RESTART_OPTION -> {
                return true;
            }
            case TURN_OFF_OPTION -> {
                return false;
            }
            default -> throw new IllegalArgumentException(WRONG_CHOICE_MESSAGE);
        }
    }
}
