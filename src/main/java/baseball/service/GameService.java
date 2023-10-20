package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.Hint;
import baseball.domain.User;

import java.util.List;

public class GameService {
    private final User user;
    private final Hint hint;
    private GameSystem gameSystem;

    public GameService() {
        user = new User();
        gameSystem = new GameSystem();
        hint = new Hint();
    }

    public void setUserBaseballNumber(String input) {
        user.setUserBasebsallNumber(input);
    }

    public boolean restart(String input) {
        if (input.equals("1")) {
            this.gameSystem = new GameSystem();
            return true;
        } else if (input.equals("2"))
            return false;

        throw new IllegalArgumentException();
    }

    public List<Integer> calculateBaseBall() {
        hint.calculateBaseBall(user.getUserBasebsallNumber(), gameSystem.getSystemBaseBallNumber());
        return List.of(hint.getBallCount(), hint.getStrikeCount());
    }

    public boolean isWin() {
        return hint.isWin();
    }
}
