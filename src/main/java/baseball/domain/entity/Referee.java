package baseball.domain.entity;

import baseball.domain.dto.GameResponse;
import baseball.domain.entity.game.GameStatus;
import baseball.domain.entity.player.Player;

public class Referee {

    public static final int INIT_VALUE = 0;
    private int strike;
    private int ball;


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
        calculateStrikeCount(user, computer);
        calculateBallCount(user, computer);
    }

    public void calculateStrikeCount(Player user, Player computer) {
        this.strike = user.getNumbers().matchStrike(computer.getNumbers());
    }

    public void calculateBallCount(Player user, Player computer) {
        this.ball = user.getNumbers().matchBall(computer.getNumbers());
    }

    public GameStatus isGameOver() {
        if (strike == 3) {
            return GameStatus.OVER;
        }
        return GameStatus.CONTINUE;
    }

    public GameResponse toResponse() {
        return new GameResponse(isGameOver(), strike, ball);
    }

}
