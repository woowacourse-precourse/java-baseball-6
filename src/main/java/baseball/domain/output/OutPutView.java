package baseball.domain.output;

import baseball.dto.Result;
import baseball.util.message.PrintMessage;

public class OutPutView implements Output{
    private static final int TARGET_NUMBER = 3;
    private static final int ZERO_NUMBER = 0;

    @Override
    public void execute(Result result) {
        ballAndStrikeCheck(result);
        allBallCheck(result);
        allStrikeCheck(result);
        nothingCheck(result);

    }

    private void ballAndStrikeCheck(Result result) {
        if(isStrike(result)&&isBall(result)){
            PrintMessage.ballAndStrikeMessage(result);
        }
    }

    private void nothingCheck(Result result) {
        if(!isStrike(result)&&!isBall(result)){
            PrintMessage.nothingCheckMessage(result);
        }
    }

    private void allStrikeCheck(Result result) {
        if(isStrike(result)&&!isBall(result)){
            PrintMessage.allStrikeResultMessage(result);
            isPlayerWin(result);
        }
    }

    private void isPlayerWin(Result result) {
        if(result.getStrikeCount()==TARGET_NUMBER){
            PrintMessage.congratulationMessage();
        }
    }

    private void allBallCheck(Result result) {
        if(!isStrike(result) && isBall(result)){
            PrintMessage.allBallResultMessage(result);
        }
    }

    private boolean isBall(Result result) {
        return result.getBallCount() != ZERO_NUMBER;
    }

    private boolean isStrike(Result result) {
        return result.getStrikeCount() != ZERO_NUMBER;
    }
}
