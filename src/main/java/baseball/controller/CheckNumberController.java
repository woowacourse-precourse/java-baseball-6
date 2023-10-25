package baseball.controller;

import baseball.model.MatchNumberModel;
import java.util.List;

public class CheckNumberController {

    MatchNumberModel matchNumberModel = new MatchNumberModel();

    public void checkStrike(List<Integer> inputNumberList, int[] numberExist) {
        int number = 0;
        for (int i = 1; i <= inputNumberList.size(); i++) {
            if (isSamePosition(inputNumberList.get(i-1), numberExist, i)) {
                number++;
            }
        }

        matchNumberModel.setStrikeNumber(number);
    }

    public void checkBall(List<Integer> inputNumberList, int[] numberExist) {
        int number = 0;
        for (int i = 1; i <= inputNumberList.size(); i++) {
            if (!isSamePosition(inputNumberList.get(i-1), numberExist, i) && isExistNumber(
                inputNumberList.get(i-1), numberExist)) {
                number++;
            }
        }
        matchNumberModel.setBallNumber(number);
    }

    private boolean isSamePosition(Integer userNumber, int[] numberExist, int position) {
        if (numberExist[userNumber]!=position) {
            return false;
        }
        return true;
    }

    private boolean isExistNumber(Integer userNumber, int[] numberExist) {
        if (numberExist[userNumber]==0) {
            return false;
        }
        return true;
    }

    public Integer getStrikeNumber(){
        return matchNumberModel.getStrikeNumber();
    }

    public Integer getBallNumber() {
        return matchNumberModel.getBallNumber();
    }


}
