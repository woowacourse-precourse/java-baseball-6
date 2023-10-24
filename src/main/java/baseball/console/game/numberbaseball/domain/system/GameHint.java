package baseball.console.game.numberbaseball.domain.system;

public class GameHint {
    private int strike;
    private int ball;

    public GameHint(){
        strike = 0;
        ball = 0;
    }

    public void addStrike() {
        strike++;
    }
    public void addBall() {
        ball++;
    }
    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }
}
