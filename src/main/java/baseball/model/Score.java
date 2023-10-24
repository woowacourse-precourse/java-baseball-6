package baseball.model;

import baseball.view.ViewResult;

import java.util.Objects;

import static baseball.Application.computerRandomBalls;
import static baseball.Application.userRandomBalls;

public class Score {
    public static class ScoreBoard {
        int strike;
        int ball;
        public ScoreBoard(int strike, int ball){
            this.strike = strike;
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }
    }
    ViewResult viewResult = new ViewResult();
    public int play() {
        return viewResult.printResult(calculateScore());
    }

    private ScoreBoard calculateScore() {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(Objects.equals(computerRandomBalls.get(i), userRandomBalls.get(j))){
                    if(i==j)    strike++;
                    else    ball++;
                    break;
                }
            }
        }
        return new ScoreBoard(strike,ball);
    }
}
