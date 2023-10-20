package baseball.domain;

public class BallCount {
    private static final String BALL= "볼 ";
    private static final String STRIKE= "스트라이크";
    private static final Integer STRIKE_NUMBER = 1;
    private static final Integer THREE_STRIKE_STRIKE= 3;
    private static final Integer THREE_STRIKE_BALL= 0;
    private static final String THREE_STRIKE_STRING = "3스트라이크";

    private static final Integer NOTHING_STRIKE= 0;
    private static final Integer NOTHING_BALL =0;
    private static final String NOTHING_STRING = "낫싱";


    int strike;
    int ball;
    boolean strikeOut;
    public BallCount(boolean strikeOut){
        this.strikeOut= strikeOut;
    }

    public boolean isStrikeOut() {
        return strikeOut;
    }


    public String getBallCount(){
        if(this.strike == THREE_STRIKE_STRIKE && this.ball == THREE_STRIKE_BALL){
            return THREE_STRIKE_STRING;
        }
        if(this.strike == NOTHING_STRIKE && this.ball == NOTHING_BALL){
            return NOTHING_STRING;
        }
        return this.ball + BALL + this.strike + STRIKE;
    }
    public void setStrike(){
        this.strike += STRIKE_NUMBER;
    }
    public void setBall() {
        this.ball += STRIKE_NUMBER;
    }
    public void initBallCount(){
        this.strike=0;
        this.ball=0;
    }
    public void strikeOut(){
        if(this.strike == THREE_STRIKE_STRIKE && this.ball == THREE_STRIKE_BALL){
            this.strikeOut= false;
        }
    }
}
