package baseball;

public class BaseballScore {

    public int ball, strike;

    BaseballScore() {
        ball = strike = 0;
    }

    @Override
    public String toString() {
        if(ball == 0 && strike == 0) { return "낫싱"; }
        if(ball != 0 && strike == 0) { return String.format("%d볼", ball); }
        if(ball == 0 && strike != 0) { return String.format("%d스트라이크", strike); }
        return String.format("%d볼 %d스트라이크", ball, strike);
    }

}
