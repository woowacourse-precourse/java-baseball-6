package baseball.service;

import static baseball.constant.BaseballConstant.RESTART_OPTION;
import static baseball.constant.BaseballConstant.TURN_OFF_OPTION;

public class PlayerService {

    private static final String WRONG_CHOICE_MESSAGE = "잘못된 선택입니다.";

    public boolean selectOption(String optionNumber) {
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
