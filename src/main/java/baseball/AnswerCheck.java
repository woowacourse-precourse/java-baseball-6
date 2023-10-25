package baseball;

public class AnswerCheck {
    private final int strike;
    private final int ball;

    public AnswerCheck(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static AnswerCheck checkBalls(AnswerBalls answerBalls, AnswerBalls responseBalls){
        int strike = 0;
        int ball = 0;
        int ballCount = AnswerBalls.ANSWER_LENGTH;

        for (int i = 0; i < ballCount; i++) {
            Ball answerBall = answerBalls.getBallOfIndex(i);
            Ball responseBall = responseBalls.getBallOfIndex(i);
            if (answerBall.equals(responseBall)) {
                strike++;
            } else if (answerBalls.contains(responseBall)){
                ball++;
            }
        }
        return new AnswerCheck(strike, ball);
    }

    public String getCheckingMessage(){
        if(strike == 0 && ball == 0){
            return Message.NOTHING.getMessage();
        } else if(strike == 0){
            return ball + Message.BALL.getMessage();
        } else if(ball == 0){
            return strike + Message.STRIKE.getMessage();
        } else {
            return ball + Message.BALL.getMessage() + " " + strike + Message.STRIKE.getMessage();
        }
    }

    public boolean isAllStrike(){
        return strike == 3;
    }

}
