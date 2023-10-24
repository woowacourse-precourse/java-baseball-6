package baseball.baseballGame;

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


    private Integer countStrike() {
        int strike = 0;
        for (int i = 0; i < numOfDigits; i++) {
            if (targetNums.get(i).equals(userNums.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private Integer countBall(Integer strikeCnt) {
        int ball;
        int tmp = 0;
        for (Integer elem : userNums) {
            if (targetNums.contains(elem)) {
                tmp++;
            }
        }
        ball = tmp - strikeCnt;
        return ball;
    }

    private Boolean isCorrect(Integer strikeCnt) {
        return (numOfDigits.equals(strikeCnt));
    }

    private Boolean isNothing(Integer strikeCnt, Integer ballCnt) {
        return (strikeCnt == 0 && ballCnt == 0);
    }

    public BaseballForm getResult() {
        return result;
    }
}
