package baseball;

import static baseball.Utils.*;
public class Controller {

    public Controller() {}


    private void printRequestRestartOrFinish() {
        System.out.println(RESTART_OR_FINISH);
    }

    private void validateRange(String state) {
        if (!state.equals(START_GAME) && !state.equals(END_GAME)) {
            throw new IllegalArgumentException("Invalid number is entered");
        }
    }
}
