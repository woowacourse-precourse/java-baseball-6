package baseball.domain;

import baseball.response.GameResponse;
import java.util.List;

public class Referee {

    private static final Referee instance = new Referee();
    public static final int INIT_VALUE = 0;
    public static final int NUMBERS_SIZE = 3;
    private int strike;
    private int ball;

    public static Referee getInstance() {
        return instance;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void initialization() {
        strike = INIT_VALUE;
        ball = INIT_VALUE;
    }

    public void playGame(Player user, Player computer) {
        initialization();
        calculateStrikeCount(user.getNumbers(), computer.getNumbers());
        calculateBallCount(user.getNumbers(), computer.getNumbers());
    }

    public void calculateStrikeCount(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            }
        }
    }

    public void calculateBallCount(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            for (int j = 0; j < NUMBERS_SIZE; j++) {
                if (i != j) {
                    if (user.get(i) == computer.get(j)) {
                        ball++;
                    }
                }
            }
        }
    }

    public GameStatus isGameEnd() {
        if (strike == 3) {
            return GameStatus.END;
        }
        return GameStatus.CONTINUE;
    }

    public GameResponse toResponse() {
        return new GameResponse(isGameEnd(), strike, ball);
    }

}
