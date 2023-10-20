package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.Hint;
import baseball.domain.User;

import java.util.List;

public class GameService {
    private final User user;
    private GameSystem gameSystem;
    private final Hint hint;

    public GameService() {
        user = new User();
        gameSystem = new GameSystem();
        hint = new Hint();
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

    public List<Integer> calculateBaseBall(){
        hint.calculateBaseBall(user.getUserBasebsallNumber(),gameSystem.getSystemBaseBallNumber());
        return List.of(hint.getBallCount(),hint.getStrikeCount());
    }
}
