package baseball.player;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    public Guess makeGuess() {
        return new Guess(getPlayerInput());
    }

    public RestartFlag makeRestartFlag() {
        return new RestartFlag(getPlayerInput());
    }

    private String getPlayerInput() {
        return readLine();
    }
}
