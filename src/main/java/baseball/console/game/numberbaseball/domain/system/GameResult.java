package baseball.console.game.numberbaseball.domain.system;

import baseball.console.game.numberbaseball.domain.system.GameHint;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(GameHint hint) {
        strike = hint.getStrike();
        ball = hint.getBall();
    }

    public String exportMessage() {
        if (strike == 0 && ball == 0)
            return "낫싱\n";

        String message = "";
        if (ball > 0)
            message += String.format("%d볼 ", this.ball);
        if (strike > 0)
            message += String.format("%d스트라이크", this.strike);
        message += "\n";
        if (strike == 3)
            message += String.format("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", this.strike);

        return message;
    }

}
