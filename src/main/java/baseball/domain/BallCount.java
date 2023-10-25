package baseball.domain;

import java.util.List;

public class BallCount {
    private static final Integer BASEBALL_SIZE =3;
    private static final String BALL_STRING= "볼 ";
    private static final String STRIKE_STRING= "스트라이크";
    private static final Integer BASEBALL_BALL = 1;
    private static final Integer THREE_STRIKE = 3;
    private static final Integer NOTHING_STRIKE= 0;
    private static final Integer NOTHING_BALL =0;
    private static final String THREE_STRIKE_MESSAGE = "3스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strike;
    private int ball;
    private boolean strikeOut;

    public boolean isStrikeOut() {
        return strikeOut;
    }

    public BallCount(boolean strikeOut){
        this.strikeOut= strikeOut;
    }

    private void incrementStrike(){
        this.strike += BASEBALL_BALL;
    }

    private void incrementBall() {
        this.ball += BASEBALL_BALL;
    }

    public void initializeBallCount(){
        this.strike=0;
        this.ball=0;
    }

    public String printBallCount(){
        if(this.strike == THREE_STRIKE && this.ball == NOTHING_BALL){
            return THREE_STRIKE_MESSAGE;
        }
        if(this.strike == NOTHING_STRIKE && this.ball == NOTHING_BALL){
            return NOTHING_MESSAGE;
        }
        if(this.strike == NOTHING_STRIKE && this.ball != NOTHING_BALL){
            return this.ball + BALL_STRING ;
        }
        if(this.strike !=NOTHING_STRIKE && this.ball == NOTHING_BALL){
            return this.strike + STRIKE_STRING;
        }
        return this.ball + BALL_STRING + this.strike + STRIKE_STRING;
    }

    public void ballCountResponse(List<Integer> computerBall, List<Integer> userBall) {
        ballCountCheck(computerBall,userBall);
        strikeOutCheck();
    }

    private void ballCountCheck(List<Integer> computerBall, List<Integer> userBall){
        for(int i = 0 ; i < BASEBALL_SIZE;i++){
            if(userBall.get(i) == computerBall.get(i)){
                incrementStrike();
                continue;
            }
            if(computerBall.contains(userBall.get(i))){
                incrementBall();
            }
        }
    }

    private void strikeOutCheck(){
        if(this.strike == THREE_STRIKE && this.ball == NOTHING_BALL){
            this.strikeOut= false;
        }
    }
}
