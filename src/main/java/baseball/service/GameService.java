package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.User;

public class GameService {
    private final User user;
    private final GameSystem gameSystem;

    public GameService() {
        user = new User();
        gameSystem = new GameSystem();
    }

    public void setUserbaseballNumber(String input){
        user.setUserBasebsallNumber(input);
    }
}
