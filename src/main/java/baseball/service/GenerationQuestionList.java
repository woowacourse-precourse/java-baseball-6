package baseball.service;

import baseball.config.withinRange;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerationQuestionList {

    private final List<Integer> ballCountList;
    private static final int OUT_COUNT = 3;

    public GenerationQuestionList(ArrayList<Integer> ballCountList) {
        this.ballCountList = ballCountList;
    }

    public List<Integer> generateRandomNumberList(withinRange randomNumberInRange) {

        while (ballCountList.size() < OUT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(randomNumberInRange.startInclusive(),
                    randomNumberInRange.endInclusive());

            if (!includeNumber(randomNumber, ballCountList)) {
                ballCountList.add(randomNumber);
            }
        }
        return ballCountList;
    }

    private boolean includeNumber(int randomNumber, List<Integer> checkedList) {
        if (checkedList.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
