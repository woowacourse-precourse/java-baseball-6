package baseball.domain;

import baseball.constants.BaseballConstant;
import baseball.messages.ValidationErrorMessage;

public class GameRestartChecker {
    private int restartYn;
    public int getRestartYn() {
        return restartYn;
    }

    public void updateRestartYn(String restartYn) {
        validate(restartYn);
        this.restartYn = convertor(restartYn);
    }
    private void validate(String restart_yn) {
        try {
            int restart = Integer.parseInt(restart_yn);
            checkRestartYn1or2(restart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationErrorMessage.RESTART_YN_TYPE_ERROR);
        }
    }
    private int convertor(String restart_yn) {
       return Integer.parseInt(restart_yn);
    }

    private static void checkRestartYn1or2(int restart) {
        if (restart != BaseballConstant.RESTART_YES && restart != BaseballConstant.RESTART_NO) {
            throw new IllegalArgumentException(ValidationErrorMessage.RESTART_YN_NOT_1_OR_2_ERROR);
        }
    }
}