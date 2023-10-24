package baseball.service;

import baseball.domain.GameSystem;
import baseball.domain.Hint;
import baseball.domain.User;

import java.util.List;

public class GameService {
    private final User user;
    private final Hint hint;
    private GameSystem gameSystem;

    public GameService(final User user, final Hint hint, final GameSystem gameSystem){
        this.user = user;
        this.hint = hint;
        this.gameSystem = gameSystem;
    }
    
    public GameService() {
        this(new User(), new Hint(), new GameSystem());
    }


    public void setUserBaseballNumber(String input) {
        user.setUserBaseballNumber(input);
    }

    public boolean restart(String input) {
        if (input.equals("1")) {
            this.gameSystem = new GameSystem();
            return true;
        }
        if (input.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public List<Integer> calculateBaseBall() {
        hint.calculateBaseBall(user.getUserBaseballNumber(), gameSystem.getSystemBaseBallNumber());
        return List.of(hint.getBallCount(), hint.getStrikeCount());
    }

    public boolean isWin() {
        return hint.isWin();
    }
}
