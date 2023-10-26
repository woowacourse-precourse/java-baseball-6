package baseball.controller;
import baseball.view.JudgeBallCountView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum BallCount{
    STRIKE,
    BALL;
    public int value(){
        return ordinal();
    }
}

public class GameUtils {
    private static final int MAX_STRIKE = 3;
    public static List<Integer> compareNumbers(String playerNumber, List<Integer> computerNumber) {
        final int STRIKE = 0;
        final int BALL = 1;
        List<Integer> ballCount = Arrays.asList(0, 0);

        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumber.get(i);

            for (int j = 0; j < 3; j++) {
                int playerDigit = playerNumber.charAt(j) - '0';
                if (playerDigit == computerDigit) {
                    if (i == j) {
                        ballCount.set(STRIKE, ballCount.get(STRIKE) + 1);
                    } else {
                        ballCount.set(BALL, ballCount.get(BALL) + 1);
                    }
                }
            }
        }

        return ballCount;
    }

    public boolean isValidInputForm(String target){
        boolean flag = true;
        Set<Object> set = new HashSet<>();

        if (target.length() != 3){
            flag = false;
        }
        for (int i = 0; i < target.length(); i++){
            char indexValue = target.charAt(i);
            if (!Character.isDigit(indexValue) || !(('0' < indexValue)&&(indexValue <= '9')))
                flag = false;

            else if(!set.add(indexValue)){
                flag = false;
            }
        }

        return flag;
    }
    public static void GameTurnResult(List<Integer> gameTurnResult) {
        if (GameUtils.isNothing(gameTurnResult)){
            JudgeBallCountView.judgeNothing();
        }
        if (isCount(gameTurnResult, BallCount.BALL.value())){
            JudgeBallCountView.judgeBall(gameTurnResult.get(BallCount.BALL.value()));
        }
        if (isCount(gameTurnResult, BallCount.STRIKE.value())){
           JudgeBallCountView.judgeStrike(gameTurnResult.get(BallCount.STRIKE.value()));
        }
    }

    public static boolean isGameOver(List<Integer> gameTurnResult) {
        return gameTurnResult.get(BallCount.STRIKE.value()) == MAX_STRIKE;
    }
    public static boolean isNothing(List<Integer> gameTurnResult) {
        return gameTurnResult.get(BallCount.BALL.value()) == 0 &&
                gameTurnResult.get(BallCount.STRIKE.value()) == 0;
    }
    public static boolean isCount(List<Integer> gameTurnResult, int index){
        return gameTurnResult.get(index) != 0;
    }
}