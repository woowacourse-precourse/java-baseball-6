package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumberList;

    public void initNewComputerNumberList() {
        computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < BaseballUtil.MAX) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
    }

    public Result compareNumbers(List<Integer> inputList) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < BaseballUtil.MAX; i++) {
            if (inputList.get(i).equals(computerNumberList.get(i))) {
                strikeCnt++;
            } else if (computerNumberList.contains(inputList.get(i))) {
                ballCnt++;
            }
        }

        return new Result(strikeCnt, ballCnt);
    }
}
