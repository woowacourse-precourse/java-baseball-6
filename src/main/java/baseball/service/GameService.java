package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.User;

public class GameService {
    private final User user;
    private GameSystem gameSystem;

    public GameService() {
        user = new User();
        gameSystem = new GameSystem();
    }

    public void setUserBaseballNumber(String input){
        user.setUserBasebsallNumber(input);
    }

    public boolean restart(String input){
        if (input.equals("1"))
            return true;
        else if (input.equals("2"))
            return false;

        this.gameSystem = new GameSystem();

        throw new IllegalArgumentException();
    }
}
