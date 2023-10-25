package result;

import utils.Utils;

public class Result {
    Utils utils = new Utils();
    String restartOrEnd = "";

    public Result(String restartOrEnd) {
        utils.userGameRestartOrEndValidation(restartOrEnd);
        this.restartOrEnd = restartOrEnd;
    }

    public boolean judgeRestartOrEnd() {
        if (restartOrEnd.equals("1")) {
            return true;
        }
        if (restartOrEnd.equals("2")) {
            return false;
        }
        return false;
    }
}
