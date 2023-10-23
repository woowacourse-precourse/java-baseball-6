package baseball.model;


import static baseball.util.Constants.BALL_KEY;
import static baseball.util.Constants.STRIKE_KEY;

import java.util.HashMap;

public class Game {
    private HashMap<Integer, Integer> score = new HashMap<>();

    public void newGame() {
        score.clear();
    }

    public void setScore(HashMap<Integer, Integer> score) {
        this.score = score;
    }

    public int getStrike() {
        return score.get(STRIKE_KEY);
    }

    public int getBall() {
        return score.get(BALL_KEY);
    }
}
