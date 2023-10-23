package baseball.domain;

import static baseball.domain.AnswerFactory.ANSWER_SIZE;

public class Referee {
    private final Strike strike;
    private final Ball ball;

    public Referee(Strike strike, Ball ball){
       this.strike = strike;
       this.ball = ball;
    }


    public boolean judgment(){
        return strike.getStrike() == ANSWER_SIZE;
    }

    public boolean judgmentZero(){
        return strike.getStrike() == 0 && ball.getBall() == 0;
    }

    public int getStrikeScore() {
        return strike.getStrike();
    }

    public int getBallScore() {
        return ball.getBall();
    }
}