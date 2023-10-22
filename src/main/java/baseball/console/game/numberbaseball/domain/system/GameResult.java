package baseball.console.game.numberbaseball.domain.system;

import static baseball.console.game.numberbaseball.config.GameMessage.*;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(GameHint hint) {
        strike = hint.getStrike();
        ball = hint.getBall();
    }

    public String exportMessage() {
        if (strike == 0 && ball == 0)
            return NOTHING_POSTFIX;
        return makeMessage();
    }

    private String makeMessage() {
        String message = "";
        if (ball > 0)
            message += this.ball + BALL_POSTFIX;
        if (strike > 0)
            message += this.strike + STRIKE_POSTFIX;
        message += "\n";
        if (strike == 3)
            message += CLEAR_AND_EXIT;

        return message;
    }

}
