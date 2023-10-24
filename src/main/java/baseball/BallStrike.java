package baseball;

// 볼, 스트라이크 갯수가 자주 필요하여 따로 뺌
public class BallStrike {
    private int ball;
    private int strike;
    
    public BallStrike(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
    
    public boolean isCorrect(){
        return strike==3;
    }
}
