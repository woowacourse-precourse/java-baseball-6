package baseball.model;

import baseball.utils.Util;
import baseball.validation.Validation;

public class ReGameOrExit {
    static final int RE_START = 1;
    static final int EXIT_GAME = 2;
    private final int reGameOrExitNum;
    public ReGameOrExit(String reGameOrExitStr) {
        Validation.validateInteger(reGameOrExitStr);
        reGameOrExitNum = Util.stringToInt(reGameOrExitStr);
        Validation.validateRange(reGameOrExitNum, RE_START, EXIT_GAME);
    }

    public int getReGameOrExitNum() {
        return reGameOrExitNum;
    }

}
