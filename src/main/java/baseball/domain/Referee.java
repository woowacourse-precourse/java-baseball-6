package baseball.domain;

public class Referee {

    private static final int STRIKE_FULL_COUNT = 3;
    public static final int ZERO_COUNT = 0;
    private final Strike strike;
    private final Ball ball;

    public Referee(Strike strike, Ball ball){
       this.strike = strike;
       this.ball = ball;
    }


    public boolean judgment(){
        return strike.getStrike() == STRIKE_FULL_COUNT;
    }

    public boolean judgmentZero(){
        return strike.getStrike() == ZERO_COUNT && ball.getBall() == ZERO_COUNT;
    }

    public int getStrikeScore() {
        return strike.getStrike();
    }

    public int getBallScore() {
        return ball.getBall();
    }
}