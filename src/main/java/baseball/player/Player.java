package baseball.player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";

    public Guess makeGuess() {
        return new Guess(getPlayerInput());
    }

    public boolean wantToRestartRound() {
        String flag = getPlayerInput();
        isInputNull(flag);
        checkFlagValidation(flag);
        return isRestartFlag(flag);
    }

    private String getPlayerInput() {
        String playerInput = readLine();
        return playerInput;
    }

    private void isInputNull(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkFlagValidation(String flag) {
        if (!flag.equals(RESTART_FLAG) && !flag.equals(EXIT_FLAG)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestartFlag(String flag) {
        return flag.equals(RESTART_FLAG);
    }
}
