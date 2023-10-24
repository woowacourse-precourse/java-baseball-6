package domain;

public class Score {
    int strike;
    int ball;


    public int getSrike() {

        return strike;
    }
    public int incStrike(){

        return strike += 1;
    }

    public int getBall() {

        return ball;
    }
    public int incBall(){

        return ball += 1;
    }

}
