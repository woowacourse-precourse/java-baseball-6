package baseball;


public class Referee {
    int strike;
    int ball;
    Referee(){
        this.strike = 0;
        this.ball = 0;
    }
    public void judge(Ball userBall, Ball comBall){
        strike = comBall.countStrike(userBall);
        ball = comBall.countBall(userBall);
    }
    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }
}
