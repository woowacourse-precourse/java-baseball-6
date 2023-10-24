package baseball;

public class Result {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final int BALL_SIZE = 3;

    private final int ball;
    private final int strike;

    public Result(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isAllStrike(){
        return strike == BALL_SIZE;
    }

    public static Result makeResult(Balls computerBalls, Balls userBalls) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for(int i=0; i<BALL_SIZE; i++){
            int userBall = userBalls.getBall(i);
            for(int j=0; j<BALL_SIZE; j++){
                int computerBall = computerBalls.getBall(j);
                if(userBall == computerBall) {
                    if(i == j) strikeCnt++;
                    else ballCnt++;
                }
            }
        }
        return new Result(ballCnt, strikeCnt);
    }

    public static void printResult(Result result){
        StringBuilder sb = new StringBuilder();
        if (result.strike == 0 && result.ball == 0) sb.append(NOTHING);
        else {
            if(result.ball != 0) sb.append(result.ball).append(BALL).append(" ");
            if(result.strike != 0) sb.append(result.strike).append(STRIKE);
        }
        System.out.println(sb);
    }
}
