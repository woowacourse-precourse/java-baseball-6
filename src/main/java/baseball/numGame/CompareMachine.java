package baseball.numGame;

import baseball.numGame.baseballGame.BaseballForm;
import java.util.List;

public class CompareMachine {
    BaseballForm result;
    List<Integer> targetNums;
    List<Integer> userNums;
    Integer numOfDigits;

    public void compare(List<Integer> targetNums, List<Integer> userNums, Integer numOfDigits) {
        preset(targetNums,userNums,numOfDigits);
        Integer strikeCnt = countStrike();
        Integer ballCnt = countBall(strikeCnt);
        Boolean isNothing = isNothing(strikeCnt, ballCnt);
        Boolean isCorrect = isCorrect(strikeCnt);
        result = new BaseballForm(strikeCnt, ballCnt, isNothing, isCorrect);
    }
    private void preset(List<Integer> targetNums, List<Integer> userNums, Integer numOfDigits){
        this.targetNums = targetNums;
        this.userNums = userNums;
        this.numOfDigits = numOfDigits;
    }



    public BaseballForm getResult() {
        return result;
    }
}
