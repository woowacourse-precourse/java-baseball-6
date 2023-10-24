package baseball.compare;
import baseball.balls.Balls;
public class StrikeCounter {
    private final Integer MAX_CAPACITY = 3;
    private int strikeCountStatus = 0;
    private int arrayIndexStatus = 0;
    public int strikeCount(Balls answerBalls, Balls playerBalls) {
        int answerBall = answerBalls.getBallsList().get(arrayIndexStatus);
        int playerBall = playerBalls.getBallsList().get(arrayIndexStatus);
        if (answerBall == playerBall) {
            strikeCountStatus = strikeCountStatus + 1;
        }
        arrayIndexStatus = arrayIndexStatus + 1;
        if (arrayIndexStatus != MAX_CAPACITY){
            return strikeCount(answerBalls, playerBalls);
        }
        return strikeCountStatus;
    }
}
