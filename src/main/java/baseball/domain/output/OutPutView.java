package baseball.domain.output;

import baseball.dto.Result;
import baseball.util.message.PrintMessage;

public class OutPutView implements Output{
    private static final int TARGET_NUMBER = 3;
    private static final int ZERO_NUMBER = 3;

    @Override
    public void execute(Result result) {
        allBallCheck(result);
        allStrikeCheck(result);
        nothingCheck(result);
    }

    private void nothingCheck(Result result) {
        if(!isStrike(result)&&!isBall(result)){
            System.out.println("낫싱");
        }
    }

    private static void allStrikeCheck(Result result) {
        if(isStrike(result)&&!isBall(result)){
            PrintMessage.allStrikeResultMessage(result);
            isPlayerWin(result);
        }
    }

    private static void isPlayerWin(Result result) {
        if(result.getStrikeCount()==TARGET_NUMBER){
            PrintMessage.congratulationMessage();
        }
    }

    private static void allBallCheck(Result result) {
        if(!isStrike(result) && isBall(result)){
            PrintMessage.allBallResultMessage(result);
        }
    }

    private static boolean isBall(Result result) {
        return result.getBallCount() != ZERO_NUMBER;
    }

    private static boolean isStrike(Result result) {
        return result.getStrikeCount() != ZERO_NUMBER;
    }
}
