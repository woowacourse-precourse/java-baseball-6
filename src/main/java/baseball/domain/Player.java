package baseball.domain;

import baseball.utils.Input;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerInput = new ArrayList<>();
    private String restartMessage;

    public List<Integer> getPlayerInput() {
        setPlayerInput();
        return playerInput;
    }

    private void setPlayerInput() {
        playerInput = Input.askPlayerInput();
    }

    public String getRestartMessage() {
        setRestartMessage();
        return restartMessage;
    }

    private void setRestartMessage() {
        restartMessage = Input.askRestart();
    }

}
