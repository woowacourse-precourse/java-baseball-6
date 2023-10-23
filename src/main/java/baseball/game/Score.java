package baseball.game;

import static baseball.constvalue.ConstValue.*;
public class Score {
    private int strike;
    private int ball;

    public Score(){
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike(){
        return this.strike;
    }

    public int getBall(){
        return this.ball;
    }

    public void resetScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike(){
        this.strike += 1;
    }

    public void addBall(){
        this.ball += 1;
    }

    public boolean isThreeStrike(){
        if (this.strike==THREE_STRIKE){
            return true;
        }

        return false;
    }
}
