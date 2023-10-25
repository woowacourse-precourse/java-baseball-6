package baseball.domain;

import static baseball.util.MessageConst.RESTART_FORMAT_EXCEPTION;

public class Restart {
    private final boolean restart;

    public Restart(String userChoice) {
        this.restart = getUserChoice(userChoice);
    }

    private static boolean getUserChoice(String userChoice) {
        validateInputFormat(userChoice);
        return userChoice.equals("1");
    }

    private static void validateInputFormat(String userChoice) {
        if (!userChoice.equals("1") && !userChoice.equals("2")) {
            throw new IllegalArgumentException(RESTART_FORMAT_EXCEPTION);
        }
    }

    public boolean wantRestart() {
        return restart;
    }
}
