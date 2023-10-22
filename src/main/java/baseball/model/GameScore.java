package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameScore {

    private static final int GAME_END_SCORE = 3;

    private int strike;
    private int ball;

    public GameScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void updateStrike() {
        strike++;
    }

    public void updateBall() {
        ball++;
    }

    public List<Integer> getResult() {
        return new ArrayList<>() {{
            add(strike);
            add(ball);
        }};
    }

    public boolean isUserFindAnswer() {
        return strike == GAME_END_SCORE;
    }
}
